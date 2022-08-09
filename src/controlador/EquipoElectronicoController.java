/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.dao.EquipoElectronicoDao;
import controlador.tda.lista.ListaEnlazada;
import modelo.EquipoElectronico;

/**
 *
 * @author jona
 */
public class EquipoElectronicoController {
    private EquipoElectronicoDao equipoElectronico = new EquipoElectronicoDao();
    private ListaEnlazada<EquipoElectronico> listaequipos = new ListaEnlazada();

    public EquipoElectronicoDao getEquipoElectronico() {
        return equipoElectronico;
    }

    public void setEquipoElectronico(EquipoElectronicoDao equipoElectronico) {
        this.equipoElectronico = equipoElectronico;
    }
    

    public ListaEnlazada<EquipoElectronico> getListaequipos() {
        return listaequipos;
    }

    public void setListaequipos(ListaEnlazada<EquipoElectronico> listaequipos) {
        this.listaequipos = listaequipos;
    }
    
    
}
