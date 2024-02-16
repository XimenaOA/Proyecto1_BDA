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
    
    private int idDomicilio;
    private String colonia;
    private String calle;
    private int numero;
    private int idCliente;

    public DomicilioDto() {
    }

    public DomicilioDto(int idDomicilio, String colonia, String calle, int numero, int idCliente) {
        this.idDomicilio = idDomicilio;
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
        this.idCliente = idCliente;
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idDomicilio;
        hash = 83 * hash + Objects.hashCode(this.colonia);
        hash = 83 * hash + Objects.hashCode(this.calle);
        hash = 83 * hash + this.numero;
        hash = 83 * hash + this.idCliente;
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
        if (this.idDomicilio != other.idDomicilio) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.colonia, other.colonia)) {
            return false;
        }
        return Objects.equals(this.calle, other.calle);
    }

    
}