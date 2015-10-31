/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.sa.g8.banco.utils;

/**
 *
 * @author Reimer
 */
import java.sql.*;

public class bddConnection {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    // ------------------------ //
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";
    private static final String dbName = "bancoG8";
       
    public static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION + dbName, DB_USER,
          DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    public static java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }
    
    public static void main(String[] args) {
        String tabla = "";
        String selectLogin = "";
        String[] datos = {"nombre", "apellidos", "rchamale10@gmail.com"};
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        boolean r = false;
//        if (tipo == 1) {
            selectLogin = "select nombre, apellido, email from cuenta c where id_cuenta = ?";
//        }
//        if (tipo == 2) {
//            selectLogin = "select nombre, apellido, email from prestamo p where id_prestamo = ?";
//        }

        try {
            dbConnection = bddConnection.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectLogin);

            preparedStatement.setInt(1, 4);
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
    }

}
