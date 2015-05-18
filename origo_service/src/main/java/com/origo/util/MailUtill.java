package com.origo.util;

import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.codec.digest.DigestUtils;

public class MailUtill {
	
	public   void mailSender( String email,String token) {
		  final String username = "slvitest03@gmail.com";
		 final String password = "test@123";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("slvitest03@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("lakhandman@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!\n \n" +"http://localhost:8080/forgotpasswordtoken/userprofile/forgotpassword?"+"token="+token+"&"+"email="+email);
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	public static String tokenGenarator(String name) {
		return DigestUtils.md5Hex(name);
		
	}

}
