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
public class Proveedores extends Persona{

    private Integer id_Proveedor;
    private String agenteResponsable;
    private String provincia;
    private String producto;
    private Boolean credito;
    private String banco;
    private String cuentaBancaria;
    

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

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
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

    public Proveedores(Integer id_Proveedor, String agenteResponsable, String provincia, Boolean credito, String banco, String cuentaBancaria) {
        this.id_Proveedor = id_Proveedor;
        this.agenteResponsable = agenteResponsable;
        this.provincia = provincia;
        this.credito = credito;
        this.banco = banco;
        this.cuentaBancaria = cuentaBancaria;
    }

    @Override
    public String toString() {
        return id_Proveedor + "id" + agenteResponsable + "agente rwaponsable" + provincia + "provincia " + credito + "credito" + banco + "banco" + cuentaBancaria + "cuentaBancaria";//To change body of generated methods, choose Tools | Templates.
    }


}
