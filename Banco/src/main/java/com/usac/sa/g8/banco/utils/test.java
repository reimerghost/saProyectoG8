/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.sa.g8.banco.utils;

import com.usac.sa.g8.banco.email.notificacionEmail;
import java.sql.SQLException;

/**
 *
 * @author Reimer
 */
public class test {

    public static void main(String[] argv) {
        notificacionEmail nemail = new notificacionEmail();
            nemail.enviarEmail(1, 4, 15);
        
    }
}
