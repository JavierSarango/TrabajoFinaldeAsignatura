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

    public Boolean guardar_modificar() {

        try {
            if (getVenta().getId_Venta() != null) {
                modificaree(this.getVenta());
            } else {
                guardar(this.getVenta());

            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }
    }

//    public static void main(String[] args) {
//        VentaDao dao = new VentaDao();
//        ListaEnlazada<Venta> lista = dao.listar();
////        dao.getVenta().setId_Venta(1);
//        dao.getVenta().setId_Producto(45);
//        dao.getVenta().setId_Cliente(13);
//        dao.getVenta().setCantidad(2);
//        dao.getVenta().setPrecioUnitario(56.74);
//        dao.getVenta().setSubTotal(dao.ObtenerSubTotal(dao.getVenta().getCantidad(), dao.getVenta().getPrecioUnitario()));
//        dao.getVenta().setIva(0.12);
//        dao.getVenta().setDescuento(0.10);
//        dao.getVenta().setTotalPagar(dao.ObtenerTotal(dao.getVenta().getDescuento(), dao.getVenta().getSubTotal(), dao.getVenta().getIva()));
//dao.guardar_modificar();
//        try {
//            dao.guardar(dao.getVenta());
//        } catch (Exception e) {
//        }
//    }

    public Double ObtenerSubTotal(Integer cantidad, Double precio) {
        Double subT = 0.00;
        subT = cantidad * precio;
        return subT;

    }

    public Double ObtenerTotal(Double descuento, Double subtotal, Double iva) {
        Double total = 0.00;
        Double valorIva = 0.00;
        if (this.getVenta().getDescuento() != 0.00) {
            Double valorDes = 0.00;
            valorDes = subtotal - (subtotal * descuento);

            valorIva = ((subtotal - valorDes) + ((subtotal - valorDes) * iva));
            total = (subtotal - valorDes) + valorIva;
        } else {
            valorIva = subtotal + (subtotal * iva);
            total = subtotal + valorIva;

        }
        return total;
    }

//    public ListaEnlazada<Venta> getListaVentas() {
//        return listaVentas;
//    }
//
//    public void setListaVentas(ListaEnlazada<Venta> listaVentas) {
//        this.listaVentas = listaVentas;
//    }
//
//    @Override
//    public void guardar(Venta dato) throws Exception {
//        Connection con = cbd.conectar();
//        String sql = "INSERT INTO ventas (id_Venta, id_Producto, id_Cliente, cantidad, precioUnitario, subTotal, iva, totalPagar, descuento) VALUE(?,?,?,?,?,?,?,?,?)";
//        try {
//            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
//            ps.setInt(1, venta.getId_Venta());
//            ps.setInt(2, venta.getId_Producto());
//            ps.setInt(3, venta.getId_Cliente());
//            ps.setInt(4, venta.getCantidad());
//            ps.setDouble(5, venta.getPrecioUnitario());
//            ps.setDouble(6, venta.getSubTotal());
//            ps.setDouble(7, venta.getIva());
//            ps.setDouble(8, venta.getTotalPagar());
//            ps.setDouble(9, venta.getDescuento());
//
//            ps.executeUpdate();
//            ps.close();
//            
//        } catch (SQLException ex) {
//            System.out.println("Error en guardar en Base de datos " + ex);
//            
//        }
//    }
//
//    @Override
//    public void modificaree(Venta dato) throws Exception {
//         PreparedStatement pst;
//        Connection con = cbd.conectar();
//        String sql = ("UPDATE ventas SET id_Producto=?, id_Cliente=?, cantidad=?, precioUnitario=?, subTotal=?, iva=?, totalPagar=?, descuento=? WHERE id_Venta =?");
//        try {
//            pst = (PreparedStatement) con.prepareStatement(sql);
//            pst.setInt(1, venta.getId_Producto());
//            pst.setInt(2, venta.getId_Cliente());            
//            pst.setInt(3, venta.getCantidad());
//            pst.setDouble(4, venta.getPrecioUnitario());
//            pst.setDouble(5, venta.getSubTotal());
//            pst.setDouble(6, venta.getIva());
//            pst.setDouble(7, venta.getTotalPagar());
//            pst.setDouble(8, venta.getDescuento());
//        
//            pst.executeUpdate();
//            pst.close();
//            
//        } catch (SQLException e) {
//            System.out.println(e);
//            
//        }
//    }
//
//    @Override
//    public void eliminar(Venta dato) throws Exception {
//        
//        PreparedStatement ps = null;
//        Connection con = cbd.conectar();
//        String sql = ("DELETE FROM ventas WHERE id_Venta = ?");
//        try {
//            ps = (PreparedStatement) con.prepareStatement(sql);
//            ps.setInt(1, venta.getId_Venta());
//            ps.executeUpdate();
//            con.close();
//            
//        } catch (SQLException e) {
//            System.out.println("Erro al eliminar " + e);
//          
//        }
//    }
//
//    @Override
//    public ListaEnlazada<Venta> listar() {
//        st = null;
//        rs = null;
//        ListaEnlazada<Venta> lista = new ListaEnlazada<>();
//        try {
//            Connection con = cbd.conectar();
//            st = (Statement) con.createStatement();
//            rs = (Resultset) st.executeQuery("SELECT * FROM ventas");
//            
//            while (rs.next()) {
//                Venta venta = new Venta();
//               
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
//                listaVentas.insertarCabecera(venta);
//                lista.insertarCabecera(venta);
//
//            }
//
//        } catch (Exception e) {
//            System.out.println("Error en listar Usuario" + e);
//        }
//        setLisPers(lisPers);
//        return lista;
//    }
//
//    @Override
//    public Venta obtener(Integer id) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
