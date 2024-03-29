/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ModeloTablas;

import controlador.tda.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Cliente;
import modelo.DetalleVenta;
import modelo.Producto;
import modelo.Venta;

/**
 *
 * @author John
 */
public class ModeloTablaVentas extends AbstractTableModel {

    private ListaEnlazada<Venta> listaVentas;
    private ListaEnlazada<DetalleVenta> listaDetalle;
    private ListaEnlazada<Producto> listaProducto;
    private Cliente cliente;

    public ListaEnlazada<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ListaEnlazada<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    /**
     * @return the listaDetalle
     */
    public ListaEnlazada<DetalleVenta> getListaDetalle() {
        return listaDetalle;
    }

    /**
     * @param listaDetalle the listaDetalle to set
     */
    public void setListaDetalle(ListaEnlazada<DetalleVenta> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    /**
     * @return the listaProducto
     */
    public ListaEnlazada<Producto> getListaProducto() {
        return listaProducto;
    }

    /**
     * @param listaProducto the listaProducto to set
     */
    public void setListaProducto(ListaEnlazada<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int getRowCount() {
        return listaVentas.getSize();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        for (int j = 0; j < listaVentas.getSize(); j++) {
            try {
                switch (i1) {
                    case 0:
                        return (listaVentas.obtenerDato(j).getId_Venta());
                    case 1:
                        return cliente.getRazonSocial();
                    case 2:
                        return listaVentas.obtenerDato(j).getNrodeSerieVenta();
                    case 3:
                        return listaVentas.obtenerDato(j).getFechaVenta();
                    case 4:
                        return listaProducto.obtenerDato(j).getNombre();
                    case 5:
                        return listaDetalle.obtenerDato(j).getCantidad();
                    case 6:
                        return listaDetalle.obtenerDato(j).getPrecioVenta();
                    case 7:
                        return listaVentas.obtenerDato(j).getMonto();
                    default:
                        return null;
                }
            } catch (Exception e) {
            }
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
                return "NRO SERIE DE VENTA";
            case 3:
                return "FECHA DE VENTA";
            case 4:
                return "NOMBRE PRODUCTO";
            case 5:
                return "CANTIDAD";
            case 6:
                return "PRECIO DE VENTA";
            case 7:
                return "MONTO A PAGAR";
            default:
                return null;
        }
    }

}
