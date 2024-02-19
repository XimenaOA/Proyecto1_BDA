package Dominio;

import java.util.Objects;

public class Domicilio {
    //Atributos de la clase
    private int idDomicilio;
    private String colonia;
    private String calle;
    private int numero;
    private int idCliente;

    /**
     * Constructor vacio por defecto
     */
    public Domicilio() {
    }

     /**
     * Constructor con todos los atributos.
     * @param idDomicilio El ID del domicilio.
     * @param colonia La colonia del domicilio.
     * @param calle La calle del domicilio.
     * @param numero El número del domicilio.
     * @param idCliente El ID del cliente asociado al domicilio.
     */
    public Domicilio(int idDomicilio, String colonia, String calle, int numero, int idCliente) {
        this.idDomicilio = idDomicilio;
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el ID del domicilio.
     * @return El ID del domicilio.
     */
    public int getIdDomicilio() {
        return idDomicilio;
    }

    /**
     * Establece el ID del domicilio.
     * @param idDomicilio El ID del domicilio.
     */
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
        hash = 97 * hash + this.idDomicilio;
        hash = 97 * hash + Objects.hashCode(this.colonia);
        hash = 97 * hash + Objects.hashCode(this.calle);
        hash = 97 * hash + this.numero;
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
        final Domicilio other = (Domicilio) obj;
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
