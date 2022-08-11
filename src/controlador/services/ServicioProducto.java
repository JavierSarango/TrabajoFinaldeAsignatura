/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.services;

import controlador.dao.ProductoDao;
import controlador.tda.lista.ListaEnlazada;
import modelo.Producto;

/**
 *
 * @author diego
 */
public class ServicioProducto {

    private ProductoDao obj = new ProductoDao();

    public ListaEnlazada<Producto> listar() {
        return obj.listar();
    }

    public Boolean guardar_modificar() {
        return obj.guardar_modificar();
    }

    public Producto getProducto() {
        return obj.getProducto();
    }

    public void setProducto(Producto producto) {
        obj.setProducto(producto);
    }

    public Producto obtener_id(Integer id) {
        try {
            return obj.obtener(id);
        } catch (Exception e) {
            System.out.println("Error al obtener id de Producto");
            return null;
        }

    }
}
