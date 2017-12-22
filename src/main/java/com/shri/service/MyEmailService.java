package com.shri.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author shrisowdhaman
 * Dec 18, 2017
 */
@Service
public class MyEmailService  {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JavaMailSender javaMailSender;
	 
	public void sendOtpMessage(String to, String subject, String message) {
		 
		 SimpleMailMessage simpleMailMessage = new SimpleMailMessage(); 
		 simpleMailMessage.setTo(to); 
		 simpleMailMessage.setSubject(subject); 
		 simpleMailMessage.setText(message);
		 
		 logger.info(subject);
		 logger.info(to);
		 logger.info(message);
		 
		 //Uncomment to send mail
		 //javaMailSender.send(simpleMailMessage);
	}
}
