/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.sun.jndi.toolkit.dir.SearchFilter;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author John
 */
public class DetalleFactura implements Serializable{

    /**
     * variable identificador
     */
    private int Id;
    /**
     * variable identificador de factura
     */
    private Integer id_factura;
    /**
     * variable para obtener cliente
     */
    private Integer id_cliente;
    /**
     * variable tipo Date con la fecha de Emision
     */
    private Date fechaEmision;
    /**
     * variable con los datos de la ventas
     */
    private Integer id_ventas;

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the fechaEmision
     */
    public Date getFechaEmision() {
        return fechaEmision;
    }

    /**
     * @param fechaEmision the fechaEmision to set
     */
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * @return the id_cliente
     */
    public Integer getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the id_ventas
     */
    public Integer getId_ventas() {
        return id_ventas;
    }

    /**
     * @param id_ventas the id_ventas to set
     */
    public void setId_ventas(Integer id_ventas) {
        this.id_ventas = id_ventas;
    }

    /**
     * @return the id_factura
     */
    public Integer getId_factura() {
        return id_factura;
    }

    /**
     * @param id_factura the id_factura to set
     */
    public void setId_factura(Integer id_factura) {
        this.id_factura = id_factura;
    }

}
