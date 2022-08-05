/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.tda.lista.ListaEnlazada;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelo.Usuario;


/**
 *
 * @author Pc
 */
public class UsuarioContr extends AdaptadorDao<Usuario> {
     
    private Usuario usuario;
    private ListaEnlazada<Usuario> listausuario;

    public  UsuarioContr() {
        super(Usuario.class);
        listar();
    }

    public Usuario getUsuario() {
        if (this.usuario == null) {
            this.usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ListaEnlazada<Usuario> getListaUsuario() {
        return listausuario;
    }

    public void setListaUsuario(ListaEnlazada<Usuario> listaUsuario) {
        this.listausuario = listaUsuario;
    }

 

    public Boolean guardar() {
        try {
            getUsuario().setId_usuario(listausuario.getSize() + 1);
            guardar(getUsuario());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar" + e);
        }
        return false;
    }

    public Boolean modificar(Integer pos) {
        try {

            modificaree(getUsuario());
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar" + e);
        }
        return false;
    }

    public ListaEnlazada<Usuario> listado() {
        setListaUsuario(listar());
        return listausuario;
    }
}
    
