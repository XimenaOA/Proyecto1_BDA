/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.Objects;

/**
 *
 * @author Ximena
 */
public class Transferencias {
    //Atributos de la clase
    private String tipo;
    private Double concepto;
    private long remitente;
    private long destinatario;
    private String fechaDeTransferencia;
    private int idCuenta;

    /**
     * Contructor vacio por defecto
     */
    public Transferencias() {
    }

      /**
     * Constructor con concepto, remitente, destinatario y fecha de transferencia.
     * @param concepto El monto de la transferencia.
     * @param remitente El ID de la cuenta remitente.
     * @param destinatario El ID de la cuenta destinataria.
     * @param fechaDeTransferencia La fecha de la transferencia.
     */
    public Transferencias(Double concepto, long remitente, long destinatario, String fechaDeTransferencia) {
        this.concepto = concepto;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.fechaDeTransferencia = fechaDeTransferencia;
    }

    /**
     * Constructor con tipo, concepto, remitente, destinatario, fecha de transferencia y ID de cuenta.
     * @param tipo El tipo de la transferencia (por ejemplo, "Transferencia" o "Pago").
     * @param concepto El monto de la transferencia.
     * @param remitente El ID de la cuenta remitente.
     * @param destinatario El ID de la cuenta destinataria.
     * @param fechaDeTransferencia La fecha de la transferencia.
     * @param idCuenta El ID de la cuenta asociada a la transferencia.
     */
    public Transferencias(String tipo, Double concepto, long remitente, long destinatario, String fechaDeTransferencia, int idCuenta) {
        this.tipo = tipo;
        this.concepto = concepto;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.fechaDeTransferencia = fechaDeTransferencia;
        this.idCuenta = idCuenta;
    }

    /**
     * Obtiene el tipo de la transferencia.
     * @return El tipo de la transferencia.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la transferencia.
     * @param tipo El tipo de la transferencia.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el monto de la transferencia.
     * @return El monto de la transferencia.
     */
    public Double getConcepto() {
        return concepto;
    }

    
    /**
     * Establece el monto de la transferencia.
     * @param concepto El monto de la transferencia.
     */
    public void setConcepto(Double concepto) {
        this.concepto = concepto;
    }

    /**
     * Obtiene el ID de la cuenta remitente.
     * @return El ID de la cuenta remitente.
     */
    public long getRemitente() {
        return remitente;
    }

    /**
     * Establece el ID de la cuenta remitente.
     * @param remitente El ID de la cuenta remitente.
     */
    public void setRemitente(long remitente) {
        this.remitente = remitente;
    }

    /**
     * Obtiene el ID de la cuenta destinataria.
     * @return El ID de la cuenta destinataria.
     */
    public long getDestinatario() {
        return destinatario;
    }

    /**
     * Establece el ID de la cuenta destinataria.
     * @param destinatario El ID de la cuenta destinataria.
     */
    public void setDestinatario(long destinatario) {
        this.destinatario = destinatario;
    }

    
    public String getFechaDeTransferencia() {
        return fechaDeTransferencia;
    }

    public void setFechaDeTransferencia(String fechaDeTransferencia) {
        this.fechaDeTransferencia = fechaDeTransferencia;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.tipo);
        hash = 59 * hash + Objects.hashCode(this.concepto);
        hash = 59 * hash + (int) (this.remitente ^ (this.remitente >>> 32));
        hash = 59 * hash + (int) (this.destinatario ^ (this.destinatario >>> 32));
        hash = 59 * hash + Objects.hashCode(this.fechaDeTransferencia);
        hash = 59 * hash + this.idCuenta;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transferencias other = (Transferencias) obj;
        if (this.remitente != other.remitente) {
            return false;
        }
        if (this.destinatario != other.destinatario) {
            return false;
        }
        if (this.idCuenta != other.idCuenta) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.fechaDeTransferencia, other.fechaDeTransferencia)) {
            return false;
        }
        return Objects.equals(this.concepto, other.concepto);
    }

    
}
