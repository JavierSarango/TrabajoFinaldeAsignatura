/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.ModeloTablas;

import controlador.tda.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Cliente;

/**
 *
 * @author jy
 */
public class ModeloTablaCliente extends AbstractTableModel {

    ListaEnlazada<Cliente> lista;

    public ListaEnlazada<Cliente> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Cliente> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        try {
            Cliente cliente = lista.obtenerDato(i);
            switch (i1) {

                case 0:
                    return (i + 1);
                case 1:
                    return cliente.getRazonSocial();
                case 2:
                    return cliente.getTipoIdentificacion();
                case 3:
                    return cliente.getIdentificacion();
                case 4:
                    return cliente.getTipoCliente();
                case 5:
                    return cliente.getTelefono();
                case 6:
                    return cliente.getCelular();
                case 7:
                    return cliente.getCorreo();
                case 8:
                    return cliente.getFechaNacimiento();
                                    case 9:
                    return cliente.getDireccion();
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
                return "fecha nacimiento";
                     case 9:
                return "Direccion";
            default:
                return null;
        }
    }

}
