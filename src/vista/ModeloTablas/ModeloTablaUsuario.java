/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ModeloTablas;

import controlador.tda.lista.ListaEnlazadaServices;
import javax.swing.table.AbstractTableModel;
import modelo.Usuario;

/**
 *
 * @author Pc
 */
public class ModeloTablaUsuario extends AbstractTableModel{
    
    
private ListaEnlazadaServices<Usuario> lista = new ListaEnlazadaServices<>();

     public ListaEnlazadaServices<Usuario> getLista() {
          return lista;
     }

     public void setLista(ListaEnlazadaServices<Usuario> lista) {
          this.lista = lista;
     }

    

    @Override
    public int getColumnCount() {
        return 6;
        
    }

    @Override
    public int getRowCount() {
        return lista.getSize();
    }
@Override
    public Object getValueAt(int i, int i1) {
        Usuario usuario = lista.obtenerDato(i);
        switch (i1) {
            case 0:
                return (i + 1);
            case 1:
                return usuario.getNombreUsuario();
            case 2:
                return usuario.getContrasena();
            case 3:
                return usuario.getDireccion();
            case 4:
                return usuario.getTelefono();
            case 5:
                return usuario.getCorreo();

            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "NRO";
            case 1:
                return "NOMBRE";
            case 2:
                return "APELLIDO";
            case 3:
                return "CEDULA";
            case 4:
                return "TELEFONO";
            case 5:
                return "CORREO";

            default:
                return null;
        }
    }

}
