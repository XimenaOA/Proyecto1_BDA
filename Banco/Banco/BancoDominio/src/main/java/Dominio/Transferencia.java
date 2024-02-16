/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author Ximena
 */
public class Transferencia {
    private String concepto;
    private String destinatario;
    private String fechaDeTransferencia;
    private int idCuenta;

    public Transferencia(String concepto, String destinatario, String fechaDeTransferencia, int idCuenta) {
        this.concepto = concepto;
        this.destinatario = destinatario;
        this.fechaDeTransferencia = fechaDeTransferencia;
        this.idCuenta = idCuenta;
    }

}
