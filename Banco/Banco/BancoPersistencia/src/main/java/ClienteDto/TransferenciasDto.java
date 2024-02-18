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
    private long destinatario;
    private String fechaDeTransferencia;
    private int idCuenta;

    public TransferenciasDto() {
    }

    public TransferenciasDto(String tipo) {
        this.tipo = tipo;
    }

    public TransferenciasDto(String tipo, Double concepto, int destinatario, String fechaDeTransferencia, int idCuenta) {
        this.tipo = tipo;
        this.concepto = concepto;
        this.destinatario = destinatario;
        this.fechaDeTransferencia = fechaDeTransferencia;
        this.idCuenta = idCuenta;
    }

    public TransferenciasDto(Double concepto, int destinatario, String fechaDeTransferencia, int idCuenta) {
        this.concepto = concepto;
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
        hash = 79 * hash + Objects.hashCode(this.tipo);
        hash = 79 * hash + Objects.hashCode(this.concepto);
        hash = 79 * hash + Objects.hashCode(this.fechaDeTransferencia);
        hash = 79 * hash + this.idCuenta;
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
