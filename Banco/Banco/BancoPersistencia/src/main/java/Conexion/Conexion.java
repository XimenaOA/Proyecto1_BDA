/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus Morales
 */
public class Conexion implements IConexion{
    private static final Logger LOG = Logger.getLogger(Conexion.class.getName());
    
    private String url;
    private String usuario;
    private String contraseña;

    public Conexion(String url, String usuario, String contraseña) {
        this.url = url;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Conexion() {
    }
    
    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            LOG.log(Level.INFO, "Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al obtener la conexión a la base de datos", e);
            throw e; // Puedes relanzar la excepción si lo deseas
        }
        return conexion;
    }
}
