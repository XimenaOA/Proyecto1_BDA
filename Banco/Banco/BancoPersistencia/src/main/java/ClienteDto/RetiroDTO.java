/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteDto;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Ximena
 */
public class RetiroDTO {
    
    
    private String tipo;
    private long folio;
    private String estado;
    private int contrasena;
    private double monto;
    private LocalDateTime fecha;
    private int idCuenta;

    public RetiroDTO() {
    }

    public RetiroDTO(String tipo, double monto, LocalDateTime fecha, int idCuenta) {
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
        this.idCuenta = idCuenta;
    }

    
    
    public RetiroDTO(long folio, String estado, int contrasena, double monto, LocalDateTime fecha, int idCuenta) {
        this.folio = folio;
        this.estado = estado;
        this.contrasena = contrasena;
        this.monto = monto;
        this.fecha = fecha;
        this.idCuenta = idCuenta;
    }

    public RetiroDTO(String tipo, long folio, String estado, int contrasena, double monto, LocalDateTime fecha, int idCuenta) {
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

    public int getContrasena() {
        return contrasena;
    }

    public void setContrasena(int contrasena) {
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

    
}
