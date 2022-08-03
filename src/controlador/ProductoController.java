/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.dao.ProductoDao;
import controlador.tda.lista.ListaEnlazada;
import modelo.Producto;

/**
 *
 * @author diego
 */
public class ProductoController {

    ProductoDao pd = new ProductoDao();

    /**
     *Permite modificaree la lista po fuera del Dao, permite generar lista en memoria
     */
    public boolean modificar(int ubicacion, Producto aux) {

        ListaEnlazada<Producto> lp = pd.listar();
        for (int i = 0; i < lp.tamanio(); i++) {
            if (ubicacion == lp.consultarDatoPosicion(i).getId()) {
                pd.modificar(aux, ubicacion);
            }

        }
        return true;
    }
    /**
     *Muestra las listas generadas en momoria
     */
    public Producto mostrar(int ubicacion) {
        System.out.println("Entra a mostrar del controlador");

        System.err.println(ubicacion);

        Producto aux = new Producto();
        ListaEnlazada<Producto> lp = pd.listar();

        for (int i = 0; i < lp.tamanio(); i++) {

            if (ubicacion == lp.consultarDatoPosicion(i).getId()) {
                aux = lp.consultarDatoPosicion(ubicacion);
                System.out.println(aux.getNombre());
            }

        }

        return aux;
    }

}