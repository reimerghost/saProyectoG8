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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Compaq
 */
public class Cliente {

    private int id;
    private String nombre, apellido, direccion, telefono, usuario, password;

    public Cliente(String u, String p) {
        usuario = u;
        password = p;
        this.buscarCliente(u, p);
    }

    public Cliente() {
    }

    public boolean RegistrarCliente(
            String n, String ap, String dir, String tel,
            String Us, String pass) {
        setNombre(n);
        setApellido(ap);
        setDireccion(dir);
        setTelefono(tel);
        setUsuario(Us);
        setPassword(pass);
        boolean resp = false;
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertCliente = "insert into cliente(NOMBRE,APELLIDO,DIRECCION,TELEFONO,USUARIO,PASSWORD,FECHA_CREADO)"
                + "values( ? , ? , ? , ? , ? , ? , ? )";

        try {
            dbConnection = bddConnection.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertCliente);
            //preparedStatement = dbConnection.prepareStatement(updateTableSQL);

            preparedStatement.setString(1, getNombre());
            preparedStatement.setString(2, getApellido());
            preparedStatement.setString(3, getDireccion());
            preparedStatement.setString(4, getTelefono());
            preparedStatement.setString(5, getUsuario());
            preparedStatement.setString(6, getPassword());
            preparedStatement.setTimestamp(7, bddConnection.getCurrentTimeStamp());

            preparedStatement.executeUpdate();
            //id = this.getID(usuario,password);
            System.out.println("Cliente Insertado!");
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

    public boolean Login() {
        this.buscarCliente(getUsuario(), getPassword());
        return (getId() > 0);
    }

    public final void buscarCliente(String u, String p) {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectLogin = "select * from cliente where usuario= ? and password= ?";

        try {
            dbConnection = bddConnection.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectLogin);
            //preparedStatement = dbConnection.prepareStatement(updateTableSQL);

            preparedStatement.setString(1, u);
            preparedStatement.setString(2, p);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                setId(rs.getInt(1));
                setNombre(rs.getString(2));
                setApellido(rs.getString(3));
                setDireccion(rs.getString(4));
                setTelefono(rs.getString(5));
                setUsuario(rs.getString(6));
                setPassword(rs.getString(7));
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

    public final boolean buscarClienteAdmin(String u) {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        boolean r = false;

        String selectLogin = "select * from cliente where usuario= ?";

        try {
            dbConnection = bddConnection.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectLogin);
            //preparedStatement = dbConnection.prepareStatement(updateTableSQL);

            preparedStatement.setString(1, u);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                r = true;
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
        return r;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
