package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.core.convert.converter.Converter;


public class DateFormateConverter implements Converter<String, Date> {

	 private List<String> formats;
	 private SimpleDateFormat simpleDateFormat ;
	 
	 public DateFormateConverter(List<String> formats) {
		 this.formats=formats;
	 }
	@Override
	public Date convert(String source) {
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if(null==formats)
		{
			formats =Arrays.asList("yyyy-MM-dd");
		}
		for (String format : formats) {
			simpleDateFormat.applyPattern(format);
			 try {
				Date result = simpleDateFormat.parse(source);
				if(result!=null)
				{
					return result;
				}
			} catch (ParseException e) {
				continue;
			}
		}
		return null;
	}

}
