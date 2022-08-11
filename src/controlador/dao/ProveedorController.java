/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.Conexion;
import controlador.tda.lista.ListaEnlazada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Proveedor;
import modelo.Persona;

/**
 *
 * @author Nathaly
 */
public class ProveedorController<T> implements CRUD {

    private ListaEnlazada<Proveedor> listaproveedores = new ListaEnlazada<>();
    private Proveedor proveedores;
    private ListaEnlazada<T> lista = new ListaEnlazada<>();
    private Class<T> clazz;
    Conexion c = new Conexion();
    Statement st;
    ResultSet rs;

    public ProveedorController() {
    }

    public ListaEnlazada<Proveedor> getListaproveedores() {
        return listaproveedores;
    }

    public void setListaproveedores(ListaEnlazada<Proveedor> listaproveedores) {
        this.listaproveedores = listaproveedores;
    }

    public Proveedor getProveedores() {
        if (proveedores == null) {
            proveedores = new Proveedor();
        }
        return proveedores;
    }

    public void setProveedores(Proveedor proveedores) {
        this.proveedores = proveedores;
    }

    @Override
    public boolean Guardar() {
        Connection con = c.getConecction();
        String sql = "INSERT INTO proveedor(id_proveedor,agenteResponsable,provincia, direccion, RUC, razonSocial, Telefonofijo, celular, telefonoOpcional, email, paginaWeb,"
                + "banco,tipocuenta, nroCuenta, credito) VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

            ps.setInt(1, proveedores.getId_Proveedor());
            ps.setString(2, proveedores.getAgenteResponsable());
            ps.setString(3, proveedores.getProvincia());
            ps.setString(4, proveedores.getDireccion());
            ps.setString(5, proveedores.getIdentificacion());
            ps.setString(6, proveedores.getRazonSocial());
            ps.setString(7, proveedores.getTelefono());
            ps.setString(8, proveedores.getCelular());
            ps.setString(9, proveedores.getTelefonoO());
            ps.setString(10, proveedores.getCorreo());
            ps.setString(11, proveedores.getPaginaweb());
            ps.setString(12, proveedores.getBanco());
            ps.setString(13, proveedores.getTipocuenta());
            ps.setString(14, proveedores.getNrocuenta());
            ps.setBoolean(15, proveedores.getCredito());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean Actualizar() {
        PreparedStatement pst = null;
        Connection con = c.getConecction();
        String sql = ("UPDATE proveedores SET agenteresponsable =?, provincia =?, direccion =?, ruc =?, razonSocial =?, "
                + "telefono =?, email=?, paginaWeb=?, banco=?, tipocuenta=?, nroCuenta=?, credito=? WHERE id_proveedor =?");
        try {
            pst.setInt(1, proveedores.getId_Proveedor());
            pst.setString(2, proveedores.getAgenteResponsable());
            pst.setString(3, proveedores.getProvincia());
            pst.setString(4, proveedores.getDireccion());
            pst.setString(5, proveedores.getIdentificacion());
            pst.setString(6, proveedores.getRazonSocial());
            pst.setString(7, proveedores.getTelefono());
            pst.setString(8, proveedores.getCelular());
            pst.setString(9, proveedores.getTelefonoO());
            pst.setString(10, proveedores.getCorreo());
            pst.setString(11, proveedores.getPaginaweb());
            pst.setString(12, proveedores.getBanco());
            pst.setString(13, proveedores.getTipocuenta());
            pst.setString(14, proveedores.getNrocuenta());
            pst.setBoolean(15, proveedores.getCredito());
            pst.executeUpdate();
            pst.close();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean Eliminar() {
        PreparedStatement ps = null;
        Connection con = c.getConecction();
        String sql = ("DELETE FROM proveedores WHERE id_Proveedor = ?");
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, proveedores.getId_Proveedor());
            ps.executeUpdate();
            con.close();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ListaEnlazada<T> listar() {
        st = null;
        rs = null;
        lista = new ListaEnlazada<>();
        try {
            Connection con = c.getConecction();
            st = (Statement) con.createStatement();
            rs = st.executeQuery("SELECT * FROM proveedores");
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_Proveedor(rs.getInt("id_proveedor"));
                proveedor.setAgenteResponsable(rs.getString("agenteResponsable"));
                proveedor.setProvincia(rs.getString("provincia"));
                proveedor.setDireccion(rs.getString("direccion"));
                proveedor.setIdentificacion(rs.getString("RUC"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setTelefono(rs.getString("Telefonofijo"));
                proveedor.setCelular(rs.getString("celular"));
                proveedor.setTelefonoO(rs.getString("telefonoOpcional"));
                proveedor.setCorreo(rs.getString("email"));
                proveedor.setPaginaweb(rs.getString("paginaWeb"));
                proveedor.setBanco(rs.getString("banco"));
                proveedor.setTipocuenta(rs.getString("tipoCuenta"));
                proveedor.setNrocuenta(rs.getString("NroCuenta"));
                proveedor.setPaginaweb(rs.getString("credito"));
                listaproveedores.insertarCabecera(proveedor);
                lista.insertarCabecera((T) proveedor);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return (ListaEnlazada<T>) lista;
    }

//  public Boolean guardar(){
//        try {
//            if (getProveedores().getId_Proveedor()!= null) {
//                guardar(this.getProveedores());
//            }else{
//                guardar(this.getProveedores());
//            }
//            return true;
//        } catch (Exception e) {
//            System.out.println("Error en guardar");
//            return false;
//        }    
//    }
//
//   public Boolean modificar(){
//        try {
//            if (getProveedores().getId_Proveedor()!= null) {
//                modificaree(this.getProveedores());
//            }else{
//                guardar(this.getProveedores());
//            }
//            return true;
//        } catch (Exception e) {
//            System.out.println("Error en guardar o modificar");
//            return false;
//        }    
//    }
}
