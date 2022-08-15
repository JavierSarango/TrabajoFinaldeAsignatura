/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import modelo.Proveedor;

/**
 *
 * @author diego
 */
public class Producto implements Serializable{
    private Integer idProducto;
    private Integer codigo;
    private String nombre; ;
    private String descripcion; 
    private Double precioCompra;
    private Double precioVenta;
    private Integer unidades; 
    private String Proveedor;
    
    

//    public Boolean getEstado() {
//        return estado;
//    }
//
//    public void setEstado(Boolean estado) {
//        this.estado = estado;
//    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }
    
    

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

     

  
    public Producto(Integer idProducto, Integer codigo, String nombre, String descripcion, Double precioCompra, Double precioVenta, String proveedor) {
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.Proveedor = proveedor; 
    }
    
    public Producto(){
        
    }

    @Override
    public String toString() {
        return  " "+ nombre + " ";
    }
    
    
}