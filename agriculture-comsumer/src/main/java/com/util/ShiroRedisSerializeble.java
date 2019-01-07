package com.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;

import org.crazycake.shiro.exception.SerializationException;
import org.crazycake.shiro.serializer.ObjectSerializer;
import org.crazycake.shiro.serializer.RedisSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.SerializationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.type.TypeFactory;

@Component
public class ShiroRedisSerializeble implements RedisSerializer<Object> {

	public static final int BYTE_ARRAY_OUTPUT_STREAM_SIZE = 128;
	Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(
			Object.class);

	public ShiroRedisSerializeble() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
	}

	@Override
	public byte[] serialize(Object object) throws SerializationException {
		byte[] result = new byte[0];

		if (object == null) {
			return result;
		}
		if (!(object instanceof Serializable)) {
			throw new SerializationException("requires a Serializable payload " + "but received an object of type ["
					+ object.getClass().getName() + "]");
		}
		
			result = jackson2JsonRedisSerializer.serialize(object);

		return result;
	}

	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		Object result = null;

		if (bytes == null || bytes.length == 0) {
			return result;
		}

			result =jackson2JsonRedisSerializer.deserialize(bytes);

		return result;
	}

}
