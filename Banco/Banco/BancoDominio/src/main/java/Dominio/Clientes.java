package Dominio;

import java.util.Objects;

public class Clientes {

    int id;
    String nombre, apellidoPaterno, apellidoMaterno, fehcadenacimiento, usr, contrasena;
    

    public Clientes() {
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

    
}
