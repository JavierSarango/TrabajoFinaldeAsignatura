/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.DAO.AdaptadorDao;
import modelo.EquipoElectronico;
import modelo.SoporteCliente;

/**
 *
 * @author Javier Sarabia
 */
public class ClienteSoporteDao extends AdaptadorDao<SoporteCliente>{
    private SoporteCliente soporteCliente;

    public SoporteCliente getSoporteCliente() {
        
        if(soporteCliente == null)
            soporteCliente = new SoporteCliente();
        return soporteCliente;
    }

    public void setSoporteCliente(SoporteCliente soporteCliente) {
        this.soporteCliente = soporteCliente;
    }

    public ClienteSoporteDao() {
        super(SoporteCliente.class);
    }
    
    
     public Boolean guardar_modificar() {
       try {
           if(getSoporteCliente().getId_persona()!= null) {
               //
               modificar(this.getSoporteCliente());
           } else {
               guardar(this.getSoporteCliente());
           }
           return true;
       } catch (Exception e) {
           System.out.println("Error en guadar o modificar");
           return false;
       }
   }
    
    
}
