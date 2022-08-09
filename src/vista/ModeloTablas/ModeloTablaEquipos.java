/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.ModeloTablas;

import controlador.tda.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.EquipoElectronico;
import modelo.Proveedores;

/**
 *
 * @author jona
 */
public class ModeloTablaEquipos extends AbstractTableModel {

    ListaEnlazada<EquipoElectronico> lista;

    public ListaEnlazada<EquipoElectronico> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<EquipoElectronico> lista) {
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
            EquipoElectronico p = lista.obtenerDato(i);
            switch (i1) {

                case 0:
                    return p.getRazonSocial();
                case 1:
                    return p.getModelo();
                case 2:
                    return p.getMarca();
                case 3:
                    return p.getCargador();
                case 4:
                    return p.getEstado_Ingreso();
                case 5:
                    return p.getDescripcion_Problema();
                case 6:
                    return p.getTipo_Equipo();
                case 7:
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
                return "RAZON SOCIAL";
            case 1:
                return "MODELO";
            case 2:
                return "MARCA";
            case 3:
                return "CARGADOR";
            case 4:
                return "ESTADO INGRESO";
            case 5:
                return "DESCRIP PROBLEMA";
            case 6:
                return "TIPO EQUIPO";
            case 7:
                return "PRECIO SERVICIO";

            default:
                return null;
        }

    }

}
