/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.sa.g8.remesadora.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author reimer
 */
@WebService(serviceName = "wsRemesas")
public class wsRemesas {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "enviarRemesaACuenta")
    public String enviarRemesaACuenta(@WebParam(name = "name") String txt) {
        return "Hello " + "" + " !";        
    }
    @WebMethod(operationName = "enviarRemesaAPrestamo")
    public String enviarRemesaAPrestamo(@WebParam(name = "name") String txt) {
        return "Hello " + "" + " !";        
    }
    @WebMethod(operationName = "enviarRemesaEfectivo")
    public String enviarRemesaEfectivo(@WebParam(name = "no_remesa") String no_remesa,@WebParam(name = "no_remesadora") String no_remesadora) {
        return "Hello " + "" + " !";        
    }
    @WebMethod(operationName = "cambiarEstado")
    public String cambiarEstado(@WebParam(name = "no_remesa") int no_remesa,@WebParam(name = "monto") int monto) {
        return "Hello " + "" + " !";        
    }
}
