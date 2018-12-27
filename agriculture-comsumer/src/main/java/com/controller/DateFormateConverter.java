package com.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.convert.converter.Converter;

@ConfigurationProperties(prefix="date.converter")
public class DateFormateConverter implements Converter<String, Date> {

	
	@Override
	public Date convert(String source) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("");
		return null;
	}

}
