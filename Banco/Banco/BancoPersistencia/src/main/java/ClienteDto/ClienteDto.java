/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteDto;

import Dominio.Clientes;
import java.util.Objects;

/**
 *
 * @author Jesús Alberto Morales Rojas - 245335, Ximena Oliva Andrade - 247563
 * 
 * Representa un objeto de transferencia de datos (DTO) para la clase Cliente.
 * Contiene los atributos correspondientes a un cliente, incluyendo su nombre,
 * apellidos, fecha de nacimiento, nombre de usuario y contraseña.
 */
public class ClienteDto {
    //Atributos de la clase
    int id;
    String nombre, apellidoPaterno, apellidoMaterno, fehcadenacimiento, usr, contrasena;
    
    /**
     * Constructor vacío de la clase ClienteDto.
     */
    public ClienteDto() {
    }

     /**
     * Constructor de la clase ClienteDto que recibe el ID del cliente.
     * 
     * @param id El ID del cliente.
     */
    public ClienteDto(int id) {
        this.id = id;
    }

     /**
     * Constructor de la clase ClienteDto que recibe todos los atributos del cliente.
     * 
     * @param nombre El nombre del cliente.
     * @param apellidoPaterno El apellido paterno del cliente.
     * @param apellidoMaterno El apellido materno del cliente.
     * @param fehcadenacimiento La fecha de nacimiento del cliente.
     * @param usr El nombre de usuario del cliente.
     * @param contrasena La contraseña del cliente.
     */
    public ClienteDto(String nombre, String apellidoPaterno, String apellidoMaterno, String fehcadenacimiento, String usr, String contrasena) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fehcadenacimiento = fehcadenacimiento;
        this.usr = usr;
        this.contrasena = contrasena;
    }

    /**
     * Constructor de la clase ClienteDto que recibe todos los atributos del cliente, incluido su ID.
     * 
     * @param id El ID del cliente.
     * @param nombre El nombre del cliente.
     * @param apellidoPaterno El apellido paterno del cliente.
     * @param apellidoMaterno El apellido materno del cliente.
     * @param fehcadenacimiento La fecha de nacimiento del cliente.
     * @param usr El nombre de usuario del cliente.
     * @param contrasena La contraseña del cliente.
     */
    public ClienteDto(int id, String nombre, String apellidoPaterno, String apellidoMaterno, String fehcadenacimiento, String usr, String contrasena) {

        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fehcadenacimiento = fehcadenacimiento;
        this.usr = usr;
        this.contrasena = contrasena;
    }

      /**
     * Constructor de la clase ClienteDto que recibe el ID y algunos atributos del cliente.
     * 
     * @param id El ID del cliente.
     * @param nombre El nombre del cliente.
     * @param apellidoPaterno El apellido paterno del cliente.
     * @param apellidoMaterno El apellido materno del cliente.
     * @param contrasena La contraseña del cliente.
     */
    public ClienteDto(int id, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasena = contrasena;
    }

     /**
     * Obtiene el ID del cliente.
     * 
     * @return El ID del cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del cliente.
     * 
     * @param id El ID del cliente.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param nombre El nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del cliente.
     * 
     * @return El apellido paterno del cliente.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del cliente.
     * 
     * @param apellidoPaterno El apellido paterno del cliente.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del cliente.
     * 
     * @return El apellido materno del cliente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del cliente.
     * 
     * @param apellidoMaterno El apellido materno del cliente.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene la fecha de nacimiento del cliente.
     * 
     * @return La fecha de nacimiento del cliente.
     */
    public String getFehcadenacimiento() {
        return fehcadenacimiento;
    }

    /**
     * Establece la fecha de nacimiento del cliente.
     * 
     * @param fehcadenacimiento La fecha de nacimiento del cliente.
     */
    public void setFehcadenacimiento(String fehcadenacimiento) {
        this.fehcadenacimiento = fehcadenacimiento;
    }

    /**
     * Obtiene el nombre de usuario del cliente.
     * 
     * @return El nombre de usuario del cliente.
     */
    public String getUsr() {
        return usr;
    }

    /**
     * Establece el nombre de usuario del cliente.
     * 
     * @param usr El nombre de usuario del cliente.
     */
    public void setUsr(String usr) {
        this.usr = usr;
    }

    /**
     * Obtiene la contraseña del cliente.
     * 
     * @return La contraseña del cliente.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del cliente.
     * 
     * @param contrasena La contraseña del cliente.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    

    /**
     * Genera un código hash único para el objeto basado en sus atributos.
     * 
     * @return El código hash generado.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.apellidoPaterno);
        hash = 97 * hash + Objects.hashCode(this.apellidoMaterno);
        hash = 97 * hash + Objects.hashCode(this.fehcadenacimiento);
        hash = 97 * hash + Objects.hashCode(this.usr);
        hash = 97 * hash + Objects.hashCode(this.contrasena);
        return hash;
    }

    /**
     * Compara este objeto con otro para determinar si son iguales.
     * 
     * @param obj El objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
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
        final ClienteDto other = (ClienteDto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidoPaterno, other.apellidoPaterno)) {
            return false;
        }
        if (!Objects.equals(this.apellidoMaterno, other.apellidoMaterno)) {
            return false;
        }
        if (!Objects.equals(this.fehcadenacimiento, other.fehcadenacimiento)) {
            return false;
        }
        if (!Objects.equals(this.usr, other.usr)) {
            return false;
        }
        return Objects.equals(this.contrasena, other.contrasena);
    }
}
