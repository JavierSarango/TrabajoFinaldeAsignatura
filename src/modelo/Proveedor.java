/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Nathaly
 */
public class Proveedor extends Persona {

    private Integer id_Proveedor;
    private String agenteResponsable;
    private String provincia;
    private String direccion;
    private Boolean credito;
    private String paginaweb;
    private String banco;
    private String tipocuenta;
    private String Nrocuenta;

    public Proveedor() {
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

    public String getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(String paginaweb) {
        this.paginaweb = paginaweb;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public String getNrocuenta() {
        return Nrocuenta;
    }

    public void setNrocuenta(String Nrocuenta) {
        this.Nrocuenta = Nrocuenta;
    }
    
    

    public Proveedor(Integer id_Proveedor, String agenteResponsable, String provincia, String direccion, Boolean credito, String paginaweb) {
        this.id_Proveedor = id_Proveedor;
        this.agenteResponsable = agenteResponsable;
        this.provincia = provincia;
        this.direccion = direccion;
        this.credito = credito;
        this.paginaweb = paginaweb;
    }

}
