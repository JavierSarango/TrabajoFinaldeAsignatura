/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import com.mysql.cj.xdevapi.Statement;
import controlador.Conexion;
import controlador.tda.lista.ListaEnlazada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Proveedor;

/**
 *
 * @author Pc
 */
public class ClienteContro implements CRUD {

    private Cliente cliente;
    private ListaEnlazada<Cliente> listacliente;
    private Class clazz;
    private Connection conexion;
    Conexion c = new Conexion();
    Statement st;
    ResultSet rs;

    public ClienteContro() {
    }
    
    

    public ClienteContro(Class clazz) {
        this.clazz = clazz;
        this.conexion = Conexion.getConecction();

    }

//    public ClienteContro() {
//        super(Cliente.class);
//        listar();
//    }
    public Cliente getCliente() {
        if (this.cliente == null) {
            this.cliente = new Cliente();
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ListaEnlazada<Cliente> getListaCliente() {
        return listacliente;
    }

    public void setListaCliente(ListaEnlazada<Cliente> listaCliente) {
        this.listacliente = listaCliente;
    }

    @Override
    public boolean Guardar() {
        conexion = c.getConecction();
        String sql = "INSERT INTO cliente(id_cliente,razonSocial,telefono, celular, correo, direccion, tipoIdentificacion, tipoCliente, "
                + "fechaNacimiento, identificaion) VALUE(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) conexion.prepareStatement(sql);

            ps.setInt(1, cliente.getId_cliente());
            ps.setString(2, cliente.getRazonSocial());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getCelular());
            ps.setString(5, cliente.getCorreo());
            ps.setString(6, cliente.getDireccion());
            ps.setString(7, cliente.getTipoIdentificacion());
            ps.setString(8, cliente.getTipoCliente());
            ps.setString(8, cliente.getFechaNacimiento());
            ps.setString(9, cliente.getTipoCliente());
            ps.setString(10, cliente.getIdentificacion());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean Actualizar() {
        PreparedStatement pst = null;
        conexion = c.getConecction();
        String sql = ("UPDATE proveedores SET agenteresponsable =?, provincia =?, direccion =?, ruc =?, razonSocial =?, "
                + "telefono =?, correo=?, paginaweb=?, credito=?, banco=?, tipocuenta=?, nroCuenta=? WHERE id_proveedor =?");
        try {
            pst.setInt(1, cliente.getId_cliente());
            pst.setString(2, cliente.getRazonSocial());
            pst.setString(3, cliente.getProvincia());
            pst.setString(4, cliente.getDireccion());
            pst.setString(5, cliente.getTipoIdentificacion());
            pst.setString(6, cliente.getIdentificacion());
            pst.setString(7, cliente.getTelefono());
            pst.setString(8, cliente.getCelular());
            pst.setString(8, cliente.getCorreo());
            pst.setString(9, cliente.getTipoCliente());
            pst.setString(10, cliente.getFechaNacimiento());
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
            ps.setInt(1, cliente.getId_cliente());
            ps.executeUpdate();
            con.close();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ListaEnlazada<Cliente> listar() {
        st = null;
        rs = null;
        listacliente = new ListaEnlazada<>();
        ListaEnlazada lista = new ListaEnlazada();
        try {
            Connection con = c.getConecction();
            st = (Statement) con.createStatement();
            //  rs = st.execute("SELECT * FROM proveedores");
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_Proveedor(rs.getInt("id_Proveedor"));
                proveedor.setAgenteResponsable(rs.getString("Agenteresponsable"));
                proveedor.setProvincia(rs.getString("Provincia"));
                proveedor.setDireccion(rs.getString("cant_Suministrada"));
                proveedor.setIdentificacion(rs.getString("RUC"));
                proveedor.setRazonSocial(rs.getString("Razonsocial"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setCorreo(rs.getString("correo"));
                proveedor.setPaginaweb(rs.getString("paginaweb"));
                proveedor.setPaginaweb(rs.getString("credito"));
                proveedor.setBanco(rs.getString("banco"));
                proveedor.setTipocuenta(rs.getString("tipocuenta"));
                proveedor.setNrocuenta(rs.getString("nroCuenta"));
                listacliente.insertarCabecera(cliente);
                lista.insertarCabecera(cliente);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return (ListaEnlazada<Cliente>) lista;
    }
}
