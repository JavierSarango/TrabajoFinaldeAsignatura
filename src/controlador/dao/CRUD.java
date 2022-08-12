package controlador.dao;


import controlador.tda.lista.ListaEnlazada;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Nathaly
 */
public interface CRUD<E>{
    /**
     * Guardar BDD
     * @return boolean
     */
    public boolean Guardar();
    /**
     * Actualiza BDD
     * @return boolean
     */
    public boolean Actualizar();
    /**
     * 
     * @return 
     */
    public boolean Eliminar();
    /**
     * Lista de las tablas
     * @return Lista
     */
    public ListaEnlazada<E> listar();
}
