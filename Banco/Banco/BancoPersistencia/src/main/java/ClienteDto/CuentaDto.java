/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteDto;

import Dominio.Cuentas;
import java.util.Objects;

/**
 *
 * @author Ximena Oliva Andrade - 247563, Jesús Alberto Morales Rojas - 245335
 * 
 * Clase que representa los datos de una cuenta.
 */
public class CuentaDto {
    //Atributos de la clase
    long numeroDeCuenta;
    String fechaApertura;
    double saldo;
    int idCliente;

    /**
     * Constructor vacío de la clase CuentaDto.
     */
    public CuentaDto() {
    }

    /**
     * Constructor de la clase CuentaDto que inicializa todos los atributos.
     * 
     * @param numeroDeCuenta El número de cuenta.
     * @param fechaApertura La fecha de apertura de la cuenta.
     * @param saldo El saldo de la cuenta.
     * @param idCliente El ID del cliente asociado a la cuenta.
     */
    public CuentaDto(long numeroDeCuenta, String fechaApertura, double saldo, int idCliente) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }
    
     /**
     * Método getter para obtener el número de cuenta.
     * 
     * @return El número de cuenta.
     */
    public long getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    
    /**
     * Método setter para establecer el número de cuenta.
     * 
     * @param numeroDeCuenta El número de cuenta a establecer.
     */
    public void setNumeroDeCuenta(long numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    /**
     * Método getter para obtener la fecha de apertura de la cuenta.
     * 
     * @return La fecha de apertura de la cuenta.
     */
    public String getFechaApertura() {
        return fechaApertura;
    }

    
    /**
     * Método setter para establecer la fecha de apertura de la cuenta.
     * 
     * @param fechaApertura La fecha de apertura a establecer.
     */
    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

      /**
     * Método getter para obtener el saldo de la cuenta.
     * 
     * @return El saldo de la cuenta.
     */
    public double getSaldo() {
        return saldo;
    }

     /**
     * Método setter para establecer el saldo de la cuenta.
     * 
     * @param saldo El saldo a establecer.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
    /**
     * Método getter para obtener el ID del cliente asociado a la cuenta.
     * 
     * @return El ID del cliente asociado a la cuenta.
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Método setter para establecer el ID del cliente asociado a la cuenta.
     * 
     * @param idCliente El ID del cliente a establecer.
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

     /**
     * Método hashCode que genera un código hash para el objeto.
     * 
     * @return El código hash generado.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.numeroDeCuenta ^ (this.numeroDeCuenta >>> 32));
        hash = 97 * hash + Objects.hashCode(this.fechaApertura);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.saldo) ^ (Double.doubleToLongBits(this.saldo) >>> 32));
        hash = 97 * hash + this.idCliente;
        return hash;
    }

    /**
     * Método equals para comparar dos instancias de CuentaDto.
     * 
     * @param obj El objeto a comparar.
     * @return true si las instancias son iguales, false en caso contrario.
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
        final CuentaDto other = (CuentaDto) obj;
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
