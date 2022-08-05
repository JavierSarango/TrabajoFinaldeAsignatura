/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.Conexion;
import controlador.tda.lista.ListaEnlazada;
import controlador.utiles.Utilidades;
import static controlador.utiles.Utilidades.getMethod;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Nathaly
 * @param <T>
 */
public class AdaptadorDao<T> implements InterfazDao<T> {

    private Connection conexion; 
    private Class clazz;
    private String ALL = "select * from ";
    private String ALL_ID = "select * from ";
    private String carpeta = "datos" + File.separatorChar;

    public AdaptadorDao(Class clazz) {
        this.clazz = clazz;
        this.conexion = Conexion.getConecction();
        ALL += clazz.getSimpleName().toLowerCase();
        ALL_ID += clazz.getSimpleName().toLowerCase() + " where id = ";
    }

    public Connection getConexion() {
        return conexion;
    }

    public Class getClazz() {
        return clazz; 
    }

    @Override 
    public void guardar(T dato) throws Exception { 
        String[] columnas = columnas();
        String comando = "insert into " + clazz.getSimpleName().toLowerCase() + " ";
        String variables = "";
        String datos = "";
        for (int i = 0; i < columnas.length; i++) {
            if (i == columnas.length - 1) {
                variables += columnas[i];//id, nombres, external_id, ...
                datos += tipoDato(columnas[i], dato);//0, "casa", "343-545
            } else {
                variables += columnas[i] + " , ";
                datos += tipoDato(columnas[i], dato) + " , ";
            }
        }
        comando += "(" + variables + ") value(" + datos + ")";
        try {
            PreparedStatement stmt = getConexion().prepareStatement(comando);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en guardar " + e);
        }

        System.out.println(comando);
    }

    @Override
    public void modificaree(T dato) throws Exception {
        //objeto a modificaree ya lo envian desde el metodo
        //reemplazar por valores nuevos
        //enviar el comando
        String[] columnas = columnas();
        String comando = "update  " + clazz.getSimpleName().toLowerCase() + " SET ";
        //String variables = "";
        Object id = null;
        String datos = "";
        for (int i = 0; i < columnas.length; i++) {
            if (!columnas[i].equalsIgnoreCase("id")) {
                if (i == columnas.length - 1) {
                    //variables += columnas[i];//id, nombres, external_id, ...
                    datos += columnas[i] + "=" + tipoDato(columnas[i], dato);//0, "casa", "343-545
                } else {
                    //variables += columnas[i] + " , ";
                    datos += columnas[i] + "=" + tipoDato(columnas[i], dato) + " , ";//0, "casa", "343-545
                }
            } else {
                id = tipoDato(columnas[i], dato);
            }

        }
        comando += datos + " where id = " + id.toString();
        try {
            PreparedStatement stmt = getConexion().prepareStatement(comando);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en guardar " + e);
        }

        System.out.println(comando);

    }

    public boolean modificaree(T dato, int pos) {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(carpeta));
            ListaEnlazada aux = listar();
            aux.modificarDato(pos, dato);
            oos.writeObject(aux);
            oos.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar");
        }
        return false;
    }

    @Override
    public void eliminar(T dato) {

    }

    @Override
    public ListaEnlazada<T> listar() {
        ListaEnlazada<T> lista = new ListaEnlazada<>();
        try {

            PreparedStatement stmt = getConexion().prepareStatement(ALL);
            ResultSet resultSet = stmt.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            String[] columna = new String[resultSetMetaData.getColumnCount()];
            for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                columna[i] = resultSetMetaData.getColumnLabel(i + 1);
            }

            while (resultSet.next()) {
                T obj = (T) clazz.getConstructor().newInstance();
                for (int i = 0; i < columna.length; i++) {
                    Object objeto = resultSet.getObject(i + 1);
                    System.out.println("** " + objeto + columna[i]);
                    if (objeto != null && objeto.getClass().getName().equals("java.sql.Timestamp")) {
                        java.sql.Timestamp aux = (java.sql.Timestamp) objeto;
                        java.util.Date fecha = new Date(aux.getTime());
                        Utilidades.cambiarDatos(fecha, columna[i], obj);
                    } else {
                        Utilidades.cambiarDatos(objeto, columna[i], obj);
                    }

                }
                lista.insertarCabecera(obj);
            }

        } catch (Exception e) {
            System.out.println("Error al cargar " + e);
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public T obtener(Integer id) throws Exception {
        T obj = null;
        String[] columna = columnas();
        PreparedStatement stmt = getConexion().prepareStatement(ALL_ID + id.toString());
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            obj = (T) clazz.getConstructor().newInstance();
            for (int i = 0; i < columna.length; i++) {
                Object objeto = resultSet.getObject(i + 1);
                System.out.println("** " + objeto + columna[i]);
                if (objeto != null && objeto.getClass().getName().equals("java.sql.Timestamp")) {
                    java.sql.Timestamp aux = (java.sql.Timestamp) objeto;
                    java.util.Date fecha = new Date(aux.getTime());
                    Utilidades.cambiarDatos(fecha, columna[i], obj);
                } else {
                    Utilidades.cambiarDatos(objeto, columna[i], obj);
                }
            }
        }
        return obj;
    }

    private String[] columnas() {
        String[] columna = null;
        try {
            String seleccion = ALL;
            PreparedStatement stmt = getConexion().prepareStatement(seleccion);
            ResultSet resultSet = stmt.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            columna = new String[resultSetMetaData.getColumnCount()];
            for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                columna[i] = resultSetMetaData.getColumnLabel(i + 1);
            }
        } catch (Exception ex) {

        }
        return columna;
    }

    private Object tipoDato(String name, T objeto) {
        String aux = ""; 
        try {
            Field field = Utilidades.getField(name, clazz);
            char[] arr = name.toCharArray();
            arr[0] = Character.toUpperCase(arr[0]);
            Method method = getMethod("get" + new String(arr), clazz);
            Object dato = method.invoke(objeto);

            if (field.getType().getSimpleName().equals("Date")) {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                aux = (dato != null) ? "\"" + formato.format((Date) dato) + "\"" : "null";
            } else if (field.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
                aux = (dato != null) ? dato.toString() : "0";
            } else if (field.getType().getSimpleName().equals("Boolean")) {
                aux = (dato != null) ? dato.toString() : Boolean.FALSE.toString();
            } else {
                aux = (dato != null) ? "\"" + dato + "\"" : "null";
            }
        } catch (Exception e) {
            System.out.println("xxxx " + e);

        }

        return aux;

    }

}
