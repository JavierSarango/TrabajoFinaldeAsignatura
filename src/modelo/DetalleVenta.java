/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Gigabyte
 */
public class DetalleVenta {
    private Integer idDetelleVenta;
    private Integer id_Venta;
    private Integer id_Producto;
    private Integer cantidad;
    private Double precioVenta;

    public DetalleVenta() {
    }

    public DetalleVenta(Integer idDetelleVenta, Integer id_Venta, Integer id_Producto, Integer cantidad, Double precioVenta) {
        this.idDetelleVenta = idDetelleVenta;
        this.id_Venta = id_Venta;
        this.id_Producto = id_Producto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

  

    
    public Integer getIdDetelleVenta() {
        return idDetelleVenta;
    }

    public void setIdDetelleVenta(Integer idDetelleVenta) {
        this.idDetelleVenta = idDetelleVenta;
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
