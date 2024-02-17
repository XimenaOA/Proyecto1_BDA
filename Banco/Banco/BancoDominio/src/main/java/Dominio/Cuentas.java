package Dominio;

import java.util.Objects;

public class Cuentas {

    long numeroDeCuenta;
    String fechaApertura;
    double saldo;
    int idCliente;

    public Cuentas() {
    }

    public Cuentas(long numeroDeCuenta, String fechaApertura, double saldo, int idCliente) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }
    
    public long getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(long numeroDeCuenta) {
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
        int hash = 3;
        hash = 97 * hash + (int) (this.numeroDeCuenta ^ (this.numeroDeCuenta >>> 32));
        hash = 97 * hash + Objects.hashCode(this.fechaApertura);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.saldo) ^ (Double.doubleToLongBits(this.saldo) >>> 32));
        hash = 97 * hash + this.idCliente;
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
