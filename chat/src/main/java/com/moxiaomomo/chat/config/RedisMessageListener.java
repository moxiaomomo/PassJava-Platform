package com.moxiaomomo.chat.config;

import com.moxiaomomo.chat.socket.ChatWebSocket;
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
        chatSocket.handleRedisMessage(message, pattern);
    }
}
