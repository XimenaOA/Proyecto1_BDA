/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteDto;

import Dominio.Domicilio;
import java.util.Objects;

/**
 *
 * @author jesus
 */
public class DomicilioDto {
    
    private String colonia;
    private String calle;
    private int numero;

    public DomicilioDto() {
    }

    public DomicilioDto(String colonia, String calle, int numero) {
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.colonia);
        hash = 41 * hash + Objects.hashCode(this.calle);
        hash = 41 * hash + this.numero;
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
