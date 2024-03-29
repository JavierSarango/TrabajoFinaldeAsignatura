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
    
     public boolean validarRUC(String identificationNumber) {
        /**
         * nos devuelve si un ruc es correcto
         */
        boolean valido = false;

        // si no tiene 13 dígitos es inválida
        if (identificationNumber.length() != 13) {
            return valido;
        }
        String province = identificationNumber.substring(0, 2);

        // si sus dos primeros dígitos son inválidos
        if (Integer.parseInt(province) > TOTAL_PROVINCES) {
            return valido;
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

        String totalString = String.valueOf(total + 13);

        // se verifica la decena superior
        if (totalString.length() > 1) {
            int first = Integer.parseInt(totalString.charAt(0) + "");
            total = Integer.parseInt(first + "0") - total;
            if (total == 13) {
                total = 0;
            }
        }
        int result = total;

        // si el número verificador es igual al resultado del algoritmo
        // entonces es una cédula válida
        if (result == verifier) {
            valido = true;
        }
        return valido;
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

//    public Boolean validaRucEP(String ruc) {
//        int prov = Integer.parseInt(ruc.substring(0, 2));
//        boolean val = false;
//
//        if (!((prov > 0) && (prov <= TOTAL_PROVINCES))) {
//            return val;
//        }
//
//        Integer v1, v2, v3, v4, v5, v6, v7, v8, v9;
//        Integer sumatoria;
//        Integer modulo;
//        Integer digito;
//        Integer sustraendo;
//        int[] d = new int[ruc.length()];
//
//        for (int i = 0; i < d.length; i++) {
//            d[i] = Integer.parseInt(ruc.charAt(i) + "");
//        }
//
//        v1 = d[0] * 3;
//        v2 = d[1] * 2;
//        v3 = d[2] * 7;
//        v4 = d[3] * 6;
//        v5 = d[4] * 5;
//        v6 = d[5] * 4;
//        v7 = d[6] * 3;
//        v8 = d[7] * 2;
//        v9 = d[8];
//
//        sumatoria = v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8;
//        modulo = sumatoria % 11;
//        sustraendo = modulo * 11;
//        digito = 11 - (sumatoria - sustraendo);
//        System.out.println("Digito RUC" + digito);
//        System.out.println("Digito Calculado" + v9);
//
//        if (digito == v9) {
//            val = true;
//        } else {
//            val = false;
//        }
//        return val;
//    }
/*
        Metodo para validar que el usuario no ingrese caracteres no numericos enteros
     */
    public Boolean validarEnteros(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
        Metodo para validar que el usuario no ingrese caracteres no numericos
     */
    public Boolean validarDouble(String valor) {
        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
