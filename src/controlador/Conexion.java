/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Javier Sarabia
 */
public class Conexion {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
//    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String IP = "127.0.0.1";
    private static String PORT = "3306";
    private static String USER = "rootUser";
    private static String PASSWORD = "";
    private static String DATABASE = "omicrondb";
    public static Connection conecction;

    public static Connection getConecction() {
        if (conecction == null) {
            conectar();
        }
        return conecction;
    }

    private static Connection conectar() {

        try {
            Class.forName(DRIVER);
            String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
            conecction = (Connection) DriverManager.getConnection(url, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Error en conexion " + e);
        }
        return conecction;
    }

    public static void main(String[] args) {
        Connection cn = Conexion.getConecction();
        try {
            System.out.println(cn.getCatalog());
        } catch (Exception e) {
        }

    }
}
