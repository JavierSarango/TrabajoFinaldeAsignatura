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
import modelo.Cliente;
import modelo.Proveedor;

/**
 *
 * @author Pc
 */
public class ClienteDao extends AdaptadorDao<Cliente> {

    private Cliente cliente;

    Conexion c = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement s;

    public ClienteDao() {
        super(Cliente.class);
    }

    public Cliente getCliente() {
        if (cliente == null) {
            cliente = new Cliente();
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boolean guardar() {
        try {
            guardar(this.getCliente());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }
    }

    public Boolean delete(Integer pos) {
        try {
            eliminarCliente(pos);
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }
    }

    public void EliminarProsucto(int id_cliente) {
        try {
            s = con.createStatement();
            s.execute("DELETE FROM cliente WHERE identificacion = " + id_cliente);
        } catch (SQLException e) {
        }

    }

    public Boolean modif(Integer pos) {
        try {
            modificaree(this.getCliente());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }
    }
      public ListaEnlazada listarIDProveedor() {
        ListaEnlazada<Proveedor> listProveedor = new ListaEnlazada<>();

        String sql = "Select razonSocial from proveedor";

        try {
            con = Conexion.getConecction();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setRazonSocial(rs.getString("razonSocial"));
                listProveedor.insertar(p);
//                p.setId_Proveedor(rs.getInt(1));
//                p.setAgente_responsable(rs.getString(2));
//                p.setProvincia(rs.getString(3));
//                p.setDireccion(rs.getString(4));
//                p.setCredito(rs.getString(5));
//                p.setPagina_web(rs.getString(6));
//                p.setCelular(rs.getString(7));
//                p.setBanco(rs.getString(8));
//                p.setTipocuenta(rs.getString(9));
//                p.setNro_cuenta(rs.getString(10));
            }
        } catch (Exception e) {
            System.out.println("Error en listar Id producto");
            e.printStackTrace();
        }
        return listProveedor;

    }

    public Cliente listarIDProducto(String indentificacion) {
        Cliente p = new Cliente();
        String sql = "Select * from cliente where identificacion = ?";

        try {
            con = Conexion.getConecction();
            ps = con.prepareStatement(sql);
            ps.setString(1, indentificacion);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId_cliente(rs.getInt(1));
                p.setRazonSocial(rs.getString(2));
                p.setCelular(rs.getString(3));
                p.setTelefono(rs.getString(4));
                p.setCorreo(rs.getString(5));
                p.setDireccion(rs.getString(6));
                p.setTipoIdentificacion(rs.getString(7));
                p.setIdentificacion(rs.getString(8));
                p.setTipoCliente(rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println("Error en listar Id cliente");
            e.printStackTrace();
        }
        return p;

    }
    
    public void modificarArreglado(String razonSocial, String telefono, String celular, String correo, String direccion, String tipoIdentificacion, String identificacion, String tipoCliente,Integer id_Cliente) throws Exception {
        
        
        System.out.println("ingreso a modificar");
        String update = "Update cliente set razonSocial ='" + razonSocial + "',telefono ='" + telefono + "',celular ='" + celular + "',correo ='" + correo + "',direccion='" + direccion + "',tipoIdentificacion ='" + tipoIdentificacion + "',tipoCliente ='"+ tipoCliente  +"' where id_Cliente = '" + id_Cliente + "'";


        try {
            PreparedStatement stmt = getConexion().prepareStatement(update);
            stmt.executeUpdate();
            //OptionPane.showMessageDialog(null, "actualizado correctamente");
        } catch (SQLException ex) {
            System.out.println("Error en guardar " + ex);
        }
       
    }

}
