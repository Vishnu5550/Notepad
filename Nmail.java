package ita;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Nmail {
	public void sendotp(String a,int rand){  
		 String to = a;
	     String from = "indianeditor.india.in@gmail.com";
	     Properties pro=new Properties();
	     pro.put("mail.smtp.auth","true");
	     pro.put("mail.smtp.starttls.enable", "true");
	     pro.put("mail.smtp.host", "smtp.gmail.com");
	     pro.put("mail.smtp.port", 587);
	     Session session = Session.getDefaultInstance(pro,new javax.mail.Authenticator()
	   		  {
	   	  		protected PasswordAuthentication getPasswordAuthentication() {
	   	  			return new PasswordAuthentication("indianeditor.india.in@gmail.com","indian@india");
	   	  		}
	   		  });
	     try {
	        MimeMessage message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(from));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	        message.setSubject("This is OTP from \" INDIAN Editor \" to verify your GMail Account");
	        message.setText(rand+" This is OTP for login in javaprojects "+"\n"+"don't  share this otp to other ."
	        		+ "\n If you not login leave it...");
	        
	        Transport.send(message);
	        System.out.println("Sent message successfully...."); 
	  
	      }catch (MessagingException mex) {mex.printStackTrace();}  
	   } 
	public void sendsucs(String a){  
		
		 String to = a;
	     String from = "indianeditor.india.in@gmail.com";
	     Properties pro=new Properties();
	     pro.put("mail.smtp.auth","true");
	     pro.put("mail.smtp.starttls.enable", "true");
	     pro.put("mail.smtp.host", "smtp.gmail.com");
	     pro.put("mail.smtp.port", 587);
	     Session session = Session.getDefaultInstance(pro,new javax.mail.Authenticator()
	   		  {
	   	  		protected PasswordAuthentication getPasswordAuthentication() {
	   	  			return new PasswordAuthentication("indianeditor.india.in@gmail.com","indian@india");
	   	  		}
	   		  });
	     try {
	        MimeMessage message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(from));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	        message.setSubject(" \" INDIAN Editor \" sucessfully verify your GMail Account");
	        message.setText(" Your MailID is sucessfully verified!!");
	        
	        Transport.send(message);
	        System.out.println("Sent message successfully...."); 
	  
	      }catch (MessagingException mex) {mex.printStackTrace();}  
	   } 
}
