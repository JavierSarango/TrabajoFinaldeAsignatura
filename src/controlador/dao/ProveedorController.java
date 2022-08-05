/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.dao.AdaptadorDao;
import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.ListaEnlazadaServices;
import modelo.Proveedores;

/**
 *
 * @author Nathaly
 */
public class ProveedorController extends AdaptadorDao<Proveedores>{
 
    private Proveedores proveedores;
    private ListaEnlazada<Proveedores> listaProveedor;

    public  ProveedorController() {
        super(Proveedores.class);
        listado();
    }

    public Proveedores getProveedores() {
        if (this.proveedores == null) {
            this.proveedores = new Proveedores();
        }
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public ListaEnlazada<Proveedores> getListaProveedor() {
        return listaProveedor;
    }

    public void setListaProveedor(ListaEnlazada<Proveedores> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }

  public Boolean guardar(){
        try {
            if (getProveedores().getId_Proveedor()!= null) {
                guardar(this.getProveedores());
            }else{
                guardar(this.getProveedores());
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar");
            return false;
        }    
    }

   public Boolean modificar(){
        try {
            if (getProveedores().getId_Proveedor()!= null) {
                modificaree(this.getProveedores());
            }else{
                guardar(this.getProveedores());
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }    
    }

    public ListaEnlazada<Proveedores> listado() {
        setListaProveedor(listar());
        return listaProveedor;
    }
}
