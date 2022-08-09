/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.tda.lista.ListaEnlazada;
import modelo.Venta;

/**
 *
 * @author Gigabyte
 */
public class VentaDao extends AdaptadorDao<Venta> {

    private Venta venta;
//    private ListaEnlazada<Venta> listaVentas;
//    private ConexionBD cbd = new ConexionBD();
//    Statement st;
//    Resultset rs;

    public VentaDao() {
        super(Venta.class);
    }

    public Venta getVenta() {
        if (venta == null) {
            venta = new Venta();
        }
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Boolean guardar() {
        try {         
                guardar(this.getVenta());
            
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }
    }

    /**
     * Permmite obtener el subtotal de la venta mediante el producto de la
     * cantidad de productos por el precioUnitario
     *
     * @param cantidad
     * @param precio
     * @return el subtotal de la venta
     */
    public Double ObtenerSubTotal(Integer cantidad, Double precio) {
        Double subT = 0.00;
        subT = cantidad * precio;
        return subT;

    }

    /**
     * Permite obtener el total de la venta tomando en consideracion la
     * existencia o no de un descuento, el subtotal obtenido y el valor del IVA
     *
     * @param descuento
     * @param subtotal
     * @param iva
     * @return el total a pagar de la venta
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
