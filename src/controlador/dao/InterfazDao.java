/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.ListaEnlazadaServices;

/**
 *
 * @author Nathaly
 */
public interface InterfazDao <T> {
    
    
    public void guardar(T dato) throws Exception;
    public void modificaree(T dato) throws Exception;
    public void modificar(T dato) throws Exception;
    public void eliminar(T dato) throws Exception;
    public ListaEnlazada<T> listar();
    public T obtener(Integer id) throws Exception;
}
