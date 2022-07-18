/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Nathaly
 */
public class Ventas {

    private Integer id;
    private Integer numeroVentas;
    private Date fechaVenta;
    private Double valor;
    private Boolean estado;
    private Object producto; 

    public Ventas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroVentas() {
        return numeroVentas;
    }

    public void setNumeroVentas(Integer numeroVentas) {
        this.numeroVentas = numeroVentas;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Object getProducto() {
        return producto;
    }

    public void setProducto(Object producto) {
        this.producto = producto;
    }

    public Ventas(Integer id, Integer numeroVentas, Date fechaVenta, Double valor, Boolean estado, Object producto) {
        this.id = id;
        this.numeroVentas = numeroVentas;
        this.fechaVenta = fechaVenta;
        this.valor = valor;
        this.estado = estado;
        this.producto = producto;
    }
    
    
    @Override
    public String toString() {
        return  id + "id" + numeroVentas + "numeroVen" + fechaVenta + "fecha" + valor + "valor" + estado + "estado" + producto + "producto";//To change body of generated methods, choose Tools | Templates.
    }

}
