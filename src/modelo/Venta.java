/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Gigabyte
 */
public class Venta {
    private Integer id_Venta;
    private Integer id_Producto;
    private Integer id_Cliente;    
    private Integer cantidad;
    private Double precioUnitario;
    private Double subTotal;
    private Double iva;
    private Double totalPagar;
    private Double descuento;

    public Venta() {
        this.id_Venta = 0;
        this.id_Producto = 0;
        this.id_Cliente = 0;
        this.cantidad = 0;
        this.precioUnitario = 0.00;
        this.subTotal = 0.00;
        this.iva = 0.00;
        this.totalPagar = 0.00;
        this.descuento = 0.00;
    }

    public Venta(Integer id_Venta, Integer id_Producto, Integer id_Cliente, Integer cantidad, Double precioUnitario, Double subTotal, Double iva, Double totalPagar, Double descuento) {
        this.id_Venta = id_Venta;
        this.id_Producto = id_Producto;
        this.id_Cliente = id_Cliente;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
        this.iva = iva;
        this.totalPagar = totalPagar;
        this.descuento = descuento;
    }

    

    

    public Integer getIdVenta() {
        return id_Venta;
    }

    public void setIdVenta(Integer idVenta) {
        this.id_Venta = idVenta;
    }

    public Integer getIdProducto() {
        return id_Producto;
    }

    public void setIdProducto(Integer idProducto) {
        this.id_Producto = idProducto;
    }


    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return id_Venta + " "+ id_Producto+" " + id_Cliente +" " +cantidad+" " +precioUnitario+" " +subTotal+" " +iva+" " +totalPagar+" " +descuento;
    }
    
    
}
