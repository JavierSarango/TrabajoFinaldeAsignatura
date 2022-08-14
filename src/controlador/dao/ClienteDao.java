/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Cliente;

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
            s =  con.createStatement();
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
                p.setTipoIdentificacion(rs.getString(6));
                p.setIdentificacion(rs.getString(7));
                p.setFechaNacimiento(rs.getString(8));
                p.setTipoCliente(rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println("Error en listar Id cliente");
            e.printStackTrace();
        }
        return p;

    }

}
