package com.estore;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class GmailConfig {
  @Bean
  public JavaMailSender getJavaMailSender() {
	  JavaMailSenderImpl sender = new JavaMailSenderImpl();
	  
	  sender.setDefaultEncoding("utf-8");
	  sender.setHost("smtp.gmail.com");
	  sender.setPort(587);
	  sender.setUsername("mailamvu5799@gmail.com");
	  sender.setPassword("congumoiquen.");
	  Properties props = sender.getJavaMailProperties();
	
	  props.put("mail.transport.protocol", "smtp");
	  props.put("mail.smtp.auth", "true");
	  props.put("mail.smtp.starttls.enable", "true");
	  props.put("mail.debug", "true");
	 sender.setJavaMailProperties(props);
	  return sender;
  }
}
