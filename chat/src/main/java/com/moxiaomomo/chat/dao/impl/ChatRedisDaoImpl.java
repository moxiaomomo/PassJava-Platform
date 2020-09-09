package com.moxiaomomo.chat.dao.impl;

import com.moxiaomomo.chat.dao.ChatRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component("ChatRedisDao")
public class ChatRedisDaoImpl implements ChatRedisDao {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void sendMessage(String channel, String message) {
        redisTemplate.convertAndSend(channel, message);
    }

    @Override
    public void sendMessageByOpen(String channel, String message) {
        redisTemplate.convertAndSend(channel, message);
    }
}