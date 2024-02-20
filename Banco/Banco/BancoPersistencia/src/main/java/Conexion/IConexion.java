/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Jesus Alberto Morales Rojas - 245335, Ximena Oliva Andrade - 247563
 *
 * La interfaz IConexion define un contrato para la creación de conexiones a
 * una base de datos. Las clases que implementen esta interfaz deben
 * proporcionar una implementación del método crearConexion(), el cual devuelve
 * una conexión a la base de datos.
 */
public interface IConexion {

    /**
     * Crea y devuelve una conexión a la base de datos.
     * 
     * @return Una conexión a la base de datos.
     * @throws SQLException Si ocurre un error al intentar establecer la conexión.
     */
    public Connection crearConexion() throws SQLException;
}
