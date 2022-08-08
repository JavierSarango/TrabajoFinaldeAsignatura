/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.dao.AdaptadorDao;
import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.exception.PosicionException;
import modelo.Factura;

/**
 *
 * @author John
 */
public class FacturaDao<T> extends AdaptadorDao<Factura> {

    /**
     * variable tipo factura para almacenamiento de la informacion de la factura
     * obtenida de la base de datos
     */
    private Factura factura;

    /**
     * Una lista de facturas
     */
    private ListaEnlazada<Factura> facturas = new ListaEnlazada();

    /**
     * constructor de la clase FacturaDao
     *
     * @param clazz
     */
    public FacturaDao(Class clazz) {
        super(clazz);
    }

    /**
     * metodo para obtener la factura almacenada en la variables factura
     *
     * @return factura
     */
    public Factura getFactura() {
        if (this.factura == null) {
            this.factura = new Factura();
        }
        return factura;
    }

    /**
     * metodo para setear datos en la variable factura
     *
     * @param factura
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    /**
     * Permite obtener la lista tipo factura
     *
     * @return lista factura
     */
    public ListaEnlazada<Factura> getFacturas() {
        return facturas;
    }

    /**
     * Permite ingresar los datos de la lista de facturas
     *
     * @param facturas
     */
    public void setFacturas(ListaEnlazada<Factura> facturas) {
        this.facturas = facturas;
    }

    /**
     * Metodo para guardar en base de datos un objetos Factura
     *
     * @param dato
     * @throws Exception
     */
    @Override
    public void guardar(Factura dato) throws Exception {
        super.guardar(dato);
    }

    /**
     * Metodo para modificar en base de datos un objetos Factura
     *
     * @param dato
     * @throws Exception
     */
    @Override
    public void modificaree(Factura dato) throws Exception {
        super.modificaree(dato);
    }

    /**
     * Metodo para eliminar en base de datos un objetos Factura
     *
     * @param dato
     */
    @Override
    public void eliminar(Factura dato) {
        super.eliminar(dato);
    }

}
