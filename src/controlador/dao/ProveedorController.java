/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.DAO.AdaptadorDao;
import controlador.tda.lista.ListaEnlazadaServices;
import modelo.Proveedores;

/**
 *
 * @author Nathaly
 */
public class ProveedorController extends AdaptadorDao<Proveedores>{

    private Proveedores proveedores;
    private ListaEnlazadaServices<Proveedores> listaProveedor;

    public  ProveedorController() {
        super(Proveedores.class);
        listado();
    }

    public ListaEnlazadaServices<Proveedores> getListaProveedores() {

        return listaProveedor;
    }

    public void setListaProveedores(ListaEnlazadaServices<Proveedores> listaProveedores) {
        this.listaProveedor = listaProveedor;
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

    public Boolean guardar() {
        try {
            getProveedores().setId_Proveedor(listaProveedor.getSize() + 1);
            guardar(getProveedores());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar" + e);
        }
        return false;
    }

    public Boolean modificar(Integer pos) {
        try {

            modificar(getProveedores(), pos);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar" + e);
        }
        return false;
    }

    public ListaEnlazadaServices<Proveedores> listado() {
        setListaProveedores(listar());
        return listaProveedor;
    }
}
