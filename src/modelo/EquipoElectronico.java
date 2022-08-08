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
public class EquipoElectronico {
    
     private Integer id_Equipo;
     private String razonSocial;
     private String marca;
     private String modelo;
     private Boolean cargador;
     private String estado_Ingreso;
     private String descripcion_Problema;
     private TipoEquipo tipo_Equipo;
     private Double precio_servicio;

    public Integer getId_Rquipo() {
        return id_Equipo;
    }

    public void setId_Rquipo(Integer id_Rquipo) {
        this.id_Equipo = id_Rquipo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
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

    public Boolean getCargador() {
        return cargador;
    }

    public void setCargador(Boolean cargador) {
        this.cargador = cargador;
    }

    public String getEstado_Ingreso() {
        return estado_Ingreso;
    }

    public void setEstado_Ingreso(String estado_Ingreso) {
        this.estado_Ingreso = estado_Ingreso;
    }

    public String getDescripcion_Problema() {
        return descripcion_Problema;
    }

    public void setDescripcion_Problema(String descripcion_Problema) {
        this.descripcion_Problema = descripcion_Problema;
    }


    public TipoEquipo getTipo_Equipo() {
        return tipo_Equipo;
    }

    public void setTipo_Equipo(TipoEquipo tipo_Equipo) {
        this.tipo_Equipo = tipo_Equipo;
    }

    public Double getPrecio_servicio() {
        return precio_servicio;
    }

    public void setPrecio_servicio(Double precio_servicio) {
        this.precio_servicio = precio_servicio;
    }
     
     
}
