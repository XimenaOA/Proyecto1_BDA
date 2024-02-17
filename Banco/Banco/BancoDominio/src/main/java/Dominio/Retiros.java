/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author Ximena
 */
public class Retiros {
    
    private String tipo;
    private int folio;
    private String estado;
    private String contrasena;
    private double monto;
    private String fecha;
    private int idCuenta;

    public Retiros() {
    }

    public Retiros(String tipo, double monto, String fecha, int idCuenta) {
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
        this.idCuenta = idCuenta;
    }

    
    public Retiros(int folio, String estado, String contrasena, double monto, String fecha, int idCuenta) {
        this.folio = folio;
        this.estado = estado;
        this.contrasena = contrasena;
        this.monto = monto;
        this.fecha = fecha;
        this.idCuenta = idCuenta;
    }

    public Retiros(String tipo, int folio, String estado, String contrasena, double monto, String fecha, int idCuenta) {
        this.tipo = tipo;
        this.folio = folio;
        this.estado = estado;
        this.contrasena = contrasena;
        this.monto = monto;
        this.fecha = fecha;
        this.idCuenta = idCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    
}