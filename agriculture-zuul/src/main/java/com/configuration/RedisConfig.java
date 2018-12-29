package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;



@Configuration
public class RedisConfig {

	@SuppressWarnings("rawtypes")
	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory conn)
	{
		RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<Object,Object>();
		redisTemplate.setConnectionFactory(conn);
		ObjectMapper objectMapper = new ObjectMapper();
		 objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
	        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
		
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		return redisTemplate;
		
	}
	
	
	@SuppressWarnings("rawtypes")
	@Bean
	public RedisTemplate<String, Object> stringRedisTemplate(RedisConnectionFactory conn)
	{
		RedisTemplate<String,Object> redisTemplate = new RedisTemplate<String,Object>();
		redisTemplate.setConnectionFactory(conn);
		ObjectMapper objectMapper = new ObjectMapper();
		 objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
	        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
		
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		return redisTemplate;
		
	}
}
