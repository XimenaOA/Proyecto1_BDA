package Dominio;

import java.util.Objects;

public class Cuentas {

    int numeroDeCuenta;
    String fechaApertura;
    double saldo;
    int idCliente;

    public Cuentas() {
    }

    public Cuentas(int numeroDeCuenta, String fechaApertura, double saldo, int idCliente) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }
    
    public int getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(int numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.numeroDeCuenta;
        hash = 79 * hash + Objects.hashCode(this.fechaApertura);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.saldo) ^ (Double.doubleToLongBits(this.saldo) >>> 32));
        hash = 79 * hash + this.idCliente;
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
        final Cuentas other = (Cuentas) obj;
        if (this.numeroDeCuenta != other.numeroDeCuenta) {
            return false;
        }
        if (Double.doubleToLongBits(this.saldo) != Double.doubleToLongBits(other.saldo)) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return Objects.equals(this.fechaApertura, other.fechaApertura);
    }

}
