/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Clase representativa de la entidad retiros
 * @author Jesús Alberto Morales Rojas - 245335, Ximena Oliva Andrade - 247563
 */
public class Retiros {

    //Atributos de la clase
    private String tipo;
    private long folio;
    private long numCuenta;
    private String estado;
    private String contrasena;
    private double monto;
    private LocalDateTime fecha;
    private int idCuenta;

    /**
     * Constructor vacio por defecto
     */
    public Retiros() {
    }

    /**
     * Constructor con tipo, número de cuenta, monto, fecha y ID de cuenta.
     *
     * @param tipo El tipo de retiro.
     * @param numCuenta El número de cuenta desde donde se realiza el retiro.
     * @param monto El monto del retiro.
     * @param fecha La fecha y hora del retiro.
     * @param idCuenta El ID de la cuenta asociada al retiro.
     */
    public Retiros(String tipo, long numCuenta, double monto, LocalDateTime fecha, int idCuenta) {
        this.tipo = tipo;
        this.monto = monto;
        this.numCuenta = numCuenta;
        this.fecha = fecha;
        this.idCuenta = idCuenta;
    }

    /**
     * Constructor con contraseña.
     *
     * @param contrasena La contraseña necesaria para realizar el retiro.
     */
    public Retiros(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Constructor con folio, número de cuenta, estado, contraseña, monto, fecha
     * y ID de cuenta.
     *
     * @param folio El folio del retiro.
     * @param numCuenta El número de cuenta desde donde se realiza el retiro.
     * @param estado El estado del retiro.
     * @param contrasena La contraseña necesaria para realizar el retiro.
     * @param monto El monto del retiro.
     * @param fecha La fecha y hora del retiro.
     * @param idCuenta El ID de la cuenta asociada al retiro.
     */
    public Retiros(long folio, long numCuenta, String estado, String contrasena, double monto, LocalDateTime fecha, int idCuenta) {
        this.folio = folio;
        this.estado = estado;
        this.contrasena = contrasena;
        this.numCuenta = numCuenta;
        this.monto = monto;
        this.fecha = fecha;
        this.idCuenta = idCuenta;
    }

    /**
     * Constructor con tipo, número de cuenta, folio, estado, contraseña, monto,
     * fecha y ID de cuenta.
     *
     * @param tipo El tipo de retiro.
     * @param numCuenta El número de cuenta desde donde se realiza el retiro.
     * @param folio El folio del retiro.
     * @param estado El estado del retiro.
     * @param contrasena La contraseña necesaria para realizar el retiro.
     * @param monto El monto del retiro.
     * @param fecha La fecha y hora del retiro.
     * @param idCuenta El ID de la cuenta asociada al retiro.
     */
    public Retiros(String tipo, long numCuenta, long folio, String estado, String contrasena, double monto, LocalDateTime fecha, int idCuenta) {
        this.tipo = tipo;
        this.folio = folio;
        this.estado = estado;
        this.contrasena = contrasena;
        this.numCuenta = numCuenta;
        this.monto = monto;
        this.fecha = fecha;
        this.idCuenta = idCuenta;
    }

    /**
     * Obtiene el tipo de retiro.
     *
     * @return El tipo de retiro.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de retiro.
     *
     * @param tipo El tipo de retiro.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el folio del retiro.
     *
     * @return El folio del retiro.
     */
    public long getFolio() {
        return folio;
    }

    /**
     * Establece el folio del retiro.
     *
     * @param folio El folio del retiro.
     */
    public void setFolio(int folio) {
        this.folio = folio;
    }

    /**
     * Obtiene el estado del retiro.
     *
     * @return El estado del retiro.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del retiro.
     *
     * @param estado El estado del retiro.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la contraseña necesaria para realizar el retiro.
     *
     * @return La contraseña necesaria para realizar el retiro.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña necesaria para realizar el retiro.
     *
     * @param contrasena La contraseña necesaria para realizar el retiro.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el monto del retiro.
     *
     * @return El monto del retiro.
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Establece el monto del retiro.
     *
     * @param monto El monto del retiro.
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Obtiene la fecha y hora del retiro.
     *
     * @return La fecha y hora del retiro.
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha y hora del retiro.
     *
     * @param fecha La fecha y hora del retiro.
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el ID de la cuenta asociada al retiro.
     *
     * @return El ID de la cuenta asociada al retiro.
     */
    public int getIdCuenta() {
        return idCuenta;
    }

    /**
     * Establece el ID de la cuenta asociada al retiro.
     *
     * @param idCuenta El ID de la cuenta asociada al retiro.
     */
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

     /**
     * Obtiene el número de cuenta desde donde se realiza el retiro.
     * @return El número de cuenta desde donde se realiza el retiro.
     */
    public long getNumCuenta() {
        return numCuenta;
    }

    /**
     * Establece el número de cuenta desde donde se realiza el retiro.
     * @param numCuenta El número de cuenta desde donde se realiza el retiro.
     */
    public void setNumCuenta(long numCuenta) {
        this.numCuenta = numCuenta;
    }

}
