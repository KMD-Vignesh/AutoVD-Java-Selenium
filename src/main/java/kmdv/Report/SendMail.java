package kmdv.Report;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import kmdv.Common.BaseUtil;

public class SendMail extends BaseUtil {

	public SendMail(String host, String port, String from, String pass, String to, String subject, String body,
			String attachment) {

		Properties props = System.getProperties();

		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", port);

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getInstance(props,new javax.mail.Authenticator() {
            
            //override the getPasswordAuthentication method
            protected PasswordAuthentication
                           getPasswordAuthentication() {
                                        
                return new PasswordAuthentication(from,
                		pass);
            }
          });
		MimeMessage message = new MimeMessage(session);

		try {

			message.setFrom(new InternetAddress(from));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.setSubject(subject);

			BodyPart objMessageBodyPart = new MimeBodyPart();

			objMessageBodyPart.setText(body);

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(objMessageBodyPart);

			objMessageBodyPart = new MimeBodyPart();

			DataSource source = new FileDataSource(attachment);

			objMessageBodyPart.setDataHandler(new DataHandler(source));

			objMessageBodyPart.setFileName(attachment);

			multipart.addBodyPart(objMessageBodyPart);

			message.setContent(multipart);

			Transport transport = session.getTransport("smtp");

			transport.connect(host, from, pass);

			transport.sendMessage(message, message.getAllRecipients());

			transport.close();

		}

		catch (Exception ae) {

			ae.printStackTrace();

		}

	}

}
