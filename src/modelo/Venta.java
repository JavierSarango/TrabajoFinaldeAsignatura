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
public class Venta implements Serializable{
    private Integer id_Venta;
    private Integer id_Cliente;   
    private String nroVentas;
    private String fechaVenta;     
    private Double monto;


    public Venta() {
     
        this.id_Venta = 0;
        this.nroVentas = "";
        this.id_Cliente = 0;
        this.monto = 0.00;
      
    }

    public Venta(Integer id_Venta, String nroVentas, String fechaVenta, Integer id_Cliente, Double monto) {
        this.id_Venta = id_Venta;
        this.nroVentas = nroVentas;
        this.fechaVenta = fechaVenta;
        this.id_Cliente = id_Cliente;
        this.monto = monto;
    }


    

    public Integer getId_Venta() {
        return id_Venta;
    }

    public void setId_Venta(Integer id_Venta) {
        this.id_Venta = id_Venta;
    }

    public String getNroVentas() {
        return nroVentas;
    }

    public void setNroVentas(String nroVentas) {
        this.nroVentas = nroVentas;
    }

    public Integer getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(Integer id_Cliente) {
        this.id_Cliente = id_Cliente;
    }


    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    
    @Override
    public String toString() {
        return id_Venta + " "+ nroVentas+" " + id_Cliente +" " +fechaVenta+ " "+ monto;
    }
    
    
}
