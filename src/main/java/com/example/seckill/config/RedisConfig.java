package com.example.seckill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        //Key序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //Value序列化
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        //Hash类型Key序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //Hash类型Value序列化
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());

        //注入连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
