/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.dao.AdaptadorDao;
import controlador.tda.lista.ListaEnlazada;
import modelo.equipo;
import modelo.Proveedor;

/**
 *
 * @author Javier Sarabia
 */
public class EquipoElectronicoDao extends AdaptadorDao<equipo> {

    private equipo equipoElectronico;
    private ListaEnlazada<Proveedor> listaequipos;
    

    public equipo getEquipoElectronico() {
        if (equipoElectronico == null) {
            equipoElectronico = new equipo();
        }
        return equipoElectronico;
    }

    public void setEquipoElectronico(equipo equipoElectronico) {
        this.equipoElectronico = equipoElectronico;
    }

    public EquipoElectronicoDao() {
        super(equipo.class);

    }

     public Boolean guardar_modificar(){
        try {
            if (equipoElectronico.getId_equipo()!= null) {
                modificaree(this.getEquipoElectronico());
                
                
            }else{
                guardar(this.getEquipoElectronico());
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }
    }
    public Boolean guardar() {
        try {         
                guardar(this.getEquipoElectronico());
            
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar o modificar");
            return false;
        }
    }


}
