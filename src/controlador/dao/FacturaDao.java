/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.DetalleFactura;
import modelo.Factura;

/**
 *
 * @author John
 */
public class FacturaDao {

    /**
     * variable tipo factura para almacenamiento de la informacion de la factura
     * obtenida de la base de datos
     */
    private Factura factura;
    /**
     * variable para realizacion de conexion con la base de datos
     */
    Connection con;
    /**
     * variable para realizacion preparacion de transmision de datos entre la
     * base y el programa
     */
    PreparedStatement ps;
    /**
     * variable para control de accione en la base de datos
     */
    ResultSet rs;
    /**
     * variable de control de operaciones
     */
    Integer respuesta = 0;

    /**
     * metodo para obtener la factura almacenada en la variables factura
     *
     * @return factura
     */
    public Factura getFactura() {
        if (this.factura == null) {
            this.factura = new Factura();
        }
        return factura;
    }

    /**
     * metodo para setear datos en la variable factura
     *
     * @param factura
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    /**
     * Metodo para guardar en base de datos un objetos Factura
     *
     * @param dato
     * @throws Exception
     */
    public Integer GuardarFactura(Factura factura) {
        String sql = "INSERT INTO venta (id_Cliente,nroSerie,fechaVenta,monto) VALUES (?,?,?,?)";
        try {
            con = Conexion.getConecction();
            ps = con.prepareStatement(sql);
            ps.setString(1, factura.getNombreEmpresa());
            ps.setString(2, factura.getRUC());
            ps.setString(3, factura.getCodigoFactura());
            ps.setString(4, factura.getCodigoAutorizacion());
            ps.setString(5, factura.getDireccionEmpresa());
            ps.setString(6, factura.getTelefonoE());
            ps.setString(7, factura.getEmailE());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return respuesta;
    }

    /**
     * Metodo para guardar en base de datos un objetos DetalleFactura
     *
     * @param dato
     * @throws Exception
     */
    public Integer GuardarDetalleFactura(DetalleFactura detalleFactura) {
        String sql = "INSERT INTO detalle_ventas (idVentas,idProducto,cantidad,precioVenta) VALUES (?,?,?,?)";
        try {
            con = Conexion.getConecction();
            ps = con.prepareStatement(sql);
            ps.setInt(1, detalleFactura.getId_factura());
            ps.setInt(2, detalleFactura.getId_cliente());
            ps.setDate(3, (Date) detalleFactura.getFechaEmision());
            ps.setInt(4, detalleFactura.getId_ventas());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en detalle venta No se pudo guardar");
            e.printStackTrace();
        }
        return respuesta;
    }

}
