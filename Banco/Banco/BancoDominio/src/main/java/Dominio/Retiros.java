/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Ximena
 */
public class Retiros {
    
    
    private String tipo;
    private long folio;
    private long numCuenta;
    private String estado;
    private String contrasena;
    private double monto;
    private LocalDateTime fecha;
    private int idCuenta;

    public Retiros() {
    }

    public Retiros(String tipo,long numCuenta,  double monto, LocalDateTime fecha, int idCuenta) {
        this.tipo = tipo;
        this.monto = monto;
        this.numCuenta=numCuenta;
        this.fecha = fecha;
        this.idCuenta = idCuenta;
    }

    public Retiros(String contrasena) {
        this.contrasena = contrasena;
    }

    
    public Retiros(long folio,long numCuenta, String estado, String contrasena, double monto, LocalDateTime fecha, int idCuenta) {
        this.folio = folio;
        this.estado = estado;
        this.contrasena = contrasena;
        this.numCuenta=numCuenta;
        this.monto = monto;
        this.fecha = fecha;
        this.idCuenta = idCuenta;
    }

    public Retiros(String tipo,long numCuenta, long folio, String estado, String contrasena, double monto, LocalDateTime fecha, int idCuenta) {
        this.tipo = tipo;
        this.folio = folio;
        this.estado = estado;
        this.contrasena = contrasena;
        this.numCuenta=numCuenta;
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

    public long getFolio() {
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public long getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(long numCuenta) {
        this.numCuenta = numCuenta;
    }

}
