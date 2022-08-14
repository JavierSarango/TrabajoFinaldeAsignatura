/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.ModeloTablas;

import controlador.tda.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.equipo;

/**
 *
 * @author jona
 */
public class ModeloTablaEquipos extends AbstractTableModel {

    ListaEnlazada<equipo> lista;

    public ListaEnlazada<equipo> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<equipo> lista) {
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
            equipo p = lista.obtenerDato(i);
            switch (i1) {
                case 0:
                    return p.getId_equipo();
                case 1:
                    return p.getRazon_social();
                case 2:
                    return p.getModelo();
                case 3:
                    return p.getMarca();
                case 4:
                    return p.getCargador();
                case 5:
                    return p.getEstado_ingreso();
                case 6:
                    return p.getDescripcion_problema();
                case 7:
                    return p.getTipo_equipo();
                case 8:
                    return p.getPrecio_servicio();
                
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
                return "RAZON SOCIAL";
            case 2:
                return "MODELO";
            case 3:
                return "MARCA";
            case 4:
                return "CARGADOR";
            case 5:
                return "ESTADO INGRESO";
            case 6:
                return "DESCRIP PROBLEMA";
            case 7:
                return "TIPO EQUIPO";
            case 8:
                return "PRECIO SERVICIO";

            default:
                return null;
        }

    }

}
