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
    private String agente_responsable;
    private String credito;
    private String pagina_web;
    private String telefono_opcional;
    private String banco;
    private String tipocuenta;
    private String nro_cuenta;

    public Proveedor() {
    }

    public Integer getId_Proveedor() {
        return id_Proveedor;
    }

    public void setId_Proveedor(Integer id_Proveedor) {
        this.id_Proveedor = id_Proveedor;
    }

    public String getAgente_responsable() {
        return agente_responsable;
    }

    public void setAgente_responsable(String agente_responsable) {
        this.agente_responsable = agente_responsable;
    }

    public String getCredito() {
        return credito;
    }

    public void setCredito(String credito) {
        this.credito = credito;
    }

    public String getPagina_web() {
        return pagina_web;
    }

    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
    }

    public String getTelefono_opcional() {
        return telefono_opcional;
    }

    public void setTelefono_opcional(String telefono_opcional) {
        this.telefono_opcional = telefono_opcional;
    }
    
    public String getBanco() {
        return banco;
    }

    public void setBanco(String Banco) {
        this.banco = Banco;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public String getNro_cuenta() {
        return nro_cuenta;
    }

    public void setNro_cuenta(String nro_cuenta) {
        this.nro_cuenta = nro_cuenta;
    }    

    public Proveedor(Integer id_Proveedor, String agente_responsable, String credito, String pagina_web, String telefono_opcional, String banco, String tipocuenta, String nro_cuenta) {
        this.id_Proveedor = id_Proveedor;
        this.agente_responsable = agente_responsable;
        this.credito = credito;
        this.pagina_web = pagina_web;
        this.telefono_opcional = telefono_opcional;
        this.banco = banco;
        this.tipocuenta = tipocuenta;
        this.nro_cuenta = nro_cuenta;
    }

    
}
