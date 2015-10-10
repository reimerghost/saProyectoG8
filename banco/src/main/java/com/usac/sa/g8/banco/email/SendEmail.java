// File Name SendEmail.java
package com.usac.sa.g8.banco.email;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

    public static void main(String[] args) throws UnsupportedEncodingException {
        // Recipient's email ID needs to be mentioned.
        String emailTo = "rchamale10@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "no-reply@gmail.com";

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");  
  props.put("mail.smtp.socketFactory.port", "465");  
  props.put("mail.smtp.socketFactory.class",  
            "javax.net.ssl.SSLSocketFactory");  
  props.put("mail.smtp.auth", "false");  
  props.put("mail.smtp.port", "465");  


        // Get the default Session object.
        //Session session = Session.getDefaultInstance(properties);
        Session session = Session.getDefaultInstance(props);

        try {
            String subject = "Email Subject";
            MimeMessage message = new MimeMessage(session);
           // message.setSender(new InternetAddress("no-reply@domain.com", "Sender Name"));
            message.setFrom(new InternetAddress("Sender Name" + "<" + "no-reply@domain.com" + ">"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailTo));
            message.setSubject(subject);
            //String content = writer.toString();
            message.setContent("ssss", "text/html; charset=UTF-8");

            Transport.send(message);
            //logger.debug("Email sent");
            //return true;
            System.out.println("ENVIADO");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
