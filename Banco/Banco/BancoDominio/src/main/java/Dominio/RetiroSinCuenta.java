/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author Ximena
 */
public class RetiroSinCuenta {
    private int folio;
    private String estado;
    private String contrasena;
    private double monto;
    private String fecha;
    private String fechaDeInicio; // Nuevo campo
    private int idCuenta;

    public RetiroSinCuenta(int folio, String estado, String contrasena, double monto, String fecha, String fechaDeInicio, int idCuenta) {
        this.folio = folio;
        this.estado = estado;
        this.contrasena = contrasena;
        this.monto = monto;
        this.fecha = fecha;
        this.fechaDeInicio = fechaDeInicio;
        this.idCuenta = idCuenta;
    }

}
