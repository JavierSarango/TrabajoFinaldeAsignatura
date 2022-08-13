/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Gigabyte
 */
public class DetalleVenta implements Serializable{
    private Integer idDetalleVenta;
    private Integer id_Venta;
    private Integer id_Producto;
    private Integer cantidad;
    private Double precioVenta;

    public DetalleVenta() {
    }

    public DetalleVenta(Integer idDetelleVenta, Integer id_Venta, Integer id_Producto, Integer cantidad, Double precioVenta) {
        this.idDetalleVenta = idDetelleVenta;
        this.id_Venta = id_Venta;
        this.id_Producto = id_Producto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

  

    
    public Integer getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Integer getId_Venta() {
        return id_Venta;
    }

    public void setId_Venta(Integer id_Venta) {
        this.id_Venta = id_Venta;
    }

    public Integer getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(Integer id_Producto) {
        this.id_Producto = id_Producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    
}
