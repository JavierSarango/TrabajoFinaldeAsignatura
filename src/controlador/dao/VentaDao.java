/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.Conexion;
import controlador.tda.lista.ListaEnlazada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Cliente;
import modelo.DetalleVenta;
import modelo.Venta;

/**
 *
 * @author Gigabyte
 */
public class VentaDao  {

    private Venta venta;

    public Venta getVenta() {
        if (venta == null) {
            venta = new Venta();
        }
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Integer respuesta = 0;
    
    public String nroSerieVenta(){
    String serie = "";
    String sql = "SELECT MAX(nroSerie) from venta";
    
        try {
            con =Conexion.getConecction();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                serie = rs.getString(1);
            }
        } catch (Exception e) {
        }
    
    
    return serie;
    }

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
            ps.setString(2, venta.getNrodeSerieVenta());
            ps.setString(3, venta.getFechaVenta());
            ps.setDouble(4, venta.getMonto());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return respuesta;
    }

    public Integer GuardarDetalleVenta(DetalleVenta dv) {
        String sql = "INSERT INTO detalle_ventas (idVentas,idProducto,cantidad,precioVenta) VALUES (?,?,?,?)";
        try {
            con = Conexion.getConecction();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dv.getId_Venta());
            ps.setInt(2, dv.getId_Producto());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getPrecioVenta());
           ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en detalle venta No se pudo guardar");
            e.printStackTrace();
        }
        return respuesta;
    }  
    
    public ListaEnlazada listar(){
    ListaEnlazada<Venta> lista = new ListaEnlazada<>();
    String sql ="SELECT monto FROM VENTA";
        try {
            con = Conexion.getConecction();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Venta venta = new Venta();
                venta.setId_Venta(rs.getInt(1));
                venta.setId_Cliente(rs.getInt(2));
                venta.setNrodeSerieVenta(rs.getString(3));
                venta.setFechaVenta(rs.getString(4));
                venta.setMonto(rs.getDouble(5));
                lista.insertar(venta);
                
            }
            
        } catch (Exception e) {
        }
        return lista;
    }

        public ListaEnlazada listarIDVenta(Integer id_cliente) {
        Venta p = new Venta();
        String sql = "Select * from venta where id_Cliente = ?";
        ListaEnlazada<Venta> lista = new ListaEnlazada<>();
        try {
            con = Conexion.getConecction();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_cliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId_Venta(rs.getInt(1));
                p.setId_Cliente(rs.getInt(2));
                p.setNrodeSerieVenta(rs.getString(3));
                p.setFechaVenta(rs.getString(4));
                p.setMonto(rs.getDouble(5));
                lista.insertar(p);
            }
        } catch (Exception e) {
            System.out.println("Error en listar Id cliente");
            e.printStackTrace();
        }
        return lista;

    }

    public ListaEnlazada listarIDDetalleVenta(ListaEnlazada<Venta> lista) {
        DetalleVenta p = new DetalleVenta();
        String sql = "Select * from detalle_ventas where idVentas = ?";
        ListaEnlazada<DetalleVenta> lista2 = new ListaEnlazada<>();
        for (int i = 0; i < lista.getSize(); i++) {
            try {
                con = Conexion.getConecction();
                ps = con.prepareStatement(sql);
                ps.setInt(1, lista.obtenerDato(i).getId_Venta());
                rs = ps.executeQuery();
                while (rs.next()) {
                    p.setIdDetalleVenta(rs.getInt(1));
                    p.setId_Venta(rs.getInt(2));
                    p.setId_Producto(rs.getInt(3));
                    p.setCantidad(rs.getInt(4));
                    p.setPrecioVenta(rs.getDouble(5));
                    lista2.insertar(p);
                }
            } catch (Exception e) {
                System.out.println("Error en listar Id cliente");
                e.printStackTrace();
            }
        }

        return lista2;

    }
}
