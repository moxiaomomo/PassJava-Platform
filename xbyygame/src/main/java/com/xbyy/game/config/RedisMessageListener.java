package com.xbyy.game.config;

import com.xbyy.game.socket.GameWebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RedisMessageListener implements MessageListener {
    @Autowired
    private GameWebSocket chatSocket;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 接收并处理redis发布的信息
        chatSocket.handleRedisMessage(message, pattern);
    }
}
