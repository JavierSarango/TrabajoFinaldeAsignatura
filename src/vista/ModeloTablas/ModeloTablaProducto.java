/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.ModeloTablas;

import controlador.tda.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Producto;

/**
 *
 * @author Diego Márquez
 */
public class ModeloTablaProducto extends AbstractTableModel{
    private ListaEnlazada<Producto> lista = new ListaEnlazada<>();

    public ListaEnlazada<Producto> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Producto> lista) {
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
    public Object getValueAt(int arg0, int arg1) {
        Producto p=null;
        try {
            p = lista.obtenerDato(arg0);
        } catch (Exception e) {
        }
        
        switch(arg1){
            case 0: return (arg0 + 1);
            case 1: return (p !=null) ? p.getCodigo() : "Dato Vacío";
            case 2: return (p !=null) ? p.getNombre(): "Dato Vacío";
            case 3: return (p !=null) ? p.getDescripcion(): "Dato Vacío";
            case 4: return (p !=null) ? p.getPrecioCompra(): "Dato Vacío";
            case 5: return (p !=null) ? p.getPrecioVenta(): "Dato Vacío";
            case 6: return (p !=null) ? p.getProveedor(): "Dato Vacío";
            default:return null;
            
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "nro";
            case 1: return "Codigo";
            case 2: return "Nombre";
            case 3: return "Descripcion";
            case 4: return "Precio Compra";
            case 5: return "Precio Venta";
            case 6: return "Proveedor";
            default:return null;
            
        }
        
    }
    
    
    
}
