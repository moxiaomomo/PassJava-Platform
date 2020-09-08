package com.moxiaomomo.chat.socket;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.MultiValueMap;
import org.yeauty.annotation.*;
import org.yeauty.pojo.Session;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(path = "/ws/{roomID}/{clientID}", host = "${ws.host}",port = "${ws.port}")
public class MyWebSocket {
    private static final Logger logger = LoggerFactory.getLogger(MyWebSocket.class);
    // map: roomID -> HashSet<Session> (每种状态机对应的实体对象的连接session)
    private static final Map<String, Set<Session>> rooms = new ConcurrentHashMap<String, Set<Session>>();
    // map: sessionID -> roomID (ws连接的会话id)
    private static final Map<String, String> clients = new ConcurrentHashMap<String, String>();

    @BeforeHandshake
    public void handshake(Session session, HttpHeaders headers, @RequestParam String req, @RequestParam MultiValueMap reqMap, @PathVariable String arg, @PathVariable Map pathMap){
        session.setSubprotocols("stomp");
        if (req != null && !req.equals("ok")){
            logger.info("Authentication failed!");
            session.close();
        }
        logger.info("pathMap: " + String.valueOf(pathMap));
    }

    @OnOpen
    public void onOpen(Session session, HttpHeaders headers, @RequestParam String req, @RequestParam MultiValueMap reqMap, @PathVariable String arg, @PathVariable Map pathMap){
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
        clients.put(session.id().toString(), roomID);
        logger.info("new connection, roomID: " + roomID + " connCount: " + rooms.get(roomID).size());
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        logger.info("one connection closed");
        String roomID = clients.get(session.id().toString());
        if (roomID != null) {
            rooms.get(roomID).remove(session);
            clients.remove(session.id().toString());
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        String roomID = clients.get(session.id().toString());
        if (roomID != null) {
            rooms.get(roomID).remove(session);
            clients.remove(session.id().toString());
        }
        throwable.printStackTrace();
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        // session.sendText("Hello xbyy!");
        String roomID = clients.get(session.id().toString());
        if (roomID == null) {
            session.sendText("Invalid room.");
            return;
        }
        for (Session tmpSession : rooms.get(roomID)) {
            logger.info("to send message to " + tmpSession.id().toString());
            tmpSession.sendText(message);
        }
    }

    @OnBinary
    public void onBinary(Session session, byte[] bytes) {
//        for (byte b : bytes) {
//            System.out.println(b);
//        }
        logger.info(String.valueOf(bytes));
//        session.sendBinary(bytes);
        String roomID = clients.get(session.id().toString());
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
}