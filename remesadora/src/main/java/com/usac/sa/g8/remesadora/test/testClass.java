/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.sa.g8.remesadora.test;

import com.usac.sa.g8.remesadora.utils.bddConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntu
 */
public class testClass {
    
    
    
    public boolean nuevaCuenta(int id, String cadena) {
        boolean resp = false;
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertCliente = "insert into example(id,data)"
                + "values( ? , ? )";

        try {
            dbConnection = bddConnection.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertCliente);
            //preparedStatement = dbConnection.prepareStatement(updateTableSQL);

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, cadena);

            preparedStatement.executeUpdate();
            //id = this.getID(usuario,password);
            System.out.println("Cuenta Insertado!");
            resp = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                    //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return resp;
    }
}
