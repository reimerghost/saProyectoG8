package com.usac.sa.g8.banco.email;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author reimer
 */
public class notificacionEmail {

    private String SendTo = "";
    Properties props;
    Session session;

    //Datos de autenticacion
    private static final String EMAIL_EMISOR = "g8.sa2015@gmail.com";
    private static final String PASSWORD = "sacamos100";

    public notificacionEmail() {
        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(EMAIL_EMISOR, PASSWORD);//change accordingly  
                    }
                });
    }

    public void setRemitente(String email) {
        SendTo = email;
    }

    public String establecerCuerpo(int tipo) {
        String body = "";
        switch (tipo) {
            case 1:
                body = "<h1>Se ha acreditado a tu cuenta una nueva remesa</h1><br/>"
                        + "Estimado Sr(a). Cliente, <br/>"
                        + "Informamos que a su cuenta No "+getCodBanco()+", ha sido acreditada una remesa con un valor"
                        + " de Q."+getMonto()+"."
                        + "<br/><br/>"
                        + "Gracias por su preferencia";
                return body;
            case 2:
                body = "<h1>Su prestamo ha sido abonado con una remesa</h1><br/>"
                        + "Estimado Sr(a). XXX, <br/>"
                        + "Informamos que a su Prestamo No XXX, ha sido abonado por medio de una remesa, con el valor"
                        + " de XXX. </br>"
                        + "Su actual saldo pendiente de prestamo es de: XXX."
                        + "<br/><br/>"
                        + "Gracias por su preferencia";
                return body;

        }
        return body;
    }

    public String establecerAsunto(int tipo) {
        switch (tipo) {
            case 1:
                return "Tu cuenta ha sido acreditada por una remesa.";
            case 2:
                return "Su prestamo ha sido abonado con una remesa recibida.";
        }
        return null;
    }

    public void enviarEmail(int tipo) {
        //compose message  
        try {
            // Mensaje MIME default.
            MimeMessage message = new MimeMessage(session);
            // EMISOR
            message.setFrom(new InternetAddress(EMAIL_EMISOR));//change accordingly 
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(SendTo));
            // Set Subject: header field
            message.setSubject(establecerAsunto(tipo));
            // Send the actual HTML message, as big as you like
            message.setContent(establecerCuerpo(tipo), "text/html");
            // ENVIA EL CORREO
            Transport.send(message);
            System.out.println("Mensaje enviado!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private String getCodBanco() {
        return "08001";
    }

    private String getMonto() {
        return "555";
    }
}
