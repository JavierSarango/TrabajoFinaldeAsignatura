/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.Conexion;
import controlador.dao.AdaptadorDao;
import controlador.tda.lista.ListaEnlazada;
import controlador.utiles.enums.TipoEquipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Cliente;
import modelo.equipo;
import modelo.Proveedor;

/**
 *
 * @author Javier Sarabia
 */
public class EquipoElectronicoDao extends AdaptadorDao<equipo> {

    private equipo equipoElectronico;
    private ListaEnlazada<Proveedor> listaequipos;
    private Cliente cliente;

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
            pst.setString(6, equipoElectronico.getCargador());
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
    
    public boolean modificar(equipo dato, int id) {
        PreparedStatement pst;
        Connection con = Conexion.getConecction();
        String tabla = dato.getClass().getSimpleName().toLowerCase();

        try {

//            pst = conexion.prepareStatement("UPDATE equipo SET razon_social = '"+dato.getRazon_social()+"', tipo_equipo = '"+dato.getTipo_equipo()+"',marca = '"+dato.getMarca()+ "' WHERE ID='"+ID+"'");
            String sql = ("UPDATE "+tabla+" SET razon_social = '" + dato.getRazon_social() + "', tipo_equipo = '" + dato.getTipo_equipo().toString() + "', marca = '" + dato.getMarca() + "', modelo='" + dato.getModelo()
                    + "', cargador = '" + dato.getCargador() + "', estado_ingreso='" + dato.getEstado_ingreso() + "', descripcion_problema='" + dato.getDescripcion_problema() + "',precio_servicio=' " + dato.getPrecio_servicio() + "' WHERE id_equipo = '" + id + "'");
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error en el modificado de la base " + e);
            e.printStackTrace();
            return false;
        }
    }

    public Boolean modificarManualCliente(equipo aux) {
        PreparedStatement pst;
        Connection con = Conexion.getConecction();
        String sql = ("UPDATE equipo SET razon_social =?, tipo_equipo =?, "
                + " marca =?, modelo =?, "
                + " estado_ingreso =?, descripcion_problema =?,precio_servicio =? WHERE id_equipo =?");
        try {
            pst = (PreparedStatement) con.prepareStatement(sql);

            pst.setString(1, aux.getRazon_social());
            System.out.println(aux.getRazon_social());
            pst.setString(2, aux.getTipo_equipo().toString());
            System.out.println(aux.getRazon_social());
            pst.setString(3, aux.getMarca());
            pst.setString(4, aux.getModelo());
            pst.setString(5, aux.getEstado_ingreso());
            pst.setString(6, aux.getDescripcion_problema());
            pst.setDouble(7, aux.getPrecio_servicio());
            System.out.println(aux.getPrecio_servicio());
            pst.setInt(8, aux.getId_equipo());
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
            return false;
        }

    }
    public void modificarequipo(String razonSocial, TipoEquipo tipoequipo, String marca,String modelo,String cargador, String estadoing, String descripcion, Double precio,Integer id) throws Exception {
        
        
        System.out.println(razonSocial + tipoequipo + marca + modelo + cargador + estadoing + descripcion+ precio);
        String update = "Update equipo set razon_social ='" + razonSocial + "',tipo_equipo ='" + tipoequipo + "',marca ='" + marca + "', modelo ='" + modelo + "',cargador='" + cargador + "',estado_ingreso ='" + estadoing + "',descripcion_problema ='"+descripcion+ "',precio_servicio ='" +precio+"' where id_equipo = '" + id + "'";


        try {
            PreparedStatement stmt = getConexion().prepareStatement(update);
            stmt.executeUpdate();
            //OptionPane.showMessageDialog(null, "actualizado correctamente");
        } catch (SQLException ex) {
            System.out.println("Error en guardar " + ex);
        }
       
    }
    public Cliente consultaCliente(String cedula) {
        ClienteDao clienteDao = new ClienteDao();
        cliente = clienteDao.listarIDProducto(cedula);
        return cliente;
    }


}
