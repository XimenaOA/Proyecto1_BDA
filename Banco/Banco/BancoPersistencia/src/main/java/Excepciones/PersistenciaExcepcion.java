/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * La clase PersistenciaExcepcion representa una excepción relacionada con
 * operaciones de persistencia. Esta excepción puede ser lanzada en casos donde
 * ocurran errores durante la persistencia de datos.
 *
 * @author Jesús Alberto Morales Rojas - 245335, Ximena Oliva Andrade - 247563
 *
 */
public class PersistenciaExcepcion extends Exception {

    /**
     * Constructor vacío de la clase PersistenciaExcepcion.
     */
    public PersistenciaExcepcion() {
    }

    /**
     * Constructor de la clase PersistenciaExcepcion que acepta un mensaje de
     * error.
     *
     * @param message Mensaje de error que describe la excepción.
     */
    public PersistenciaExcepcion(String message) {
        super(message);
    }

    /**
     * Constructor de la clase PersistenciaExcepcion que acepta un mensaje de
     * error y una causa.
     *
     * @param message Mensaje de error que describe la excepción.
     * @param cause Causa de la excepción.
     */
    public PersistenciaExcepcion(String message, Throwable cause) {
        super(message, cause);
    }

}
