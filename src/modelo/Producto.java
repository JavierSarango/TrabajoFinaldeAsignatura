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
    private Long id;
    private String nombre;
    private String descripcion; 
    private Double precioIngresado;
    private Double preciosiniva;
    private Double precioconiva;
    private Boolean incluyeIva;
    private Boolean productolibredeImpuestos;
    private int unidades;
    private Boolean visible;
    
    
    /**
     *Genera losdistintos geters y seters de la información
     */
    public void setIncluyeIva(Boolean incluyeIva) {
        
        this.incluyeIva = incluyeIva;
    }

    public Boolean getVisible() {
        if(visible==null){
            return true;
        }
        
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
 


    public Boolean getIncluyeIva() {
        return incluyeIva;
    }
    
    

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Double getPrecioIngresado() {
        return precioIngresado;
    }

    public void setPrecioIngresado(Double precioIngresado) {
        this.precioIngresado = precioIngresado;
    }
    
   
    
       public Double getPrecioconiva() {
        return precioconiva;
    }

    public void setPrecioconiva(Double precioconiva, Double iva) {
       
            if (getIncluyeIva() == true || getProductolibredeImpuestos() == true) {
                this.precioconiva = precioconiva;
               
            } else {
                this.precioconiva=precioconiva+(precioconiva/100)*iva;
                
            }
        
    }

    public void setPreciosiniva(Double preciosiniva) {
        this.preciosiniva = preciosiniva;
    }

    public void setPrecioconiva(Double precioconiva) {
        this.precioconiva = precioconiva;
    }

    public Boolean getProductolibredeImpuestos() {
        return productolibredeImpuestos;
    }

    public void setProductolibredeImpuestos(Boolean productolibredeImpuestos) {
        this.productolibredeImpuestos = productolibredeImpuestos;
    }
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPreciosiniva() {
        return preciosiniva;
    }
    
     
    public void setPreciosiniva(Double preciosiniva, Double iva) {
        if (getIncluyeIva() == true || getProductolibredeImpuestos() == true) {
                
               this.preciosiniva=preciosiniva-(preciosiniva/100)*iva;
        } else {
               this.preciosiniva = preciosiniva; 
                
        }
        
    }
    public Producto() {
    }

    public Producto(String nombre, String descripcion, Double precioIngresado, Boolean incluyeIva, Boolean productolibredeImpuestos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioIngresado = precioIngresado;
        this.incluyeIva = incluyeIva;
        this.productolibredeImpuestos = productolibredeImpuestos;
    }
    
    
    
    public Producto(Long id, String nombre, String descripcion, Double preciosiniva, Double precioconiva, Double iva, Boolean productolibredeImpuestos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.preciosiniva = preciosiniva;
        this.precioconiva = precioconiva;
   
        this.productolibredeImpuestos = productolibredeImpuestos;
    }

    

    @Override
    public String toString() {
        return  " "+ nombre + " ";
    }
    
    
}