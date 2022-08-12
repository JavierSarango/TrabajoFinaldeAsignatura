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
    
    public boolean modificar() {
        try {         
                modificaree(this.getProveedores());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }
         
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
    
    

    public ListaEnlazada<Proveedor> buscar(String dato, int tipo) {
        ListaEnlazada<Proveedor> listado = new ListaEnlazada<>();
        try {
            ListaEnlazada<Proveedor> lista = listar();
            for (int i = 0; i < lista.tamanio(); i++) {
                
                Proveedor aux = lista.obtenerDato(i);
                switch (tipo) {
                    case 0:
                        System.out.println("Llega con dato 0 " + dato);
                        if (aux.getAgente_responsable().toString().contains(dato.toUpperCase())) {//busqueda atomica
                            listado.insertarCabecera(aux);
                        }
                        break;
                    case 1:
                        System.out.println("Llega con dato 1 " + dato);
                        if (aux.getIdentificacion().toUpperCase().contains(dato.toUpperCase())) {//busqueda atomica
                            listado.insertarCabecera(aux);
                        }
                        break;

                }
//                if (nro_inv.equalsIgnoreCase(aux.getNro_inv())) {//busqueda atomica
//                    libro = aux;
//                    break;
//                }
            }
        } catch (Exception e) {
        }
        
        return listado;
    }
    
    public boolean actualizar() {
        PreparedStatement pst = null;
        Connection con = c.getConecction();
        String sql = ("UPDATE proveedor SET agente_responsable =?, provincia =?, direccion =?, identificacion =?, razonSocial =?, "
                + "telefono =?, celular =?,telefono_opcional =?, correo=?, pagina_web=?, banco=?, tipocuenta=?, nro_cuenta=?, credito=? WHERE id_Proveedor =?");
        try {
            pst.setInt(1, proveedor.getId_Proveedor());
            pst.setString(2, proveedor.getAgente_responsable());
            pst.setString(3, proveedor.getProvincia());
            pst.setString(4, proveedor.getDireccion());
            pst.setString(5, proveedor.getIdentificacion());
            pst.setString(6, proveedor.getRazonSocial());
            pst.setString(7, proveedor.getTelefono());
            pst.setString(8, proveedor.getCelular());
            pst.setString(9, proveedor.getTelefono());
            pst.setString(10, proveedor.getCorreo());
            pst.setString(11, proveedor.getPagina_web());
            pst.setString(12, proveedor.getBanco());
            pst.setString(13, proveedor.getTipocuenta());
            pst.setString(14, proveedor.getNro_cuenta());
            pst.setString(15, proveedor.getCredito());
            pst.executeUpdate();
            pst.close();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }


}
