package com.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="mail.userRegistry")
public class MailClient {

	@Autowired
	JavaMailSenderImpl javaMailSenderImpl;
	
	String subject="";
	
	String updataAddress="";
	
	String context="";
	
	public void sendMail(String to,String userCode) throws MessagingException {
		MimeMessage createMimeMessage = javaMailSenderImpl.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(createMimeMessage);
		messageHelper.setTo(to);
		messageHelper.setSubject(subject);
		messageHelper.setText("<a href='"+updataAddress+"userCode="+userCode+"'>"+context+"</a>",true);
		messageHelper.setFrom(javaMailSenderImpl.getUsername());
		javaMailSenderImpl.send(createMimeMessage);
		
		
	}

	
	public String getContext() {
		return context;
	}


	public void setContext(String context) {
		this.context = context;
	}


	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getUpdataAddress() {
		return updataAddress;
	}

	public void setUpdataAddress(String updataAddress) {
		this.updataAddress = updataAddress;
	}
	
	
}
