/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.sa.proyecto;

import com.usac.sa.proyecto.utils.bddConnection;
import java.sql.SQLException;

/**
 *
 * @author Reimer
 */
public class run {

    public static void main(String[] argv) {
        Cuenta c = new Cuenta();
        System.out.println(c.AgregarMonto(3, 555));
    }
}
