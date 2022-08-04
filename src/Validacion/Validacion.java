/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validacion;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Nathaly
 */
public class Validacion {

    //Variables para validar la cedula
    static final int MULT = 2;
    static final int TOTAL_PROVINCES = 24;


    /**
     *
     * @param num
     * @param txt
     * @param tam
     */
    //Valida que sea numero al momento de tipiar
    public void validaSeaNumero(KeyEvent num, JTextField txt, int tam) {

        try {
            char c = num.getKeyChar();
            if (!Character.isDigit(c)) {
                num.consume();
            }
            if (txt.getText().length() == tam) { // 2 es la cantidad de caracteres permitidos
                num.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex + "Error");
        }
    }

    /**
     *
     * @param num
     * @param txt
     * @param tam
     */
    //Convierte en mayuscula al momento de tipiar y verifica que solo sean letras
    public void convetMayusculaSoloLetras(KeyEvent num, JTextField txt, int tam) {
        char c = num.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            num.setKeyChar(c);
        }
        try {
            char letra = num.getKeyChar();
            if ((letra >= 'A' && letra <= 'Z') || (letra == ' ') || (letra == 'Á') || (letra == 'É') || (letra == 'Í') || (letra == 'Ó') || (letra == 'Ú') || (letra == 'Ñ')) {

            } else {
                num.consume();
            }
            if (txt.getText().length() == tam) { // 2 es la cantidad de caracteres permitidos
                num.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex + "Error");
        }
    }

    /**
     *
     * @param num
     * @param txt
     * @param tam
     */
    public void valNumReal(KeyEvent num, JTextField txt, int tam) {
        try {
            char c = num.getKeyChar();

            if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)
                    && (c != '.')) {
                num.consume();
            }

            if (c == '.' && txt.getText().contains(".")) {
                num.consume();
            }
            if (txt.getText().length() == tam) { // 2 es la cantidad de caracteres permitidos
                num.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex + "Error");
        }
    }

    /**
     *
     * @param id
     * @param nro
     * @return
     */
    public String codi(int id, int nro) {
        String num = "";
        if (id < 10) {
            num = "0" + String.valueOf(id);
        } else {
            num = String.valueOf(id);
        }
        nro++;
        if (nro < 10) {
            num += "000" + String.valueOf(nro);
        } else if (nro < 100) {
            num += "00" + String.valueOf(nro);
        } else if (nro < 1000) {
            num += "0" + String.valueOf(nro);
        } else {
            num += String.valueOf(nro);
        }
        return num;
    }

    //Valida E-mail
    public boolean validaCorreo(String email) {
        boolean valid = false;
        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        if (mather.find() == true) {
            valid = true;
            System.out.println("El email ingresado es válido.");
        }
        return valid;
    }

    //Valida Cedula
    /**
     *
     * @param identificationNumber
     * @return
     */
    public boolean validarCedula(String identificationNumber) {
        /**
         * nos devuelve si una cedula es correcta
         */
        boolean valid = false;

        // si no tiene 10 dígitos es inválida
        if (identificationNumber.length() != 10) {
            return valid;
        }
        String province = identificationNumber.substring(0, 2);

        // si sus dos primeros dígitos son inválidos
        if (Integer.parseInt(province) > TOTAL_PROVINCES) {
            return valid;
        }
        int totalEven = 0; // pares
        int totalOdd = 0; // impares

        // la última posición no cuenta solo es verificador
        int totalValidNumbers = identificationNumber.length() - 1;
        int verifier = Integer.parseInt(identificationNumber.charAt(9) + "");

        for (int i = 0; i < totalValidNumbers; i++) {
            int digit = Integer.parseInt(identificationNumber.charAt(i) + "");
            if (i % 2 == 0) {// si son impares
                int product = digit * MULT;
                if (product > 9) {
                    product = product - 9;
                }
                totalEven += product;
            } else { // si son pares
                totalOdd += digit;
            }
        }

        int total = totalOdd + totalEven;

        String totalString = String.valueOf(total + 10);

        // se verifica la decena superior
        if (totalString.length() > 1) {
            int first = Integer.parseInt(totalString.charAt(0) + "");
            total = Integer.parseInt(first + "0") - total;
            if (total == 10) {
                total = 0;
            }
        }
        int result = total;

        // si el número verificador es igual al resultado del algoritmo
        // entonces es una cédula válida
        if (result == verifier) {
            valid = true;
        }
        return valid;
    }

    public void HabiDesJPanel(JPanel jPanel, boolean estad) {
        for (Component a : jPanel.getComponents()) {
            a.setEnabled(estad);
        }
    }

    public void AbrirFormulario(JInternalFrame jInternalFrame, JDesktopPane desktopPane) {
        int lDesk = desktopPane.getWidth();
        int aDesk = desktopPane.getHeight();
        int lIFrame = jInternalFrame.getWidth();
        int aIFrame = jInternalFrame.getHeight();
        jInternalFrame.setLocation(lDesk / 2 - lIFrame, aDesk / 2 - aIFrame / 2);
        desktopPane.add(jInternalFrame);
        jInternalFrame.setVisible(true);
    }

   
}
