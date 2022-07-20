/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package controlador.tda.lista.exception;

/**
 *
 * @author jona
 */
public class EstructuraVaciaException extends Exception{

    /**
     * Creates a new instance of <code>PilaException</code> without detail
     * message.
     */
    public EstructuraVaciaException() {
    }

    /**
     * Constructs an instance of <code>PilaException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public EstructuraVaciaException(String msg) {
        super(msg);
    }
}
