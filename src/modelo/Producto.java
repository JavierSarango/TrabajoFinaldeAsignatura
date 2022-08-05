/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author diego
 */
public class Producto implements Serializable{
    private Long idProducto;
    private String nombre;
    private String descripcion; 
    private Double precioCompra;
    private Double precioVenta; 
    private int unidades;
    private Boolean visible;
    private Integer proveedor;

    public Integer getProveedor() {
        return proveedor;
    }

    public void setProveedor(Integer proveedor) {
        this.proveedor = proveedor;
    }
    
    
    
    public Long getIdProducto() {    
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Boolean getVisible() {
        return visible;
    }

    /**
     *Genera losdistintos geters y seters de nuestro modelo roducto
     */
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
 
    public Producto() {
    }

    public Producto(String nombre, String descripcion, Double precioCompra, Boolean incluyeIva, Double precioVenta) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra; 
        this.precioVenta = precioVenta;
    }
    
    
    
    public Producto(Long id, String nombre, String descripcion, Double preciosiniva, Double precioconiva, Double iva, Boolean productolibredeImpuestos) {
        this.idProducto = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioVenta = preciosiniva;
        this.precioCompra = precioCompra;
    
    }

    @Override
    public String toString() {
        return  " "+ nombre + " ";
    }
    
    
}