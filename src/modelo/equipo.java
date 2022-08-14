/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.utiles.enums.TipoEquipo;

/**
 *
 * @author jona
 */
public class equipo {
    
     private Integer id_equipo;
     private String razon_social;
     private TipoEquipo tipo_equipo;
//     private String tipo_equipo;
     private String marca;
     private String modelo;
     private String cargador;
     private String estado_ingreso;
     private String descripcion_problema;
     private Double precio_servicio;

    public Integer getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(Integer id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public TipoEquipo getTipo_equipo() {
        return tipo_equipo;
    }

    public void setTipo_equipo(TipoEquipo tipo_equipo) {
        this.tipo_equipo = tipo_equipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    

    public String getEstado_ingreso() {
        return estado_ingreso;
    }

    public void setEstado_ingreso(String estado_ingreso) {
        this.estado_ingreso = estado_ingreso;
    }

    public String getDescripcion_problema() {
        return descripcion_problema;
    }

    public void setDescripcion_problema(String descripcion_problema) {
        this.descripcion_problema = descripcion_problema;
    }

    public Double getPrecio_servicio() {
        return precio_servicio;
    }

    public void setPrecio_servicio(Double precio_servicio) {
        this.precio_servicio = precio_servicio;
    }

    public String getCargador() {
        return cargador;
    }

    public void setCargador(String cargador) {
        this.cargador = cargador;
    }

  
      
}
