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
        
        try { // Call Web Service Operation
            org.wso2.ws.dataservice.Wsg8Banco service = new org.wso2.ws.dataservice.Wsg8Banco();
            org.wso2.ws.dataservice.Wsg8BancoPortType port = service.getSOAP11Endpoint();
            // TODO initialize WS operation arguments here
            java.lang.Integer idRemesa = no_remesa;
            java.lang.Integer idRemesadora = no_remesadora;
            java.util.Date ahora = new java.util.Date();
            java.lang.String fecha = ahora.toGMTString();
            java.lang.String nombreEmisor = nombre_envia;
            java.lang.String nombreReceptor = nombre_recibe;
            java.lang.Double montoQ = montoDolar*7.75d;
            java.lang.Double montoD = montoDolar*1.0d;
            java.lang.String estado = "";
            port.insertRemesasEfectivoOperation(idRemesa, idRemesadora, fecha, nombreEmisor, nombreReceptor, montoQ, montoD, estado);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            return "false";
        }

        return "true";
    }



}
