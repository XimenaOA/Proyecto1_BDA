package Dominio;

import java.util.Objects;

/**
 * La clase Cuentas representa una cuenta bancaria asociada a un cliente.
 * @author Ximena Oliva Andrade - 247563, Jesús Alberto Morales Rojas - 245335
 */

public class Cuentas {
    // Atributos de la clase
    long numeroDeCuenta;
    String fechaApertura;
    double saldo;
    int idCliente;
    int idCuenta;

    /**
     * Constructor vacío de la clase Cuentas.
     */
    public Cuentas() {
    }

    /**
     * Constructor de la clase Cuentas que inicializa los atributos de la cuenta.
     *
     * @param numeroDeCuenta Número de cuenta bancaria.
     * @param fechaApertura Fecha de apertura de la cuenta.
     * @param saldo Saldo de la cuenta.
     * @param idCliente ID del cliente asociado a la cuenta.
     */
    public Cuentas(long numeroDeCuenta, String fechaApertura, double saldo, int idCliente) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }
    
    /**
     * Método getter para obtener el número de cuenta.
     *
     * @return Número de cuenta.
     */
    public long getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

     /**
     * Método setter para establecer el número de cuenta.
     *
     * @param numeroDeCuenta Número de cuenta.
     */
    public void setNumeroDeCuenta(long numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

     /**
     * Método getter para obtener la fecha de apertura de la cuenta.
     *
     * @return Fecha de apertura de la cuenta.
     */
    public String getFechaApertura() {
        return fechaApertura;
    }

     /**
     * Método setter para establecer la fecha de apertura de la cuenta.
     *
     * @param fechaApertura Fecha de apertura de la cuenta.
     */
    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Método getter para obtener el saldo de la cuenta.
     *
     * @return Saldo de la cuenta.
     */
    public double getSaldo() {
        return saldo;
    }

     /**
     * Método setter para establecer el saldo de la cuenta.
     *
     * @param saldo Saldo de la cuenta.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

     /**
     * Método getter para obtener el ID del cliente asociado a la cuenta.
     *
     * @return ID del cliente asociado a la cuenta.
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Método setter para establecer el ID del cliente asociado a la cuenta.
     *
     * @param idCliente ID del cliente asociado a la cuenta.
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

     /**
     * Método hashCode que genera un código hash para la cuenta.
     *
     * @return Código hash de la cuenta.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.numeroDeCuenta ^ (this.numeroDeCuenta >>> 32));
        hash = 97 * hash + Objects.hashCode(this.fechaApertura);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.saldo) ^ (Double.doubleToLongBits(this.saldo) >>> 32));
        hash = 97 * hash + this.idCliente;
        return hash;
    }
   
    /**
     * Método equals que compara dos cuentas para verificar si son iguales.
     *
     * @param obj Objeto a comparar con la cuenta actual.
     * @return true si las cuentas son iguales, false en caso contrario.
     */
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
