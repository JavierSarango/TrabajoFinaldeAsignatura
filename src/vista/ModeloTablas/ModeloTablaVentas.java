/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ModeloTablas;

import controlador.tda.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Venta;

/**
 *
 * @author John
 */
public class ModeloTablaVentas extends AbstractTableModel {

    ListaEnlazada<Venta> lista;

    public ListaEnlazada<Venta> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Venta> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        try {
            Venta p = lista.obtenerDato(i);
            switch (i1) {
                case 0:
                    return (p.getId_Venta());
                case 1:
                    return p.getId_Cliente();
                case 2:
                    return p.getNrodeSerieVenta();
                case 3:
                    return p.getFechaVenta();
                case 4:
                    return p.getMonto();
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
                return "ID";
            case 1:
                return "ID_CLIENTE";
            case 2:
                return "NRO SERIE DE VENTA";
            case 3:
                return "FECHA DE VENTA";
            case 4:
                return "MONTO A PAGAR";
            default:
                return null;
        }
    }
}
