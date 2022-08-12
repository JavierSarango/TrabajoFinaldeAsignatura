/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.dao.EquipoElectronicoDao;
import controlador.tda.lista.ListaEnlazada;
import modelo.equipo;

/**
 *
 * @author jona
 */
public class EquipoElectronicoController {
    private EquipoElectronicoDao equipoElectronico = new EquipoElectronicoDao();
    private ListaEnlazada<equipo> listaequipos = new ListaEnlazada();

    public EquipoElectronicoDao getEquipoElectronico() {
        return equipoElectronico;
    }

    public void setEquipoElectronico(EquipoElectronicoDao equipoElectronico) {
        this.equipoElectronico = equipoElectronico;
    }
    

    public ListaEnlazada<equipo> getListaequipos() {
        return listaequipos;
    }

    public void setListaequipos(ListaEnlazada<equipo> listaequipos) {
        this.listaequipos = listaequipos;
    }
    
    
}
