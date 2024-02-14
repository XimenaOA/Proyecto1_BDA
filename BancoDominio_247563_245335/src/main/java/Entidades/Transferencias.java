/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Objects;

/**
 *
 * @author lv1821
 */
public class Transferencias {
    String concepto, destinatario, fechaDeTransferenciam;
    double saldoTransferido;
    int idCliente;

    public Transferencias() {
    }

    public Transferencias(String concepto, String destinatario, String fechaDeTransferenciam, double saldoTransferido) {
        this.concepto = concepto;
        this.destinatario = destinatario;
        this.fechaDeTransferenciam = fechaDeTransferenciam;
        this.saldoTransferido = saldoTransferido;
    }

    public Transferencias(String concepto, String destinatario, String fechaDeTransferenciam, double saldoTransferido, int idCliente) {
        this.concepto = concepto;
        this.destinatario = destinatario;
        this.fechaDeTransferenciam = fechaDeTransferenciam;
        this.saldoTransferido = saldoTransferido;
        this.idCliente = idCliente;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getFechaDeTransferenciam() {
        return fechaDeTransferenciam;
    }

    public void setFechaDeTransferenciam(String fechaDeTransferenciam) {
        this.fechaDeTransferenciam = fechaDeTransferenciam;
    }

    public double getSaldoTransferido() {
        return saldoTransferido;
    }

    public void setSaldoTransferido(double saldoTransferido) {
        this.saldoTransferido = saldoTransferido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.concepto);
        hash = 23 * hash + Objects.hashCode(this.destinatario);
        hash = 23 * hash + Objects.hashCode(this.fechaDeTransferenciam);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.saldoTransferido) ^ (Double.doubleToLongBits(this.saldoTransferido) >>> 32));
        hash = 23 * hash + this.idCliente;
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
        if (Double.doubleToLongBits(this.saldoTransferido) != Double.doubleToLongBits(other.saldoTransferido)) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.concepto, other.concepto)) {
            return false;
        }
        if (!Objects.equals(this.destinatario, other.destinatario)) {
            return false;
        }
        return Objects.equals(this.fechaDeTransferenciam, other.fechaDeTransferenciam);
    }

    @Override
    public String toString() {
        return "Transferencias{" + "concepto=" + concepto + ", destinatario=" + destinatario + ", fechaDeTransferenciam=" + fechaDeTransferenciam + ", saldoTransferido=" + saldoTransferido + ", idCliente=" + idCliente + '}';
    }
    
    
}
