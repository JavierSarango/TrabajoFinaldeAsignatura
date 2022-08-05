/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;
//utilizamos las librerias Matcher y Pattern para comprobar los correos electronico
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream; 
import controlador.dao.AdaptadorDao;
import controlador.tda.lista.ListaEnlazada;
import controlador.utiles.enums.TipoOrdenacion;


import modelo.Producto;

/**
 *
 * @author diego
 */
public class ProductoDao extends AdaptadorDao<Producto> {
     
    private Producto producto;
    private ListaEnlazada lista;
    private final String CARPETA = "datos" + File.separatorChar + Producto.class.getSimpleName() + ".obj";
    private int contador=0;
    
    
    public ProductoDao() {
        super(Producto.class);

    }

    public String getCARPETA() {
        return CARPETA;
    }
    public ListaEnlazada getLista(){
        return lista;
    }

    public Producto getProducto() {
        if (producto == null) {
            producto = new Producto();
        }

        return producto;
    }

    public void setProducto(Producto producto) {

        this.producto = producto;
    }
    /**
     *Este método permite guardar en la base local como .obj
     */
    public boolean guardarProducto() {
        ListaEnlazada<Producto> aux = listar();
        try {
            this.getProducto().setId(Long.parseLong(String.valueOf(listar().tamanio() + 1)));
            aux.insertarCabecera(producto);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CARPETA));
            oos.writeObject(aux);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo guardar");
            return false;
        }
    }
    

    
    //Este método nos permite buscar cualquier cadena de caracteres que nosotros queremos encontrar 
    //Ya sea nombre, apellido, etc

    public ListaEnlazada<Producto> buscarString(String dato) {
        ListaEnlazada<Producto> lista = new ListaEnlazada<>();
        ListaEnlazada<Producto> aux = listar();

        for (int i = 0; i < aux.tamanio(); i++) {
            Producto p = aux.consultarDatoPosicion(i);
            Boolean band = p.getNombre().toLowerCase().contains(dato.toLowerCase());
            if (band) {
                lista.insertarCabecera(p);
            }
        }
        return lista;
    }
    
    /**
     *Permite mostrar los objetos visibles
     */
    public ListaEnlazada<Producto> soloVisibles() {
        ListaEnlazada<Producto> lista = new ListaEnlazada<>();
        ListaEnlazada<Producto> aux = listar();

        for (int i = 0; i < aux.tamanio(); i++) {
            Producto p = aux.consultarDatoPosicion(i);
            
            if (p.getVisible()) {
                lista.insertarCabecera(p);
            }
        }
        return lista;
    }
    /**
     *Genera una nueva lista la cual omite la posición para luego cargar en la tabla
     */
    public Producto omitirPosiciones(int fila) {

        ListaEnlazada<Producto> aux = listar();
        Producto p = new Producto(); 

        for (int i = 0; i <= fila; i++) {
            
            if (p.getVisible()==false) {
               i=i+1;
            }

            p = aux.consultarDatoPosicion(i); 

        }
        return p;
    }
    

   /**
     *Permite modificaree un dato en la lista de productos, para luego guardarla
     */
        public Boolean modificar(){
        ListaEnlazada<Producto> aux = soloVisibles();
        try {
            for (int i = 0; i < aux.tamanio(); i++) {
                if (aux.consultarDatoPosicion(i).getId().intValue() == producto.getId().intValue()) {
                    //producto=asignarIva(detalleFactura.getDetalle().getIva(), producto);
                    aux.modificarDato(i,producto);
                    guardarArchivo(aux);
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo guardar");
            return false;
        }
    }
        /**
     *Guarda el archivo
     */
    private void guardarArchivo(ListaEnlazada<Producto> aux){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CARPETA));
            oos.writeObject(aux);
            oos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**
     *Lista la información guardada en la lista
     */
    public ListaEnlazada<Producto> listar() {
        ListaEnlazada<Producto> lista = new ListaEnlazada<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CARPETA));
            lista = (ListaEnlazada<Producto>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
        }
        this.lista = lista;
        return lista;

    }
    /**
     *Genera una lista en memoria que mostrará el dáto del código
     */
    public ListaEnlazada<Producto> buscarCodigo(String dato) {
        ListaEnlazada<Producto> lista = new ListaEnlazada<>();
        ListaEnlazada<Producto> aux = soloVisibles();

        for (int i = 0; i < aux.tamanio(); i++) {
            Producto p = aux.consultarDatoPosicion(i);
            Boolean band = String.valueOf(p.getId()).contains(dato.toLowerCase());
            if (band) {
                lista.insertarCabecera(p);
            }
        }
        return lista;
    }
     
    /**
     *Genera una nueva lista donde ya no se muestran los datos eliminados para el usuario
     */
    public Boolean modificarElim(){
        ListaEnlazada<Producto> aux = soloVisibles();
        try {
            for (int i = 0; i < aux.tamanio(); i++) {
                if (aux.consultarDatoPosicion(i).getId().intValue() == producto.getId().intValue()) {
                    
                    aux.modificarDato(i, producto);
                    guardarArchivo(aux);
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo guardar");
            return false;
        }
    }
    

}
