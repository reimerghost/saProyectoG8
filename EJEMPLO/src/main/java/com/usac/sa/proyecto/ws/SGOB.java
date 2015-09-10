/**
 * @autor reimer
 */
package com.usac.sa.proyecto.ws;

import com.usac.sa.proyecto.Cliente;
import com.usac.sa.proyecto.Cuenta;
import com.usac.sa.proyecto.test.testTest;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class SGOB {

    //Servicios Relacionados con el Cliente//
    /**
     * Web service operation
     *
     * @param user Nombre de Usuario del Banco.
     * @param pass Contraseña de usuario
     * @return retorna valor booleando que permite loguear o no.
     */
    @WebMethod(operationName = "iniciarSesion")
    public boolean IniciarSesion(@WebParam(name = "usuario") String user, @WebParam(name = "password") String pass) {
        Cliente c = new Cliente(user, pass);
        return c.Login();
    }

    @WebMethod(operationName = "mostrarDatosCliente")
    public Cliente mostrarDatosCliente(@WebParam(name = "usuario") String user, @WebParam(name = "password") String pass) {
        Cliente c = new Cliente();
        c.buscarCliente(user, pass);
        return c;
    }
    
    @WebMethod(operationName = "existeCliente")
    public boolean existeCliente(@WebParam(name = "usuario") String user) {
        Cliente c = new Cliente();
        return c.buscarClienteAdmin(user);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearCliente")
    public boolean CrearCliente(@WebParam(name = "nombre") String name, @WebParam(name = "apellido") String lastname,
            @WebParam(name = "direccion") String dir, @WebParam(name = "telefono") String tel,
            @WebParam(name = "usuario") String user, @WebParam(name = "password") String pass) {
        Cliente c = new Cliente();
        return c.RegistrarCliente(name, lastname, dir, tel, user, pass);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "abrirCuenta")
    public boolean AbrirCuenta(@WebParam(name = "idCliente") int idCliente) {
        Cuenta c = new Cuenta();
        return c.nuevaCuenta(idCliente, 0);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AbrirCuentaMonto")
    public boolean AbrirCuentaMonto(@WebParam(name = "idCliente") int idCliente, @WebParam(name = "monto") float monto) {
        Cuenta c = new Cuenta();
        return c.nuevaCuenta(idCliente, monto);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarSaldo")
    public boolean AgregarSaldo(@WebParam(name = "idCuenta") int idCuenta, @WebParam(name = "monto") float monto) {
        Cuenta c = new Cuenta();
        boolean r = c.AgregarMonto(idCuenta, monto);
        return r;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "mostrarSaldo")
    public float MostrarSaldo(@WebParam(name = "idCuenta") int idCuenta) {
        Cuenta c = new Cuenta();
        c.getCuenta(idCuenta);

        return c.getSaldo();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "realizarTransferencia")
    public String realizarTransferencia(@WebParam(name = "idCuentaO") int idCuentaO, @WebParam(name = "idCuentaD") int idCuentaD,
            @WebParam(name = "monto") float monto) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultarHistorial")
    public String consultarHistorial() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitarPrestamo")
    public String solicitarPrestamo() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "autorizarPrestamo")
    public String autorizarPrestamo() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "rechazarPrestamo")
    public String rechazarPrestamo() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "verEstadoPrestamo")
    public String verEstadoPrestamo() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "verCuotasPagadas")
    public String verCuotasPagadas() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "verTotalCuotasPagadas")
    public String verTotalCuotasPagadas() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "verCuotasTotales")
    public String verCuotasTotales() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "verSaldoRestante")
    public testTest verSaldoRestante() {
        //TODO write your implementation code here:
        testTest tt = new testTest();

        return tt;
    }

    //TESTING ZONE
    @WebMethod(operationName = "sayHello")
    public String sayHello(@WebParam(name = "guestname") String guestname) {

        if (guestname == null) {
            return "Hello";
        }
        return "Hello " + guestname;

    }
}
