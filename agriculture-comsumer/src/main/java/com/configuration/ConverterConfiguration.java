package com.configuration;

import java.sql.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class ConverterConfiguration {

	@Bean
	public Converter<String,Date> configConverter(){
		
		return null;
	}
}
