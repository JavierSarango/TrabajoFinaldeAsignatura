/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.dao.AdaptadorDao;
import controlador.tda.lista.ListaEnlazada;
import modelo.Venta;

/**
 *
 * @author Gigabyte
 */
public class VentaController extends AdaptadorDao<Venta> {
    private Venta venta;
    private ListaEnlazada<Venta> listaVentas;

    public VentaController() {
        super(Venta.class);
    }

    public Venta getVenta() {
        if (venta == null) {
            venta = new Venta();
        }
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public ListaEnlazada<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ListaEnlazada<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    @Override
    public void guardar(Venta dato) throws Exception {
        super.guardar(dato); 
    }

    @Override
    public void modificaree(Venta dato) throws Exception {
        super.modificaree(dato); 
    }

    @Override
    public void eliminar(Venta dato) {
        super.eliminar(dato); 
    }
    
    
    
    
    
    
}
