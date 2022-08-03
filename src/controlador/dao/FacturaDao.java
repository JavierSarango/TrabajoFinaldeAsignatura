/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.tda.lista.ListaEnlazada;
import controlador.dao.AdaptadorDao;
import modelo.Factura;

/**
 *
 * @author John
 */
public class FacturaDao extends AdaptadorDao<Factura> {

    private Factura factura;
    private ListaEnlazada<Factura> listaFactura;

    public FacturaDao() {
        super(Factura.class);
        listado();
    }

    public Factura getFactura() {
        if (this.factura == null) {
            this.factura = new Factura();
        }
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public ListaEnlazada<Factura> getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(ListaEnlazada<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    public Boolean guardar() {
        try {
            getFactura().setId(listaFactura.getSize() + 1);
            guardar(getFactura());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar" + e);
        }
        return false;
    }

    public Boolean modificar(Integer pos) {
        try {
            modificaree(getFactura());
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar" + e);
        }
        return false;
    }

    public ListaEnlazada<Factura> listado() {
        setListaFactura(listar());
        return listaFactura;
    }

}
