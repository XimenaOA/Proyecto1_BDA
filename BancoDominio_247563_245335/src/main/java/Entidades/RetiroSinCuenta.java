/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Objects;

/**
 *
 * @author lv1821
 */
public class RetiroSinCuenta {
    int idCliente, folio;
    String contraseña;

    public RetiroSinCuenta() {
    }

    public RetiroSinCuenta(int idCliente, int folio, String contraseña) {
        this.idCliente = idCliente;
        this.folio = folio;
        this.contraseña = contraseña;
    }

    public RetiroSinCuenta(int folio, String contraseña) {
        this.folio = folio;
        this.contraseña = contraseña;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idCliente;
        hash = 97 * hash + this.folio;
        hash = 97 * hash + Objects.hashCode(this.contraseña);
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
        final RetiroSinCuenta other = (RetiroSinCuenta) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (this.folio != other.folio) {
            return false;
        }
        return Objects.equals(this.contraseña, other.contraseña);
    }

    @Override
    public String toString() {
        return "RetiroSinCuenta{" + "idCliente=" + idCliente + ", folio=" + folio + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
    
}
