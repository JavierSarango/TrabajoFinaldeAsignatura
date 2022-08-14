/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;
//utilizamos las librerias Matcher y Pattern para comprobar los correos electronico

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
import controlador.Conexion;
import static controlador.Conexion.conecction;
import controlador.dao.AdaptadorDao;
import controlador.tda.lista.ListaEnlazada;
import controlador.utiles.enums.TipoOrdenacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Producto;

/**
 *
 * @author diego
 */

public class ProductoDao extends AdaptadorDao<Producto> {

    private Producto producto;
    private ListaEnlazada<Producto> lista;
    
    Conexion c = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    

    public Producto getProducto() {
        if (producto == null) {
            producto = new Producto();
        }
        return producto;
    }
    

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ProductoDao() {
        super(Producto.class);

    }
    
    public Boolean guardar_modificar(){
        try {
            if (producto.getIdProducto()!= null) {
                modificaree(this.getProducto());
                
                
            }else{
                guardar(this.getProducto());
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }
    }
      
    public Boolean modificarManualCliente() {
        PreparedStatement pst;
        Connection con = Conexion.getConecction();
        String sql = ("UPDATE producto SET codigo =?, nombre =?, "
                + "descripcion =?, precioCompra =?, precioVenta =?, "
                + "id_Proveedor =?, unidades =? WHERE idProducto =?" );
        try {
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, producto.getCodigo());
            pst.setString(2, producto.getNombre());
            pst.setString(3, producto.getDescripcion());
            pst.setDouble(4, producto.getPrecioCompra());
            pst.setDouble(5, producto.getPrecioVenta());
            pst.setString(6, producto.getProveedor());
            pst.setInt(7, producto.getUnidades());
            pst.setInt(8, producto.getIdProducto());
          
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }
    
    public Producto listarIDProducto(Integer codigo) {
        Producto p = new Producto();
        String sql = "Select * from producto where codigo = ?";

        try {
            con = Conexion.getConecction();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setIdProducto(rs.getInt(1));
                p.setCodigo(rs.getInt(2));
                p.setNombre(rs.getString(3));
                p.setDescripcion(rs.getString(4));
                p.setPrecioCompra(rs.getDouble(5));
                p.setPrecioVenta(rs.getDouble(6));
                p.setProveedor(rs.getString(7));
                p.setUnidades(rs.getInt(8));
            }
        } catch (Exception e) {
            System.out.println("Error en listar Id producto");
            e.printStackTrace();
        }
        return p;

    }
    
    public Boolean exterminar() {
        System.out.println("entra a exterminar");
         
        try {
            eliminar(this.getProducto());
            return true;

        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }
    }
    
    public void modificarequipo(Integer codigo, String nombre, String descripcion, Double precioCompra, Double precioVenta, Integer unidades, String Proveedor, Integer idProducto) throws Exception {
        
        
        System.out.println("ingreso a modificar");
        String update = "Update producto set codigo ='" + codigo + "',nombre ='" + nombre + "',descripcion ='" + descripcion + "',precioCompra ='" + precioCompra + "',precioVenta='" + precioVenta + "',unidades ='" + unidades + "',Proveedor ='"+ Proveedor  +"' where idProducto = '" + idProducto + "'";


        try {
            PreparedStatement stmt = getConexion().prepareStatement(update);
            stmt.executeUpdate();
            //OptionPane.showMessageDialog(null, "actualizado correctamente");
        } catch (SQLException ex) {
            System.out.println("Error en guardar " + ex);
        }
       
    }
    
    public boolean actualizarStock(Integer idProducto, Integer codigo, String nombre, String descripcion, Double precioCompra, Double precioVenta, Integer unidades, String Proveedor) {
//    
        String sql = "UPDATE producto SET codigo = ?, nombre = ?, descripción = ?, precioCompra = ?, precioVenta = ?, unidades = ?, Proveedor = ?, WHERE idProducto = ?";
        try {
            con = Conexion.getConecction();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.setString(3, descripcion);
            ps.setDouble(4, precioCompra);
            ps.setDouble(5, precioVenta);
            ps.setInt(6, unidades);
            ps.setString(7, Proveedor);
            ps.setInt(8, idProducto);
            
//            ps.executeQuery();
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            System.out.println("Error al actualizar stock");
            e.printStackTrace();
        }

       return false;
    }
}
     
    //Este método nos permite buscar cualquier cadena de caracteres que nosotros queremos encontrar 
    //Ya sea nombre, apellido, etc
//    public ListaEnlazada<Producto> buscarString(String dato) {
//        ListaEnlazada<Producto> lista = new ListaEnlazada<>();
//        ListaEnlazada<Producto> aux = listar();
//
//        for (int i = 0; i < aux.tamanio(); i++) {
//            Producto p = aux.consultarDatoPosicion(i);
//            Boolean band = p.getNombre().toLowerCase().contains(dato.toLowerCase());
//            if (band) {
//                lista.insertarCabecera(p);
//            }
//        }
//        return lista;
//    }
//
//    /**
//     * Permite mostrar los objetos visibles
//     */
//    public ListaEnlazada<Producto> soloVisibles() {
//        ListaEnlazada<Producto> lista = new ListaEnlazada<>();
//        ListaEnlazada<Producto> aux = listar();
//
//        for (int i = 0; i < aux.tamanio(); i++) {
//            Producto p = aux.consultarDatoPosicion(i);
//
//            if (p.getVisible()) {
//                lista.insertarCabecera(p);
//            }
//        }
//        return lista;
//    }
////    /**
////     *Genera una nueva lista la cual omite la posición para luego cargar en la tabla
////     */
////    public Producto omitirPosiciones(int fila) {
////
////        ListaEnlazada<Producto> aux = listar();
////        Producto p = new Producto(); 
////
////        for (int i = 0; i <= fila; i++) {
////            
////            if (p.getVisible()==false) {
////               i=i+1;
////            }
////
////            p = aux.consultarDatoPosicion(i); 
////
////        }
////        return p;
////    }
//
//    /**
//     * Permite modificaree un dato en la lista de productos, para luego
//     * guardarla
//     */
//    public Boolean modificar() {
//        ListaEnlazada<Producto> aux = soloVisibles();
//        try {
//            for (int i = 0; i < aux.tamanio(); i++) {
//                if (aux.consultarDatoPosicion(i).getIdProducto().intValue() == producto.getIdProducto().intValue()) {
//                    //producto=asignarIva(detalleFactura.getDetalle().getIva(), producto);
//                    aux.modificarDato(i, producto);
//                    guardarArchivo(aux);
//                    break;
//                }
//            }
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("No se pudo guardar");
//            return false;
//        }
//    }
//
//    /**
//     * Guarda el archivo
//     */
//    private void guardarArchivo(ListaEnlazada<Producto> aux) {
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CARPETA));
//            oos.writeObject(aux);
//            oos.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    /**
//     * Lista la información guardada en la lista
//     */
//    public ListaEnlazada<Producto> listar() {
//        ListaEnlazada<Producto> lista = new ListaEnlazada<>();
//        try {
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CARPETA));
//            lista = (ListaEnlazada<Producto>) ois.readObject();
//            ois.close();
//        } catch (Exception e) {
//            System.out.println("Error al leer el archivo");
//        }
//        this.lista = lista;
//        return lista;
//
//    }
//
//    /**
//     * Genera una lista en memoria que mostrará el dáto del código
//     */
//    public ListaEnlazada<Producto> buscarCodigo(String dato) {
//        ListaEnlazada<Producto> lista = new ListaEnlazada<>();
//        ListaEnlazada<Producto> aux = soloVisibles();
//
//        for (int i = 0; i < aux.tamanio(); i++) {
//            Producto p = aux.consultarDatoPosicion(i);
//            Boolean band = String.valueOf(p.getIdProducto()).contains(dato.toLowerCase());
//            if (band) {
//                lista.insertarCabecera(p);
//            }
//        }
//        return lista;
//    }
//
//    /**
//     * Genera una nueva lista donde ya no se muestran los datos eliminados para
//     * el usuario
//     */
//    public Boolean modificarElim() {
//        ListaEnlazada<Producto> aux = soloVisibles();
//        try {
//            for (int i = 0; i < aux.tamanio(); i++) {
//                if (aux.consultarDatoPosicion(i).getIdProducto().intValue() == producto.getIdProducto().intValue()) {
//
//                    aux.modificarDato(i, producto);
//                    guardarArchivo(aux);
//                    break;
//                }
//            }
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("No se pudo guardar");
//            return false;
//        }
//    }
//
//}