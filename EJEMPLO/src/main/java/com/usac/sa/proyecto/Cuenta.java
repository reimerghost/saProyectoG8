/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.sa.proyecto;

import com.usac.sa.proyecto.utils.bddConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Reimer
 */
public class Cuenta {

    private int idCliente, idCuenta;
    private float saldo;
    private Cliente cliente;

    public Cuenta(int idCuenta) {
        this.getCuenta(idCuenta);
    }

    public Cuenta() {

    }

    public boolean nuevaCuenta(int cli, float saldoInicial) {
        this.setIdCliente(cli);
        this.setSaldo(saldoInicial);
        boolean resp = false;
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertCliente = "insert into cuenta(SALDO,IDCLIENTE)"
                + "values( ? , ? )";

        try {
            dbConnection = bddConnection.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertCliente);
            //preparedStatement = dbConnection.prepareStatement(updateTableSQL);

            preparedStatement.setFloat(1, getSaldo());
            preparedStatement.setInt(2, getIdCliente());

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
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return resp;
    }

    public void getCuenta(int cta) {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectLogin = "select * from cuenta where IDCUENTA= ?";

        try {
            dbConnection = bddConnection.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectLogin);
            //preparedStatement = dbConnection.prepareStatement(updateTableSQL);

            preparedStatement.setInt(1, cta);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                this.setIdCuenta(rs.getInt(1));
                this.setSaldo(rs.getFloat(2));
                this.setIdCliente(rs.getInt(3));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public boolean AgregarMonto(int idCuenta, float cargo) {
        this.getCuenta(idCuenta);
        boolean resp = false;
        if (cargo > 0) {
            Connection dbConnection = null;
            PreparedStatement preparedStatement = null;

            String updateMonto = "UPDATE CUENTA SET SALDO = SALDO+? WHERE IDCUENTA= ?";

            try {
                dbConnection = bddConnection.getDBConnection();
                preparedStatement = dbConnection.prepareStatement(updateMonto);
                //preparedStatement = dbConnection.prepareStatement(updateTableSQL);

                preparedStatement.setFloat(1, cargo);
                preparedStatement.setInt(2, this.getIdCuenta());

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
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (dbConnection != null) {
                    try {
                        dbConnection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return resp;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the saldo
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the idCuenta
     */
    public int getIdCuenta() {
        return idCuenta;
    }

    /**
     * @param idCuenta the idCuenta to set
     */
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

}
