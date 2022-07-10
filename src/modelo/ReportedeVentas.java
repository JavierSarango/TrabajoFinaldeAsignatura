/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author javisarango
 */
public class ReportedeVentas {
    private Integer id;
    private Object ventas;
    private PeriodoReporte tipoReporte;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getVentas() {
        return ventas;
    }

    public void setVentas(Object ventas) {
        this.ventas = ventas;
    }

    public PeriodoReporte getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(PeriodoReporte tipoReporte) {
        this.tipoReporte = tipoReporte;
    }
    
    
}
