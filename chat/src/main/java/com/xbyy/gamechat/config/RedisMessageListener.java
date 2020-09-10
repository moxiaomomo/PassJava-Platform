package com.xbyy.gamechat.config;

import com.xbyy.gamechat.socket.ChatWebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RedisMessageListener implements MessageListener {
    @Autowired
    private ChatWebSocket chatSocket;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 接收并处理redis发布的信息
        chatSocket.handleRedisMessage(message, pattern);
    }
}
