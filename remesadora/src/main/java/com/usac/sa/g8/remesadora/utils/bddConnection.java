/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.sa.g8.remesadora.utils;

/**
 *
 * @author Reimer
 */
import java.sql.*;

public class bddConnection {

    //private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    // ------------------------ //
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";
    private static final String dbName = "remesadoraG8";

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

}
