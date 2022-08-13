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
public class Factura implements Serializable{

    /**
     * variable identificador de la factura
     */
    private int Id;
    /**
     * variable que almacena el nombre de la empresa
     */
    private String NombreEmpresa;
    /**
     * variable que almacena el RUC de la empresa
     */
    private String RUC;
    /**
     * variable que almacena el codigo de la factura
     */
    private String codigoFactura;
    /**
     * variable que almacena el codigo de autorizacion de las facturas
     */
    private String codigoAutorizacion;
    /**
     * variable que almacena la direccion de la empresa
     */
    private String direccionEmpresa;
    /**
     * variable que almacena el telefono de la empresa
     */
    private String telefonoE;
    /**
     * varible que almacena el email de la empresa
     */
    private String emailE;

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
     * @param NombreEmpresa the NombreEmpresa to set
     */
    public void setNombreEmpresa(String NombreEmpresa) {
        this.NombreEmpresa = NombreEmpresa;
    }

    /**
     * @return the RUC
     */
    public String getRUC() {
        return RUC;
    }

    /**
     * @param RUC the RUC to set
     */
    public void setRUC(String RUC) {
        this.RUC = RUC;
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
     * @param codigoAutorizacion the codigoAutorizacion to set
     */
    public void setCodigoAutorizacion(String codigoAutorizacion) {
        this.codigoAutorizacion = codigoAutorizacion;
    }

    /**
     * @return the direccionEmpresa
     */
    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    /**
     * @param direccionEmpresa the direccionEmpresa to set
     */
    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    /**
     * @return the telefonoE
     */
    public String getTelefonoE() {
        return telefonoE;
    }

    /**
     * @param telefonoE the telefonoE to set
     */
    public void setTelefonoE(String telefonoE) {
        this.telefonoE = telefonoE;
    }

    /**
     * @return the email
     */
    public String getEmailE() {
        return emailE;
    }

    /**
     * @param email the email to set
     */
    public void setEmailE(String email) {
        this.emailE = email;
    }
}
