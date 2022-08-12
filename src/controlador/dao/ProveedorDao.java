/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.Conexion;
import controlador.tda.lista.ListaEnlazada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Proveedor;

/**
 *
 * @author Gigabyte
 */
public class ProveedorDao extends AdaptadorDao<Proveedor> {

    private Proveedor proveedor;
    private ListaEnlazada<Proveedor> listaproveedores;

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
}

//    public boolean Delete() {
//        PreparedStatement ps = null;
//        Connection con = c.getConecction();
//        String sql = ("DELETE FROM proveedor WHERE id_proveedor = ?");
//        try {
//            ps = (PreparedStatement) con.prepareStatement(sql);
//            ps.setInt(1, proveedor.getId_Proveedor());
//            ps.executeUpdate();
//            con.close();
//            return true;
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Ocurrido el siguiente erro: " + e.getMessage());
//            return false;
//        }
//    }
//}
