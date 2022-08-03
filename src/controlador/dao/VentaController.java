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
         try {            
            getVenta().setIdVenta(listaVentas.getSize()+1);
            guardar(getVenta());
           
        } catch (Exception e) {
            System.out.println("Error en guardar autor"+e);
        }
       
    }

    @Override
    public void modificaree(Venta dato) throws Exception {
        super.modificaree(dato); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
    
    @Override
    public void eliminar(Venta dato) {
        super.eliminar(dato); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ListaEnlazada<Venta> listar() {
        return super.listar(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public Venta obtener(Integer id) throws Exception {
        return super.obtener(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
    
    
}
