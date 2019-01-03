package com.configuration;

import org.crazycake.shiro.exception.SerializationException;
import org.crazycake.shiro.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ShiroRedisSerializeble implements RedisSerializer<Object> {

	@Override
	public byte[] serialize(Object t) throws SerializationException {

		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(
				Object.class);
		jackson2JsonRedisSerializer.setObjectMapper(new ObjectMapper());
		return jackson2JsonRedisSerializer.serialize(t);
	}

	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(
				Object.class);
		jackson2JsonRedisSerializer.setObjectMapper(new ObjectMapper());
		Object deserialize = jackson2JsonRedisSerializer.deserialize(bytes);
		return deserialize;
	}

}
