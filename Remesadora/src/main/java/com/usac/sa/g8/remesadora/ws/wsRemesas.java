/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.sa.g8.remesadora.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceRef;
import remesadorag8.RemesadoraG8;

/**
 *
 * @author reimer
 */
@WebService(serviceName = "wsRemesas")
public class wsRemesas {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_9763/services/remesadorag8.wsdl")
    private RemesadoraG8 service;

    @WebMethod(operationName = "cambiarEstado")
    public String cambiarEstado(@WebParam(name = "no_remesa") int no_remesa,
                                @WebParam(name = "monto") int monto) {
        
        try { // Call Web Service Operation
            remesadorag8.RemesadoraG8PortType port = service.getSOAP11Endpoint();
            // TODO initialize WS operation arguments here
            java.lang.Integer idRemesa = no_remesa;
            // TODO process result here
            java.util.List<remesadorag8.Remesa> result = port.selectWithKeyRemesaOperation(idRemesa);
            if(result.isEmpty()){
               System.out.println("REMESA NO ENCONTRADA."); 
            }else{
                remesadorag8.Remesa Remesa = result.get(0);
                port.updateRemesaOperation(Remesa.getNombreEmisor(), 
                                           Remesa.getNombreReceptor(), 
                                           Remesa.getFechaAgregado(), 
                                           new java.util.Date().toGMTString(), 
                                           Remesa.getTipoRemesa(), 
                                           Remesa.getIdCuenta().intValue(), 
                                           Remesa.getIdPrestamo().intValue(), 
                                           Remesa.getBancoDestino(), 
                                           "COBRADA", 
                                           Remesa.getMontoDolares().doubleValue(), 
                                           Remesa.getMontoQuetzales().doubleValue(), 
                                           Remesa.getComision().doubleValue(), 
                                           Remesa.getIdRemesadora(), 
                                           Remesa.getIdRemesa().intValue());
                //System.out.println("Result = "+ Remesa.getBancoDestino());            
            }
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

        return "TRUE";        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "enviarRemesaEfectivo")
    public String enviarRemesaEfectivo(@WebParam(name = "emisor") String emisor, 
                                       @WebParam(name = "receptor") String receptor, 
                                       @WebParam(name = "montoEnDolares") double montoEnDolares, 
                                       @WebParam(name = "bancoDestino") String banco_Destino) {
        //TODO write your implementation code here:
        
        try { // Call Web Service Operation
            remesadorag8.RemesadoraG8PortType port = service.getSOAP11Endpoint();
            // TODO initialize WS operation arguments here
            java.lang.String nombreEmisor = emisor;
            java.lang.String nombreReceptor = receptor;
            java.util.Date fechaRegistroRemesa = new java.util.Date();
            java.lang.String fechaAgregado = fechaRegistroRemesa.toGMTString();
            java.lang.String fechaPago = null;
            java.lang.String tipoRemesa = "Efectivo";
            java.lang.Integer idCuenta = null;
            java.lang.Integer idPrestamo = null;
            java.lang.String bancoDestino = banco_Destino;
            java.lang.String estado = "SinCobrar";
            java.lang.Double montoDolares = montoEnDolares;
            java.lang.Double montoQuetzales = montoEnDolares*7.78;
            java.lang.Double comision = montoDolares*0.01;
            java.lang.String Remesadora = "8";
            port.insertRemesaOperation(nombreEmisor, nombreReceptor, fechaAgregado, fechaPago, tipoRemesa, idCuenta, idPrestamo, bancoDestino, estado, montoDolares, montoQuetzales, comision, Remesadora);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            return "FALSE";
        }

        return "TRUE";

    }
}
