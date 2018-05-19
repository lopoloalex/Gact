package es.upm.dit.isst.web.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class EmailHandler {

	private Properties props = new Properties();
	private static EmailHandler instancia;
	
	public static EmailHandler getInstance(){
		if ( null == instancia ) {
			instancia = new EmailHandler ();
		}
		return instancia;
	}
	
	public EmailHandler() {
		String host="localhost";
		props.put("mail.smtp.host",host);
	}

	public void sendEmail(String from, String to, String subject, String body) {
		Session session = Session.getDefaultInstance(props);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			message.setSubject(subject);
			message.setText(body);
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
