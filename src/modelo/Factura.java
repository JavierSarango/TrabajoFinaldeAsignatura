/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author John
 */
public class Factura implements Serializable {

    /**
     * variable identificador de la factura
     */
    private int Id;
    /**
     * variable que almacena el nombre de la empresa
     */
    private static String NombreEmpresa = "OMICRON TECNOLOGIA";
    /**
     * variable que almacena el RUC de la empresa
     */
    private static String RUC = "1105993198001";
    /**
     * variable que almacena el codigo de la factura
     */
    private String codigoFactura;
    /**
     * variable que almacena el codigo de autorizacion de las facturas
     */
    private static String codigoAutorizacion = "001";
    /**
     * variable que almacena la direccion de la empresa
     */
    private static String direccionEmpresa = "La Pradera, calle Alamos 235-16 y Catamayo";
    /**
     * variable que almacena el telefono de la empresa
     */
    private static String telefonoE = "072102085";
    /**
     * varible que almacena el email de la empresa
     */
    private static String emailE = "omicrontec1@gmail.com";

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the NombreEmpresa
     */
    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    /**
     * @return the RUC
     */
    public String getRUC() {
        return RUC;
    }

    /**
     * @return the codigoFactura
     */
    public String getCodigoFactura() {
        return codigoFactura;
    }

    /**
     * @param codigoFactura the codigoFactura to set
     */
    public void setCodigoFactura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    /**
     * @return the codigoAutorizacion
     */
    public String getCodigoAutorizacion() {
        return codigoAutorizacion;
    }

    /**
     * @return the direccionEmpresa
     */
    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    /**
     * @return the telefonoE
     */
    public String getTelefonoE() {
        return telefonoE;
    }

    /**
     * @return the email
     */
    public String getEmailE() {
        return emailE;
    }
}
