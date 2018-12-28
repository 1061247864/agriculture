package com.configuration;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;

import com.util.DateFormateConverter;


@ConfigurationProperties(prefix="converter.date")
@Configuration
public class ConverterConfiguration {
	
 private List<String> formats;
 
    @SuppressWarnings("rawtypes")
	@Bean
	public Converter configConverter(){
		
    	for (String string : formats) {
			System.out.println(string);
		}
		return new DateFormateConverter(formats);
	
	}
    
    
	public List<String> getFormat() {
		return formats;
	}
	public void setFormat(List<String> format) {
		this.formats = format;
	}
	
	
	
	
}
