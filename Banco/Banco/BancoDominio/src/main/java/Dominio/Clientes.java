package Dominio;

import java.util.Objects;

public class Clientes {

    int id;
    String nombre, apellidoPaterno, apellidoMaterno, fehcadenacimiento, usr, contrasena;
    

    public Clientes() {
    }

    public Clientes(String nombre, String apellidoPaterno, String apellidoMaterno, String fehcadenacimiento) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fehcadenacimiento = fehcadenacimiento;
    }

    public Clientes(String nombre, String apellidoPaterno, String apellidoMaterno, String fehcadenacimiento, String usr, String contrasena) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fehcadenacimiento = fehcadenacimiento;
        this.usr = usr;
        this.contrasena = contrasena;
    }

    public Clientes(int id, String nombre, String apellidoPaterno, String apellidoMaterno, String fehcadenacimiento, String usr, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fehcadenacimiento = fehcadenacimiento;
        this.usr = usr;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getFehcadenacimiento() {
        return fehcadenacimiento;
    }

    public void setFehcadenacimiento(String fehcadenacimiento) {
        this.fehcadenacimiento = fehcadenacimiento;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.apellidoPaterno);
        hash = 29 * hash + Objects.hashCode(this.apellidoMaterno);
        hash = 29 * hash + Objects.hashCode(this.fehcadenacimiento);
        hash = 29 * hash + Objects.hashCode(this.usr);
        hash = 29 * hash + Objects.hashCode(this.contrasena);
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
        final Clientes other = (Clientes) obj;
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
