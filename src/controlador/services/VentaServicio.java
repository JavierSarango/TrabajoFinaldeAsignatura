/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.services;

import controlador.dao.VentaDao;
import controlador.tda.lista.ListaEnlazada;
import modelo.Venta;

/**
 *
 * @author JavierSarango
 */
public class VentaServicio {
    private VentaDao venta = new VentaDao();
    public ListaEnlazada<Venta> listar(){
        return venta.listar();
    }
    public Boolean guardar(){
    return venta.guardar();
    }
    public Venta obtener_id(Integer id){
        try {
            return venta.obtener(id);
        } catch (Exception e) {
            System.out.println("Error al obtener id");
            return null;
        }
        
    }
}
