/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.tda.lista.ListaEnlazada;
import modelo.Proveedor;

/**
 *
 * @author Gigabyte
 */
public class ProveedorDao extends AdaptadorDao<Proveedor> {

    private Proveedor proveedor;
    private ListaEnlazada<Proveedor> listaProoveedores;

    public ProveedorDao() {
        super(Proveedor.class);
    }

    public Proveedor getProveedores() {
        if (proveedor == null) {
            proveedor = new Proveedor();
        }
        return proveedor;
    }

    public void setProveedores(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Boolean guardar() {
        try {         
                guardar(this.getProveedores());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }
    }

   
    }
