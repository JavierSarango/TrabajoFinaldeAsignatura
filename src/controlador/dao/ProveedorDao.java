/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.tda.lista.ListaEnlazada;
import modelo.Proveedor;

/**
 *
 * @author Gigabyte
 */
public class ProveedorDao extends AdaptadorDao<Proveedor> {

    private Proveedor proveedor;
//    private ListaEnlazada<Venta> listaVentas;
//    private ConexionBD cbd = new ConexionBD();
//    Statement st;
//    Resultset rs;

    public ProveedorDao() {
        super(Proveedor.class);
    }

    public Proveedor getProveedores() {
        if (proveedor == null) {
            proveedor = new Proveedor();
        }
        return proveedor;
    }

    public void setProveedores(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Boolean guardar() {
        try {         
                guardar(this.getProveedores());
            
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }
    }

    /**
     * Permmite obtener el subtotal de la proveedor mediante el producto de la
 cantidad de productos por el precioUnitario
     *
     * @param cantidad
     * @param precio
     * @return el subtotal de la proveedor
     */
    public Double ObtenerSubTotal(Integer cantidad, Double precio) {
        Double subT = 0.00;
        subT = cantidad * precio;
        return subT;

    }

    /**
     * Permite obtener el total de la proveedor tomando en consideracion la
 existencia o no de un descuento, el subtotal obtenido y el valor del IVA
     *
     * @param descuento
     * @param subtotal
     * @param iva
     * @return el total a pagar de la proveedor
     */
//    public Double ObtenerTotal(Double descuento, Double subtotal, Double iva) {
//        Double total = 0.00;
//        Double valorIva = 0.00;
//        if (this.getVenta().getDescuento() != 0.00) {
//            Double valorDes = 0.00;
//            valorDes = subtotal - (subtotal * descuento);
//
//            valorIva = ((subtotal - valorDes) + ((subtotal - valorDes) * iva));
//            total = (subtotal - valorDes) + valorIva;
//        } else {
//            valorIva = subtotal + (subtotal * iva);
//            total = subtotal + valorIva;
//
//        }
//        return total;
//    }

   

    public Boolean validar(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
        Metodo para validar que el usuario no ingrese caracteres no numericos
     */
    public Boolean validarDouble(String valor) {
        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
