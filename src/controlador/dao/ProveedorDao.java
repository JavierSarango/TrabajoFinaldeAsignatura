/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.Conexion;
import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.ListaEnlazadaServices;
import controlador.tda.lista.exception.PosicionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Producto;
import modelo.Proveedor;

/**
 *
 * @author Gigabyte
 */
public class ProveedorDao extends AdaptadorDao<Proveedor> {

    private Proveedor proveedor;
    private ListaEnlazadaServices<Proveedor> listaproveedores;
    private static Connection Conection;
    private static Statement Consulta;
    private static ResultSet Resultado;

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

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
            System.out.println("Error en guardar");
            return false;
        }
    }

    public boolean modificar() {
        try {
            modificaree(this.getProveedores());
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar");
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

    public ListaEnlazada<Proveedor> ordenar() {
        try {
            ListaEnlazada<Proveedor> lista = listar();
            int intercambio = 0;
            for (int i = 0; i < lista.tamanio() - 1; i++) {
                int k = i;
                Proveedor t = lista.obtenerDato(i);//datos[i];            
                for (int j = i + 1; j < lista.tamanio(); j++) {
                    if (lista.obtenerDato(j).getAgente_responsable().toLowerCase().compareTo(t.getAgente_responsable().toLowerCase()) < 0) {
                        t = lista.obtenerDato(j);
                        k = j;
                        intercambio++;
                    }
                }
                lista.modificarDato(k, lista.obtenerDato(i));
                lista.modificarDato(i, t);
                //datos[k] = datos[i];
                //datos[i] = t;
            }
            return lista;
        } catch (Exception e) {
            return new ListaEnlazada<>();
        }
    }



    public ListaEnlazada<Proveedor> busquedasecuencial(String dato, Integer tipo) throws PosicionException {
        ListaEnlazada<Proveedor> lista = new ListaEnlazada<>();
        ListaEnlazada<Proveedor> aux = listar();
        for (int i = 0; i < aux.getSize(); i++) {
            Proveedor p = aux.obtenerDato(i);
            boolean encontrado;
            Boolean bands = (tipo == 1) ? p.getAgente_responsable().toLowerCase().contains(dato.toLowerCase())
                    : p.getAgente_responsable().toLowerCase().contains(dato.toLowerCase());
            encontrado = true;
            if (bands) {
                lista.insertarCabecera(p);
            }
            Boolean band = (tipo == 2) ? p.getProvincia().toLowerCase().contains(dato.toLowerCase())
                    : p.getProvincia().toLowerCase().contains(dato.toLowerCase());
            encontrado = true;
            if (band) {
                lista.insertarCabecera(p);
            }
            Boolean band1 = (tipo == 3) ? p.getIdentificacion().toLowerCase().contains(dato.toLowerCase())
                    : p.getIdentificacion().toLowerCase().contains(dato.toLowerCase());
            encontrado = true;
            if (band1) {
                lista.insertarCabecera(p);
            }
            Boolean band2 = (tipo == 4) ? p.getRazonSocial().toLowerCase().contains(dato.toLowerCase())
                    : p.getRazonSocial().toLowerCase().contains(dato.toLowerCase());
            encontrado = true;
            if (band1) {
                lista.insertarCabecera(p);
            }
        }
        return lista;
    }

    public void actualizar(String agente_responsable, String provincia, String direccion, String identificacion, String razonSocial, String telefono,
            String celular, String telefono_opcional, String correo, String pagina_web, String banco, String tipocuenta, String nro_cuenta, String credito, String id) throws SQLException {
        PreparedStatement pst = null;
        Connection con = c.getConecction();
        String sql = ("UPDATE proveedor SET agente_responsable =?" + agente_responsable + "provincia =?" + provincia+ "direccion =?"+ direccion + "identificacion =?" + identificacion + "razonSocial =?" + razonSocial+
                "telefono =?" + telefono+ "celular =?"+ celular +"telefono_opcional =?" + telefono_opcional+ "correo=?" + correo +"pagina_web=?" + pagina_web+" banco=?"+ 
                "tipocuenta=?" + tipocuenta+ "nro_cuenta=?" + nro_cuenta+ "credito=?" + credito + "WHERE id_Proveedor =?" + id);
        try {
            PreparedStatement stmt = getConexion().prepareStatement(sql);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "actualizado correctamente");
        } catch (SQLException ex) {
            System.out.println("Error en guardar " + ex);
        }
        commit();
    }

}
