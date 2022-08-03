/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.DAO.AdaptadorDao;
import controlador.tda.lista.ListaEnlazadaServices;
import modelo.Clientes;

/**
 *
 * @author Pc
 */
public class UsuarioController extends AdaptadorDao<Clientes> {

    private Clientes usuario;
    private ListaEnlazadaServices<Clientes> listaUsuarios = new ListaEnlazadaServices<Clientes>();

    public UsuarioController() {
        super(Clientes.class);
        listado();
    }

    public Clientes getUsuario() {
        if (this.usuario == null) {
            this.usuario = new Clientes();
        }

        return usuario;
    }

    public void setUsuario(Clientes usuario) {
        this.usuario = usuario;
    }

    public ListaEnlazadaServices<Clientes> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListainmueble(ListaEnlazadaServices<Clientes> listaUsuario) {
        this.listaUsuarios = listaUsuario;
    }

    public Boolean guardar() {
        try {

            guardar(getUsuario());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar autor" + e);
        }
        return false;
    }

    public Boolean modificar(Integer pos) {
        try {

            modificar(getUsuario(), pos);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar ticket" + e);
        }
        return false;
    }


    public Boolean eliminars(Integer pos) {
        try {

            eliminar(pos);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar ticket" + e);
        }
        return false;
    }


    public ListaEnlazadaServices<Clientes> listado() {
        setListainmueble(listar());
        return listaUsuarios;

    }
    
}
