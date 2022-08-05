/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ModeloTablas;

import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.ListaEnlazadaServices;
import javax.swing.table.AbstractTableModel;
import modelo.Proveedores;

/**
 *
 * @author Nathaly
 */
public class ModeloTablaProveedores extends AbstractTableModel {

    ListaEnlazada<Proveedores> lista;

    public ListaEnlazada<Proveedores> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Proveedores> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public int getColumnCount() {
        return 13;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        try {
            Proveedores p = lista.obtenerDato(i);
            switch (i1) {

                case 0:
                    return p.getAgenteResponsable();
                case 1:
                    return p.getProvincia();
                case 2:
                    return p.getTelefono();
                case 3:
                    return p.getDireccion();
                case 4:
                    return p.getIdentificacion();
                case 5:
                    return p.getRazonSocial();
                case 6:
                    return p.getContacto();
                case 7:
                    return p.getCorreo();
                case 8:
                    return p.getBanco();
                case 9:
                    return p.getTipoc();
                case 10:
                    return p.getCuentaBancaria();
                case 11:
                    return p.getCredito();
                case 12:
                    return p.getRedsocial();

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
                return "AGENTE RESPONSABLE";
            case 1:
                return "PROVINCIA";
            case 2:
                return "TELEFONO";
            case 3:
                return "DIRECCION";
            case 4:
                return "RUC";
            case 5:
                return "RAZON SOCIAL";
            case 6:
                return "CONTACTO";
            case 7:
                return "CORREO";
            case 8:
                return "BANCO";
            case 9:
                return "TIPO CUENTA";
            case 10:
                return "NRO CUENTA";
            case 11:
                return "CREDITO";
            case 12:
                return "RED SOCIAL";

            default:
                return null;
        }
    }
}
