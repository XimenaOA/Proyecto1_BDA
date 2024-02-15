/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteDao;

import ClienteDto.ClienteDto;
import Conexion.IConexion;
import Dominio.Clientes;
import Dominio.Movimientos;
import Excepciones.PersistenciaExcepcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus
 */
public class ClienteDao implements iCliente {

    final IConexion con;

    private static final Logger LOG = Logger.getLogger(Connection.class.getName());

    public ClienteDao(IConexion con) {
        this.con = con;
    }

    @Override
    public String Retiro(Movimientos mov) throws PersistenciaExcepcion {
        String sentenciaSQL = "select * from Movimientos where idMovimiento= ?";

        String sentenciaSQL2 = "select * from Cuentas where idCuenta= ?";

        try (Connection conexion = this.con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL); PreparedStatement comandoSQL2 = conexion.prepareStatement(sentenciaSQL2);) {

            comandoSQL.setInt(01, mov.getIdMovimiento());

            ResultSet res = comandoSQL.executeQuery(sentenciaSQL);

            res.next();

            comandoSQL2.setInt(01, res.getInt("idCuenta"));

            ResultSet res2 = comandoSQL2.executeQuery(sentenciaSQL2);

//            double SaldoARestar = res.getDouble("saldo");
//            double SaldoCuenta = res2.getInt("saldo");
//            
//            SaldoCuenta-=SaldoARestar;
            return null;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se puede consultar el activista", e);
            throw new PersistenciaExcepcion("No se puede consultar el activista", e);
        }
    }

    /**
     * Metodo que funciona como timer o cronometro no se como se diga de 10
     * minutos
     */
    public boolean ejecutarTimer(Connection conexion, int idC ,double saldo) {
        //creo un hilo
        new Thread(new Runnable() {
            //hago un metodo en el hilo qye va a ser donde empieze el timer
            @Override
            public void run() {
                //declaro la variable como long por lo larga de la info
                //otra, estoy llamando al sistema para que me de los milisegundos exactos
                long empieza = System.currentTimeMillis();
                /**
                 * en este ciclo pasan un par de cosas, primero revisamos los
                 * milisegundos actuales y le los restamos nuestra variable
                 * long, cuando empieze es obio que de 0, pero con forme se
                 * repita el ciclo la cantidad que nos de el sistema va ir
                 * aumentando y esto va a ocurrir hasta que la resta sea mayor o
                 * igual a 600000 mili segundos que son 600 segundos y 600
                 * segundos son 10 minutos :D
                 */
                while (System.currentTimeMillis() - empieza <= 600000) {
                    try {
                        //dormimos el hilo 1 segundo para que no el tiempo pase y el ciclo siga su rumbo
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            //ya aquí solo empezamos el hilo
        }).start();
        
        return true;
    }

    @Override
    public void registrarUsuario(Clientes cliente) throws PersistenciaExcepcion {
       String query = "insert into clientes(id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, usr, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?))";
        try (Connection conexion = this.con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);){
            comandoSQL.setString(1, cliente.getUsr());
            comandoSQL.setString(2, cliente.getContrasena());
            comandoSQL.setString(3, cliente.getNombre());
            comandoSQL.setString(4, cliente.getApellidoPaterno());
            comandoSQL.setString(5, cliente.getApellidoMaterno());
            comandoSQL.setString(6, cliente.getFehcadenacimiento());
            
            int res = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se ha registrado el usuario", res);        
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo registrar", e);
        }
    }

    @Override
    public boolean login(String usr, String contrasenia) throws PersistenciaExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}
