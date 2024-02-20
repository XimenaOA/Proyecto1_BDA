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
 * La clase Conexion implementa la interfaz IConexion y proporciona métodos
 * para establecer una conexión a una base de datos utilizando JDBC.
 *
 * @author Jesus Alberto Morales Rojas - 245335, Ximena Oliva Andrade - 247563
 *
 */
public class Conexion implements IConexion {

    //Atributos de la clase
    private static final Logger LOG = Logger.getLogger(Conexion.class.getName());
    private String url;
    private String usuario;
    private String contraseña;

    /**
     * Constructor de la clase Conexion.
     *
     * @param url La URL de la base de datos.
     * @param usuario El nombre de usuario para la conexión a la base de datos.
     * @param contraseña La contraseña para la conexión a la base de datos.
     */
    public Conexion(String url, String usuario, String contraseña) {
        this.url = url;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    /**
     * Constructor vacío de la clase Conexion.
     */
    public Conexion() {
    }

    /**
     * Crea y devuelve una conexión a la base de datos.
     *
     * @return Una conexión a la base de datos.
     * @throws SQLException Si ocurre un error al intentar establecer la
     * conexión.
     */
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
