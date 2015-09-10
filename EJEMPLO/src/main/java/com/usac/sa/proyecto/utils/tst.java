package com.usac.sa.proyecto.utils;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class tst {

    public static void main(String[] argv) {

        try {

            update();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    private static void insertRecordIntoTable() throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO EMP"
                + "(EMPNO, ENAME, JOB, MGR,HIREDATE, SAL,COMM, DEPTNO) VALUES"
                + "(?,?,?,?,?,?,?,?)";

        try {
            dbConnection = bddConnection.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, 12);
            preparedStatement.setString(2, "Reimer");
            preparedStatement.setString(3, "system");
            preparedStatement.setInt(4, 7839);
            preparedStatement.setTimestamp(5, bddConnection.getCurrentTimeStamp());
            preparedStatement.setInt(6, 10000);
            preparedStatement.setInt(7, 500);
            preparedStatement.setInt(8, 10);

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            System.out.println("Record is inserted into DBUSER table!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    private static void update() throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String updateTableSQL = "UPDATE EMP SET ENAME = ?, JOB = ? WHERE EMPNO > ?";

        try {
            dbConnection = bddConnection.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(updateTableSQL);

            preparedStatement.setString(1, "TEST");
            preparedStatement.setString(2, "system");
            preparedStatement.setInt(3, 7654);

            // execute insert SQL stetement
            preparedStatement.executeUpdate();
            System.out.println("Record is inserted into DBUSER table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private void select() {
        try {
//step1 load the driver class  
            Class.forName("oracle.jdbc.driver.OracleDriver");

//step2 create  the connection object  
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "admin", "1234");

//step3 create the statement object  
            Statement stmt = con.createStatement();
//step4 execute query  
            ResultSet rs = stmt.executeQuery("select * from emp");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }

//step5 close the connection object  
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
