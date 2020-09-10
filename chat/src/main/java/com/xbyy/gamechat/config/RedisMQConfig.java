package com.xbyy.gamechat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
@EnableCaching
public class RedisMQConfig {
    @Value("${redis.chat.topic}")
    public String redisChatTopic;

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        // 可以添加多个 messageListener，用以配置不同的交换机
        container.addMessageListener(listenerAdapter, new PatternTopic(redisChatTopic));
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(RedisMessageListener receiver) {
        // 其中一个消息适配器
        return new MessageListenerAdapter(receiver, "onMessage");
    }

    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }
}
