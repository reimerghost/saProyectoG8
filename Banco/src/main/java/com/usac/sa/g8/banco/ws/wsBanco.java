/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.sa.g8.banco.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author reimer
 */
@WebService(serviceName = "wsBanco")
public class wsBanco {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "recibirRemesaPrestamo")
    public String recibirRemesaPrestamo(
            @WebParam(name = "no_remesa") int no_remesa,
            @WebParam(name = "no_remesadora") int no_remesadora,
            @WebParam(name = "no_prestamo") int no_prestamo,
            @WebParam(name = "nombre_envia") String nombre_envia,
            @WebParam(name = "nombre_recibe") String nombre_recibe,
            @WebParam(name = "montoDolar") float montoDolar) {
        return "Hello " + "" + " !";
    }

    @WebMethod(operationName = "recibirRemesaCuenta")
    public String recibirRemesaCuenta(
            @WebParam(name = "no_remesa") int no_remesa,
            @WebParam(name = "no_remesadora") int no_remesadora,
            @WebParam(name = "no_cuenta") int no_cuenta,
            @WebParam(name = "nombre_envia") String nombre_envia,
            @WebParam(name = "nombre_recibe") String nombre_recibe,
            @WebParam(name = "montoDolar") float montoDolar) {
        return "Hello " + "" + " !";
    }

    @WebMethod(operationName = "recibirRemesaEfectivo")
    public String recibirRemesaEfectivo(
            @WebParam(name = "no_remesa") int no_remesa,
            @WebParam(name = "no_remesadora") int no_remesadora,
            @WebParam(name = "nombre_envia") String nombre_envia,
            @WebParam(name = "nombre_recibe") String nombre_recibe,
            @WebParam(name = "montoDolar") float montoDolar) {
        return "Hello " + "" + " !";
    }

    @WebMethod(operationName = "cambiarEstado")
    public String cambiarEstado(
            @WebParam(name = "no_cuenta") int no_cuenta) {
        return "Hello " + "" + " !";
    }

    @WebMethod(operationName = "enviarEmail")
    public String enviarEmail(
            @WebParam(name = "no_cuenta") int no_cuenta,
            @WebParam(name = "monto") float monto) {
        return "Hello " + "" + " !";
    }

}
