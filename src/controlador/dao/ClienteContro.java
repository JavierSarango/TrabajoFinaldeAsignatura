/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.tda.lista.ListaEnlazada;
import modelo.Cliente;

/**
 *
 * @author Pc
 */
public class ClienteContro extends AdaptadorDao<Cliente>{

    private Cliente cliente;
    private ListaEnlazada<Cliente> listacliente;

    public  ClienteContro() {
        super(Cliente.class);
        listar();
    }

    public Cliente getCliente() {
        if (this.cliente == null) {
            this.cliente = new Cliente();
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ListaEnlazada<Cliente> getListaCliente() {
        return listacliente;
    }

    public void setListaCliente(ListaEnlazada<Cliente> listaCliente) {
        this.listacliente = listaCliente;
    }

 

    public Boolean guardar() {
        try {
            getCliente().setId_cliente(listacliente.getSize() + 1);
            guardar(getCliente());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar" + e);
        }
        return false;
    }

    public Boolean modificar(Integer pos) {
        try {

            modificaree(getCliente());
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar" + e);
        }
        return false;
    }

    public ListaEnlazada<Cliente> listado() {
        setListaCliente(listar());
        return listacliente;
    }
}
