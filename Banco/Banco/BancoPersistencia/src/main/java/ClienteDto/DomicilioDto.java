/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteDto;

import Dominio.Domicilio;
import java.util.Objects;

/**
 * Clase que representa los datos de un domicilio y que contiene
 * todos sus datos
 * 
 * @author Jesús Alberto Morales Rojas - 245335, Ximena Oliva Andrade - 247563
 *
 */
public class DomicilioDto {

    //Atributos de la clase
    private String colonia;
    private String calle;
    private int numero;

    /**
     * Constructor vacío de la clase DomicilioDto.
     */
    public DomicilioDto() {
    }
    
    /**
     * Constructor de la clase DomicilioDto que inicializa todos los atributos.
     *
     * @param colonia La colonia del domicilio.
     * @param calle La calle del domicilio.
     * @param numero El número del domicilio.
     */
    public DomicilioDto(String colonia, String calle, int numero) {
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
    }

    /**
     * Método getter para obtener la colonia del domicilio.
     *
     * @return La colonia del domicilio.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Metodo para setear la colonia
     * @param colonia Colonia
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Método getter para obtener la calle del domicilio.
     *
     * @return La calle del domicilio.
     */
    public String getCalle() {
        return calle;
    }

   /**
    * Método que setea la calle del domicilio
    * @param calle Calle del domicilio
    */
    public void setCalle(String calle) {
        this.calle = calle;
    }

     /**
     * Método getter para obtener el número del domicilio.
     *
     * @return El número del domicilio.
     */
    
    public int getNumero() {
        return numero;
    }

   /**
    * Método que setea el número del domicilio
    * @param numero Número del domicilio
    */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Método hashCode que genera un código hash para el objeto.
     *
     * @return El código hash generado.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.colonia);
        hash = 41 * hash + Objects.hashCode(this.calle);
        hash = 41 * hash + this.numero;
        return hash;
    }

    /**
     * Método equals para comparar dos instancias de DomicilioDto.
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
        final DomicilioDto other = (DomicilioDto) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.colonia, other.colonia)) {
            return false;
        }
        return Objects.equals(this.calle, other.calle);
    }

}
