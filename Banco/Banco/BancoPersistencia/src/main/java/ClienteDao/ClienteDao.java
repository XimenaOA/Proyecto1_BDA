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
    public List<Movimientos> historial(ClienteDto cli) throws PersistenciaExcepcion {
        List<Movimientos> lisHis = new ArrayList<>();

        String sentencia = String.format("select m.tipo as TipoMovimiento,c.numeroDeCuenta as Cuenta,m.fecha as Fecha,m.saldo as Saldo from Movimientos m inner join Cuentas c on m.idcuenta = c.idCuenta inner join Clientes cl on c.idcliente = cl.idCliente where cl.idCliente ='%d' order by m.fecha desc", cli.getId());

        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

            ResultSet res = comandoSQL.executeQuery(sentencia);

            while (res.next()) {

                Movimientos mov = new Movimientos(res.getString("TipoMovimiento"), res.getString("fecha"), res.getDouble("saldo"), res.getInt("Cuenta"));

                lisHis.add(mov);
            }

            return lisHis;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }

    @Override
    public void registrarUsuario(Clientes cliente) throws PersistenciaExcepcion {
        String sentenciaSQL = "insert into clientes(id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, usr, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?))";
        try (Connection conexion = this.con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
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
        String sentenciaSQL = "SELECT usr, contrasena  FROM Clientes WHERE usr = ? AND contrasena = ?";
        try (Connection conexion = this.con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, usr);
            comandoSQL.setString(2, contrasenia);
            ResultSet res = comandoSQL.executeQuery();
            if (res.next()) {

            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo iniciar sesión", e);
            return false;
        }
        return false;
    }
}
