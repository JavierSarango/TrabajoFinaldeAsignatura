/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.dao.AdaptadorDao;
import controlador.tda.lista.ListaEnlazada;
import modelo.EquipoElectronico;

/**
 *
 * @author Javier Sarabia
 */
public class EquipoElectronicoDao extends AdaptadorDao<EquipoElectronico> {

    private EquipoElectronico equipoElectronico;
    

    public EquipoElectronico getEquipoElectronico() {
        if (equipoElectronico == null) {
            equipoElectronico = new EquipoElectronico();
        }
        return equipoElectronico;
    }

    public void setEquipoElectronico(EquipoElectronico equipoElectronico) {
        this.equipoElectronico = equipoElectronico;
    }

    public EquipoElectronicoDao() {
        super(EquipoElectronico.class);

    }

    public Boolean guardar_modificar() {
        try {
            if (getEquipoElectronico().getId_Equipo() != null) {
                //
                modificaree(this.getEquipoElectronico());
            } else {
                guardar(this.getEquipoElectronico());
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en guadar o modificar");
            return false;
        }
    }

}
