package Dominio;

import java.util.Objects;

/**
 * Clase representativa de la entidad Domicilios
 *
 * @author Jesús Alberto Morales Rojas - 245335, Ximena Oliva Andrade - 247563
 */
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
     *
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
     *
     * @return El ID del domicilio.
     */
    public int getIdDomicilio() {
        return idDomicilio;
    }

    /**
     * Establece el ID del domicilio.
     *
     * @param idDomicilio El ID del domicilio.
     */
    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    /**
     * Obtiene la colonia del domicilio.
     *
     * @return La colonia del domicilio.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia del domicilio.
     *
     * @param colonia La colonia del domicilio.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene la calle del domicilio.
     *
     * @return La calle del domicilio.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle del domicilio.
     *
     * @param calle La calle del domicilio.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el número del domicilio.
     *
     * @return El número del domicilio.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Establece el número del domicilio.
     *
     * @param numero El número del domicilio.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el ID del cliente asociado al domicilio.
     *
     * @return El ID del cliente asociado al domicilio.
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el ID del cliente asociado al domicilio.
     *
     * @param idCliente El ID del cliente asociado al domicilio.
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Calcula el código hash para el objeto.
     *
     * @return El código hash del objeto.
     */
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

    /**
     * Compara este objeto con otro objeto para determinar su igualdad.
     *
     * @param obj El objeto a comparar.
     * @return true si los objetos son iguales, false de lo contrario.
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
