/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.DetalleVenta;
import modelo.Venta;

/**
 *
 * @author Gigabyte
 */
public class VentaDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Integer respuesta = 0;

    public String id_Venta() {
        String idv = "";
        String sql = "SELECT MAX(id_Venta) FROM venta";
        try {
            con = Conexion.getConecction();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idv = rs.getString(1);
            }
        } catch (Exception e) {
        }

        return idv;
    }

    public Integer GuardarVenta(Venta venta) {
//    Venta v = new Venta();
        String sql = "INSERT INTO venta (id_Cliente,nroSerie,fechaVenta,monto) VALUES (?,?,?,?)";
        try {
            con = Conexion.getConecction();
            ps = con.prepareStatement(sql);            
            ps.setInt(1, venta.getId_Cliente());
            ps.setString(2, venta.getNroVentas());
            ps.setString(3, venta.getFechaVenta());
            ps.setDouble(4, venta.getMonto());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return respuesta;
    }

    public Integer GuardarDetalleVenta(DetalleVenta dv) {
        String sql = "INSERT INTO detalle_ventas (idVentas,idProducto,cantidad,precioVenta)VALUES (?,?,?,?)";
        try {
            con = Conexion.getConecction();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dv.getId_Venta());
            ps.setInt(2, dv.getId_Producto());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getPrecioVenta());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return respuesta;
    }

//
//    private Venta venta;
////    private ListaEnlazada<Venta> listaVentas;
////    private ConexionBD cbd = new ConexionBD();
////    Statement st;
////    Resultset rs;
//
//    public VentaDao() {
//        super(Venta.class);
//    }
//
//    public Venta getVenta() {
//        if (venta == null) {
//            venta = new Venta();
//        }
//        return venta;
//    }
//
//    public void setVenta(Venta venta) {
//        this.venta = venta;
//    }
//
//    public Boolean guardar() {
//        try {         
//                guardar(this.getVenta());
//            
//            return true;
//        } catch (Exception e) {
//            System.out.println("Error en guardar o modificar");
//            return false;
//        }
//    }
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
