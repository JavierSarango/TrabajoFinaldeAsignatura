/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ModeloTablas;

import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.ListaEnlazadaServices;
import javax.swing.table.AbstractTableModel;
import modelo.Proveedor;

/**
 *
 * @author Nathaly
 */
public class ModeloTablaProveedores extends AbstractTableModel {

    ListaEnlazada<Proveedor> lista;

    public ListaEnlazada<Proveedor> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Proveedor> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public int getColumnCount() {
        return 15;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        try {
            Proveedor p = lista.obtenerDato(i);
            switch (i1) {

                case 0:
                    return p.getAgenteResponsable();
                case 1:
                    return p.getProvincia();
                case 2:
                    return p.getDireccionp();
                case 3:
                    return p.getDireccions();
                case 4:
                    return p.getIdentificacion();
                case 5:
                    return p.getRazonSocial();
                case 6:
                    return p.getTelefono();
                case 7:
                    return p.getCelular();
                case 8:
                    return p.getTelefonoO();
                case 9:
                    return p.getCorreo();
                case 10:
                    return p.getPaginaweb();
                case 11:
                    return p.getBanco();
                case 12:
                    return p.getTipocuenta();
                case 13:
                    return p.getNrocuenta();
                case 14:
                    return p.getCredito();

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
                return "CALLE PRINCIPAL";
            case 3:
                return "CALLE SECUNDARIA";
            case 4:
                return "RUC";
            case 5:
                return "RAZON SOCIAL";
            case 6:
                return "TELEFONO FIJO";
            case 7:
                return "CELULAR";
            case 8:
                return "TELEFONO OPCIONAL";
            case 9:
                return "EMAIL";
            case 10:
                return "PAGINA WEB";
            case 11:
                return "BANCO";
            case 12:
                return "TIPO CUENTA";
            case 13:
                return "NRO CUENTA";
            case 14:
                return "CREDITO";

            default:
                return null;
        }
    }

}
