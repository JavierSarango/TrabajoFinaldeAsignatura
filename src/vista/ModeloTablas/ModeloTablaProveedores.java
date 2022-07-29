/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ModeloTablas;

import controlador.tda.lista.ListaEnlazadaServices;
import javax.swing.table.AbstractTableModel;
import modelo.Proveedores;

/**
 *
 * @author Nathaly
 */
public class ModeloTablaProveedores extends AbstractTableModel {

    ListaEnlazadaServices<Proveedores> lista;

    public ListaEnlazadaServices<Proveedores> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazadaServices<Proveedores> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Proveedores p = lista.obtenerDato(i);
        switch (i1) {

            case 0:
                return p.getAgenteResponsable();
            case 1:
                return p.getProvincia();
            case 2:
                return p.getTelefono();
            case 3:
                return p.getProducto();
            case 4:
                return p.getRazonSocial();
            case 5:
                return p.getCorreo();

            default:
                return null;
        }
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
                return "PRODUCTO";
            case 4:
                return "RUC";
            case 5:
                return "CORREO";

            default:
                return null;
        }
    }
}
