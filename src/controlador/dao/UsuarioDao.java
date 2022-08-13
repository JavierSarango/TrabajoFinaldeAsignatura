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
    public class UsuarioDao extends AdaptadorDao<Usuario> {

    private Usuario usuario;

    public UsuarioDao() {
        super(Usuario.class);
    }

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean guardar() {
        try {
            guardar(this.getUsuario());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }
    }

}
    
