/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

//import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nathaly
 */
//@XmlRootElement
public class Proveedores extends Persona {

    private Integer id_Proveedor;
    private String agenteResponsable;
    private String provincia;
    private String direccion;
    private Boolean credito;
    private String banco;
    private String cuentaBancaria;
    private String redsocial;
    private String tipoc;
    private String contacto;
    
    public Proveedores() {
    }

    public Integer getId_Proveedor() {
        return id_Proveedor;
    }

    public void setId_Proveedor(Integer id_Proveedor) {
        this.id_Proveedor = id_Proveedor;
    }

    public String getAgenteResponsable() {
        return agenteResponsable;
    }

    public void setAgenteResponsable(String agenteResponsable) {
        this.agenteResponsable = agenteResponsable;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getCredito() {
        return credito;
    }

    public void setCredito(Boolean credito) {
        this.credito = credito;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getRedsocial() {
        return redsocial;
    }

    public void setRedsocial(String redsocial) {
        this.redsocial = redsocial;
    }

    public String getTipoc() {
        return tipoc;
    }

    public void setTipoc(String tipoc) {
        this.tipoc = tipoc;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Proveedores(Integer id_Proveedor, String agenteResponsable, String provincia, String direccion, Boolean credito, String banco, String cuentaBancaria, String redsocial, String tipoc, String contacto) {
        this.id_Proveedor = id_Proveedor;
        this.agenteResponsable = agenteResponsable;
        this.provincia = provincia;
        this.direccion = direccion;
        this.credito = credito;
        this.banco = banco;
        this.cuentaBancaria = cuentaBancaria;
        this.redsocial = redsocial;
        this.tipoc = tipoc;
        this.contacto = contacto;
    }

   
    
}
