/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.Objects;

/**
 *
 * @author jesus
 */
public class Movimientos {

    private int idMovimiento;
    private String tipoMovimiento;
    private double saldo;
    private String fecha;
    private int idCliente;

    public Movimientos() {
    }

    public Movimientos(int idMovimiento, String tipoMovimiento, double saldo, String fecha, int idCliente) {
        this.idMovimiento = idMovimiento;
        this.tipoMovimiento = tipoMovimiento;
        this.saldo = saldo;
        this.fecha = fecha;
        this.idCliente = idCliente;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.idMovimiento;
        hash = 37 * hash + Objects.hashCode(this.tipoMovimiento);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.saldo) ^ (Double.doubleToLongBits(this.saldo) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.fecha);
        hash = 37 * hash + this.idCliente;
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
        final Movimientos other = (Movimientos) obj;
        if (this.idMovimiento != other.idMovimiento) {
            return false;
        }
        if (Double.doubleToLongBits(this.saldo) != Double.doubleToLongBits(other.saldo)) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.tipoMovimiento, other.tipoMovimiento)) {
            return false;
        }
        return Objects.equals(this.fecha, other.fecha);
    }

    
}
