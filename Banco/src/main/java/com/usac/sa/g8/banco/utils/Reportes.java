/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.sa.g8.banco.utils;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import wsg8bancods.Abonos;
import wsg8bancods.DataServiceFault;
import wsg8bancods.Transaccion;
import wsg8bancods.Wsg8Banco;
import wsg8bancods.Wsg8BancoPortType;

/**
 *
 * @author usuario
 */
public class Reportes {
    
    public Reportes(){
        
    }
    
    public List<Transaccion> getEstadoDeCuenta(int idCuenta) {
        try {
            Wsg8Banco service = new Wsg8Banco();
            Wsg8BancoPortType port = service.getSOAP11Endpoint();

            return port.selectWithKeyTransaccionOperation(idCuenta);
        } catch (DataServiceFault ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Abonos> getReportePrestamo(int idPrestamo) {
        try {
            Wsg8Banco service = new Wsg8Banco();
            Wsg8BancoPortType port = service.getSOAP11Endpoint();            
            return port.selectWithKeyAbonosOperation(idPrestamo);
            
        } catch (DataServiceFault ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
