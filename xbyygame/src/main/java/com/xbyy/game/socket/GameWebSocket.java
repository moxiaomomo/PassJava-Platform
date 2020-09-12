package com.xbyy.game.socket;

import com.xbyy.game.dao.ChatRedisDao;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.Message;
import org.springframework.util.MultiValueMap;
import org.yeauty.annotation.*;
import org.yeauty.pojo.Session;
import com.alibaba.fastjson.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(path = "/ws/{roomID}/{clientID}", host = "${ws.host}",port = "${ws.port}")
public class GameWebSocket {
    @Value("${redis.chat.topic}")
    private String redisChatTopic;
    @Autowired
    ChatRedisDao redisDao;

    private static final Logger logger = LoggerFactory.getLogger(GameWebSocket.class);
    // map: roomID -> HashSet<Session> (每种状态机对应的实体对象的连接session)
    private static final Map<String, Set<Session>> rooms = new ConcurrentHashMap<String, Set<Session>>();
    // map: sessionID -> roomID (ws连接的会话id)
    private static final Map<String, String> session2room = new ConcurrentHashMap<String, String>();
    // map: sessionID -> clientID (ws连接的会话id)
    private static final Map<String, String> session2uid = new ConcurrentHashMap<String, String>();

    @BeforeHandshake
    public void handshake(Session session, HttpHeaders headers, @RequestParam String req, @RequestParam MultiValueMap reqMap, @PathVariable String arg, @PathVariable Map pathMap){
        session.setSubprotocols("stomp");
        if (req != null && !req.equals("ok")){
            logger.info("Authentication failed!");
            session.close();
        }
        logger.debug("pathMap: " + String.valueOf(pathMap));
    }

    @OnOpen
    public void onOpen(Session session, HttpHeaders headers, @RequestParam String req, @RequestParam MultiValueMap reqMap, @PathVariable String arg, @PathVariable Map pathMap){
        String sid = session.id().toString();
        String roomID = (String)pathMap.get("roomID");
        String clientID = (String)pathMap.get("clientID");
        if (!rooms.containsKey(roomID)) {
            // room不存在时，创建room
            Set<Session> room = new HashSet<Session>();
            room.add(session);
            rooms.put(roomID, room);
        } else {
            // room存在，直接添加用户到对应room
            rooms.get(roomID).add(session);
        }
        session2room.put(sid, roomID);
        session2uid.put(sid, clientID);

        // publish message to redis
        JSONObject msg = new JSONObject();
        msg.put("event", "enter");
        msg.put("room", roomID);
        msg.put("user", clientID);
        redisDao.sendMessage(redisChatTopic, msg.toJSONString());

        logger.info("new connection, roomID: " + roomID + " connCount: " + rooms.get(roomID).size());
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        logger.info("one connection closed");
        this.handleDisconnected(session);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        this.handleDisconnected(session);
        throwable.printStackTrace();
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        // session.sendText("Hello xbyy!");
        String roomID = session2room.get(session.id().toString());
        if (roomID == null) {
            session.sendText("Invalid room.");
            return;
        }
        for (Session tmpSession : rooms.get(roomID)) {
            logger.debug("to send message to " + tmpSession.id().toString());
            tmpSession.sendText(message);
        }
    }

    @OnBinary
    public void onBinary(Session session, byte[] bytes) {
        logger.debug(String.valueOf(bytes));
//        session.sendBinary(bytes);
        String roomID = session2room.get(session.id().toString());
        if (roomID == null) {
            session.sendText("Invalid room.");
            return;
        }
        for (Session tmpSession : rooms.get(roomID)) {
            tmpSession.sendBinary(bytes);
        }
    }

    @OnEvent
    public void onEvent(Session session, Object evt) {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            switch (idleStateEvent.state()) {
                case READER_IDLE:
                    logger.info("read idle");
                    break;
                case WRITER_IDLE:
                    logger.info("write idle");
                    break;
                case ALL_IDLE:
                    logger.info("all idle");
                    break;
                default:
                    break;
            }
        }
    }

    public void handleDisconnected(Session session) {
        String sid = session.id().toString();
        String roomID = session2room.get(sid);
        if (roomID != null) {
            // publish message to redis
            JSONObject msg = new JSONObject();
            msg.put("event", "leave");
            msg.put("room", roomID);
            msg.put("user", session2uid.get(sid));
            redisDao.sendMessage(redisChatTopic, msg.toJSONString());

            rooms.get(roomID).remove(session);
            session2room.remove(sid);
            session2uid.remove(sid);
        }
    }

    public void handleRedisMessage(Message message, byte[] pattern) {
        String body = new String(message.getBody());
        logger.debug(body);

        JSONObject  jsonObject = JSONObject.parseObject(body);
        String roomID = (String)jsonObject.get("room");
        for (Session tmpSession : rooms.get(roomID)) {
            tmpSession.sendText(body);
        }
    }
}