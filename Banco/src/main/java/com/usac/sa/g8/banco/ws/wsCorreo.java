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
@WebService(serviceName = "wsCorreo")
public class wsCorreo {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "correoPrestamo")
    public String enviarCorreoPrestamo(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "correoCuenta")
    public String enviarCorreoCuenta(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}
