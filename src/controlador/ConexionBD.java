/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author JavierSarango
 */
public class ConexionBD {
     public static String base = "omicrondb";
    public static String user = "rootUser";
    public static String password = "";
    public static String url = "jdbc:mysql://localhost:3306/" + base;
    public static String driver = "com.mysql.jdbc.Driver";
    
    
    public Connection conectar(){
        Connection conexion = null;
       try {
            Class.forName(driver);
            conexion = (Connection) DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error conectar: "+e);
        }
        return conexion;
    }
}
