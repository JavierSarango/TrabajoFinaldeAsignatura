/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.Conexion;
import controlador.dao.AdaptadorDao;
import controlador.tda.lista.ListaEnlazada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.equipo;
import modelo.Proveedor;

/**
 *
 * @author Javier Sarabia
 */
public class EquipoElectronicoDao extends AdaptadorDao<equipo> {

    private equipo equipoElectronico;
    private ListaEnlazada<Proveedor> listaequipos;

    public equipo getEquipoElectronico() {
        if (equipoElectronico == null) {
            equipoElectronico = new equipo();
        }
        return equipoElectronico;
    }

    public void setEquipoElectronico(equipo equipoElectronico) {
        this.equipoElectronico = equipoElectronico;
    }

    public EquipoElectronicoDao() {
        super(equipo.class);

    }

    public Boolean guardar_modificar() {
        try {
            if (equipoElectronico.getId_equipo() != null) {
                modificaree(this.getEquipoElectronico());

            } else {
                guardar(this.getEquipoElectronico());
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }
    }

    public Boolean guardar() {
        try {
            guardar(this.getEquipoElectronico());

            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }
    }

    public Boolean modificarManualCliente() {
        PreparedStatement pst;
        Connection con = Conexion.getConecction();
        String sql = ("UPDATE equipo SET razon_social =?, "
                + "tipo_equipo =?, marca =?, modelo =?, "
                + "cargador =?, estado_ingreso =?, descripcion_problema =?,precio_servicio =? WHERE id_equipo =?");
        try {
            pst = (PreparedStatement) con.prepareStatement(sql);
//            pst.setInt(1, equipoElectronico.getId_equipo());
            pst.setString(2, equipoElectronico.getRazon_social());
            pst.setString(3, equipoElectronico.getTipo_equipo().toString());
            pst.setString(4, equipoElectronico.getMarca());
            pst.setString(5, equipoElectronico.getModelo());
            pst.setBoolean(6, equipoElectronico.getCargador());
            pst.setString(7, equipoElectronico.getEstado_ingreso());
            pst.setString(8, equipoElectronico.getDescripcion_problema());
            pst.setDouble(9, equipoElectronico.getPrecio_servicio());
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }

}
