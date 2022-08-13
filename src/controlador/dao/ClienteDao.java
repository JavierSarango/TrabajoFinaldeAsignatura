/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import modelo.Cliente;

/**
 *
 * @author Pc
 */
public class ClienteDao extends AdaptadorDao<Cliente> {

    private Cliente cliente;

    public ClienteDao() {
        super(Cliente.class);
    }

    public Cliente getCliente() {
        if (cliente == null) {
            cliente = new Cliente();
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boolean guardar() {
        try {
            guardar(this.getCliente());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }
    }

    public Boolean delete(Integer pos) {
        try {
            eliminaras(pos);
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }
    }
    
       public Boolean modif(Integer pos) {
        try {
            modificaree(this.getCliente());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }
    }

}
