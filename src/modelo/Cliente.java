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
 * @author Pc
 */
public class Cliente extends Persona implements Serializable{

    private Integer id_cliente;
    private String tipoCliente;
    private Date fechaNacimiento;

    public Cliente() {
    }

    public Cliente(Integer id_cliente, String tipoCliente, Date fechaNacimiento) {
        super();
        this.id_cliente = id_cliente;
        this.tipoCliente = tipoCliente;
        this.fechaNacimiento = fechaNacimiento;
    }

    

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }


    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "";
    }
    
    
     

}
