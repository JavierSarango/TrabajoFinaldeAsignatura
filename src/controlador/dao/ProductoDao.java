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
}
    
//    public static void main(String[] args){
//        ProductoDao productoDao = new ProductoDao();
//        ListaEnlazada<Producto> lista = productoDao.listar();
////        productoDao.getProducto().setCodigo(123);
////        productoDao.getProducto().setNombre("teclado");
////        productoDao.getProducto().setEstado(true);
////        productoDao.getProducto().setDescripcion("genius negro mecanico");
//        
//        try {
//            productoDao.setProducto(productoDao.obtener(1));
//            System.out.println(productoDao.getProducto().getIdProducto());
//            for (int i = 0; i < lista.getSize(); i++) {
//                System.out.println(lista.obtenerDato(i).getCodigo() + lista.obtenerDato(i).getNombre());
//            }
//        } catch (Exception e) {
//            System.out.println("Error" +e);
//        }
//        
//    }


//      public ListaEnlazada getLista() {
//        return lista;
//    }

    /**
     * Este método permite guardar en la base local como .obj
     */

//    public boolean guardarProducto() {
//        ListaEnlazada<Producto> aux = listar();
//        try {
//            this.getProducto().setIdProducto(Integer.parseInt(String.valueOf(listar().tamanio() + 1)));
//            aux.insertarCabecera(producto);
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CARPETA));
//            oos.writeObject(aux);
//            oos.close();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("No se pudo guardar");
//            return false;
//        }
//    }

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