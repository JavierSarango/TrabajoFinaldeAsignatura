/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import com.mysql.cj.protocol.Resultset;
import controlador.tda.lista.ListaEnlazada;
import modelo.Venta;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import controlador.ConexionBD;
import java.sql.SQLException;
/**
 *
 * @author Gigabyte
 */
public class VentaController implements InterfazDao<Venta> {
    private Venta venta;
    private ListaEnlazada<Venta> listaVentas;
    private ConexionBD cbd = new ConexionBD();
    Statement st;
    Resultset rs;

    

    public Venta getVenta() {
        if (venta == null) {
            venta = new Venta();
        }
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public ListaEnlazada<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ListaEnlazada<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    @Override
    public void guardar(Venta dato) throws Exception {
        Connection con = cbd.conectar();
        String sql = "INSERT INTO ventas(id_Venta, id_Producto, id_Cliente, cantidad, precioUnitario, subTotal, iva, totalPagar, descuento) VALUE(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, venta.getId_Venta());
            ps.setInt(2, venta.getId_Producto());
            ps.setInt(3, venta.getId_Cliente());
            ps.setInt(4, venta.getCantidad());
            ps.setDouble(5, venta.getPrecioUnitario());
            ps.setDouble(6, venta.getSubTotal());
            ps.setDouble(7, venta.getIva());
            ps.setDouble(8, venta.getTotalPagar());
            ps.setDouble(9, venta.getDescuento());

            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error en guardar en Base de datos " + ex);
            
        }
    }

    @Override
    public void modificaree(Venta dato) throws Exception {
         PreparedStatement pst;
        Connection con = cbd.conectar();
        String sql = ("UPDATE venta SET id_Producto=?, id_Cliente=?, cantidad=?, precioUnitario=?, subTotal=?, iva=?, totalPagar=?, descuento=? WHERE id_Venta =?");
        try {
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, venta.getId_Producto());
            pst.setInt(2, venta.getId_Cliente());            
            pst.setInt(3, venta.getCantidad());
            pst.setDouble(4, venta.getPrecioUnitario());
            pst.setDouble(5, venta.getSubTotal());
            pst.setDouble(6, venta.getIva());
            pst.setDouble(7, venta.getTotalPagar());
            pst.setDouble(8, venta.getDescuento());
        
            pst.executeUpdate();
            pst.close();
            
        } catch (SQLException e) {
            System.out.println(e);
            
        }
    }

    @Override
    public void eliminar(Venta dato) throws Exception {
        
        PreparedStatement ps = null;
        Connection con = cbd.conectar();
        String sql = ("DELETE FROM venta WHERE id_Venta = ?");
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, venta.getId_Venta());
            ps.executeUpdate();
            con.close();
            
        } catch (SQLException e) {
            System.out.println("Erro al eliminar " + e);
          
        }
    }

    @Override
    public ListaEnlazada<Venta> listar() {
//        st = null;
//        rs = null;
//        ListaEnlazada<Venta> lista = new ListaEnlazada<>();
//        try {
//            Connection con = cbd.conectar();
//            st = (Statement) con.createStatement();
//            rs = st.executeQuery("SELECT * FROM venta");
//            while (rs.next()) {
//                Venta venta = new Persona();
//                lisPers.setClazz(venta.getClass());
//                venta.setId(rs.getInt("id_usuario"));
//                venta.setNombre(rs.getString("nombre"));
//                venta.setApellido(rs.getString("apellido"));
//                venta.setCedula(rs.getString("cedula"));
//                venta.setCelular(rs.getString("celular"));
//                venta.setCorreo(rs.getString("correo"));
//                venta.setDireccion(rs.getString("direccion"));
//                venta.setPassword(rs.getString("password"));
//                venta.getRol().setCargo(rs.getString("cargo"));
//                venta.getRol().setAutorizacion(rs.getBoolean("autorizacion"));
//                venta.getRol().setDescripcion(rs.getString("descripcion"));
//                lisPers.insertarNodo(venta);
//                lista.insertarNodo((T) venta);
//
//            }
//
//        } catch (Exception e) {
//            System.out.println("Error en listar Usuario" + e);
//        }
//        setLisPers(lisPers);
//        return lista;
    }

    @Override
    public Venta obtener(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
    
    
    
    
    
}
