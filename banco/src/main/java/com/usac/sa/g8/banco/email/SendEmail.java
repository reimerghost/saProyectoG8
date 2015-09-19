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

    public static void main(String[] args) {
        notificacionEmail ne = new notificacionEmail();
        ne.setRemitente("rchamale10@gmail.com");
        ne.enviarEmail(2);
    }
}
