/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package controlador.tda.lista.exception;

/**
 *
 * @author jona
 */
public class TopeExeption extends Exception{

    /**
     * Creates a new instance of <code>TopeExeption</code> without detail
     * message.
     */
    public TopeExeption() {
    }

    /**
     * Constructs an instance of <code>TopeExeption</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public TopeExeption(String msg) {
        super(msg);
    }
}
