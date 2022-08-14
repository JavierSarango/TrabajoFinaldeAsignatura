/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ModeloTablas;

import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.ListaEnlazadaServices;
import javax.swing.table.AbstractTableModel;
import modelo.Usuario;

/**
 *
 * @author Pc
 */
public class ModeloTablaUsuario extends AbstractTableModel {

    ListaEnlazada<Usuario> lista;

    public ListaEnlazada<Usuario> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Usuario> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        try {
            Usuario usuario = lista.obtenerDato(i);
            switch (i1) {

                case 0:
                    return usuario.getId_usuario();
                case 1:
                    return usuario.getRazonSocial();
                case 2:
                    return usuario.getTipoIdentificacion();
                case 3:
                    return usuario.getIdentificacion();
                case 4:
                    return usuario.getTipoRol();
                case 5:
                    return usuario.getTelefono();
                case 6:
                    return usuario.getCelular();
                case 7:
                    return usuario.getCorreo();
                            case 8:
                    return usuario.getDireccion();
                case 9:
                    return usuario.getNombreUsuario();
                case 10:
                    return usuario.getContrasena();
                default:
                    return null;
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "NRO";
            case 1:
                return "Razon Social";
            case 2:
                return "Tipo de identificacion";
            case 3:
                return "identificacion";
            case 4:
                return "tipo cliente ";
            case 5:
                return "telefono";
            case 6:
                return "celular";
            case 7:
                return "correo";
                           case 8:
                return "direccion";
            case 9:
                return "Nombre usuario ";
                      case 10:
                return "Contraseña";
            default:
                return null;
        }
    }

}
