/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jona
 */
public class EquipoElectronico {
    
     private Integer id;
     private String marca;
     private String modelo;
     private Boolean cargador;
     private String observaciones;
     private String tipoProblema;
    

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
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

     public String getObservaciones() {
          return observaciones;
     }

     public void setObservaciones(String observaciones) {
          this.observaciones = observaciones;
     }

     public String getTipoProblema() {
          return tipoProblema;
     }

     public void setTipoProblema(String tipoProblema) {
          this.tipoProblema = tipoProblema;
     }

    
     
     
}
