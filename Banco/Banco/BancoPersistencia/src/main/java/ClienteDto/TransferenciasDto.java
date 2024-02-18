/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteDto;

import java.util.Objects;

/**
 *
 * @author Ximena
 */
public class TransferenciasDto {
    
    private String tipo;
    private Double concepto;
    private long remitente;
    private long destinatario;
    private String fechaDeTransferencia;
    private int idCuenta;

    public TransferenciasDto() {
    }

    
    
    public TransferenciasDto(String tipo, Double concepto, long remitente, long destinatario, String fechaDeTransferencia, int idCuenta) {
        this.tipo = tipo;
        this.concepto = concepto;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.fechaDeTransferencia = fechaDeTransferencia;
        this.idCuenta = idCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getConcepto() {
        return concepto;
    }

    public void setConcepto(Double concepto) {
        this.concepto = concepto;
    }

    public long getRemitente() {
        return remitente;
    }

    public void setRemitente(long remitente) {
        this.remitente = remitente;
    }

    public long getDestinatario() {
        return destinatario;
    }

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
        final TransferenciasDto other = (TransferenciasDto) obj;
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
