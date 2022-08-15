package vista;

import vista.Frm_Inicio;
import vista.Frm_Login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nathaly
 */
public class Inicio {

    
    public static void main(String[] args) {
        Frm_Inicio pre= new Frm_Inicio ();
        pre.setVisible(true);
       
        try{
            for(int i=0; i<=100; i++){
                Thread.sleep(20);
                pre.porcentaje.setText(Integer.toString(i)+"%");
                pre.barra.setValue(i);
                
                if(i==100){
                    pre.setVisible(false);
                    
                     Frm_Login iniciar= new Frm_Login();
                    iniciar.setVisible(true);
                }
            }
        }catch (Exception e){
        }
    }
    
}
