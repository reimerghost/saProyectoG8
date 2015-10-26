/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.sa.g8.banco.email;

import com.usac.sa.g8.banco.utils.bddConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public String establecerCuerpo(int tipo, String nombre, String apellido, int no_cuenta, double monto) {
        String body = "";
        switch (tipo) {
            case 1:
                body = "<h1>Se ha acreditado a tu cuenta una nueva remesa</h1><br/>"
                        + "Estimado Sr(a). " + nombre + " " + apellido + ", <br/>"
                        + "Informamos que a su cuenta No " + no_cuenta + ", ha sido acreditada una remesa con un valor"
                        + " de Q. " + monto + "."
                        + "<br/><br/>"
                        + "Gracias por su preferencia";
                return body;
            case 2:
                body = "<h1>Su prestamo ha sido abonado con una remesa</h1><br/>"
                        + "Estimado Sr(a).  " + nombre + " " + apellido + ", <br/>"
                        + "Informamos que a su Prestamo No  " + no_cuenta + ", ha sido abonado por medio de una remesa, con el valor"
                        + " de  Q. " + monto + ". </br>"
                        + "Su saldo pendiente de prestamo es de XXX."
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

    private String[] getDatosCliente(int id_cta,int tipo) {
        String tabla = "";
        String[] datos = {"nombre", "apellidos", "rchamale10@gmail.com"};
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        boolean r = false;
        if(tipo==1){
            tabla = "cuenta";
        }
        if(tipo==2){
            tabla = "prestamo";            
        }
        
        String selectLogin = "select nombre, apellido, email from "+tabla+" c where id_cuenta = ?";

        try {
            dbConnection = bddConnection.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectLogin);
            //preparedStatement = dbConnection.prepareStatement(updateTableSQL);

            preparedStatement.setInt(1, id_cta);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                datos[0] = rs.getString("nombre");
                datos[1] = rs.getString("apellido");
                datos[2] = rs.getString("email");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                }
            }
            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                }
            }
        }
        return datos;
    }

    public void enviarEmail(int tipo, int no_cuenta, double monto) {
        //compose message  
        String[] datos;
//        datos = getDatosCliente(no_cuenta,tipo);
        try {
            // Mensaje MIME default.
            MimeMessage message = new MimeMessage(session);
            // EMISOR
            message.setFrom(new InternetAddress(EMAIL_EMISOR));//change accordingly 
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("rchamale10@gmail.com"));
            // Set Subject: header field
            message.setSubject(establecerAsunto(tipo));
            // Send the actual HTML message, as big as you like
            message.setContent(establecerCuerpo(tipo, "Sergio", "Narez", no_cuenta, monto), "text/html");
            // ENVIA EL CORREO
            Transport.send(message);
            System.out.println("Mensaje enviado!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
