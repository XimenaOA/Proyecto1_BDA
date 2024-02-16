/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteDao;

import ClienteDto.ClienteDto;
import ClienteDto.DomicilioDto;
import Conexion.IConexion;
import Dominio.Clientes;
import Dominio.Domicilio;
import Dominio.Movimientos;
import Excepciones.PersistenciaExcepcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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

    public String Retiro(Movimientos mov) throws PersistenciaExcepcion {
//        String sentenciaSQL = "select * from Movimientos where idMovimiento= ?";
//
//        String sentenciaSQL2 = "select * from Cuentas where idCuenta= ?";
//
//        try (Connection conexion = this.con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL); PreparedStatement comandoSQL2 = conexion.prepareStatement(sentenciaSQL2);) {
//
//            comandoSQL.setInt(01, mov.getIdMovimiento());
//
//            ResultSet res = comandoSQL.executeQuery(sentenciaSQL);
//
//            res.next();
//
//            comandoSQL2.setInt(01, res.getInt("idCuenta"));
//
//            ResultSet res2 = comandoSQL2.executeQuery(sentenciaSQL2);
//
////            double SaldoARestar = res.getDouble("saldo");
////            double SaldoCuenta = res2.getInt("saldo");
////            
////            SaldoCuenta-=SaldoARestar;
//            return null;
//
//        } catch (SQLException e) {
//            LOG.log(Level.SEVERE, "No se puede consultar el activista", e);
//            throw new PersistenciaExcepcion("No se puede consultar el activista", e);
//        }
        return null;
    }

    @Override
    public boolean registrarUsuario(ClienteDto cliente, DomicilioDto dom) throws PersistenciaExcepcion {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNacimiento = LocalDate.parse(cliente.getFehcadenacimiento(), formatoFecha);
        LocalDate hoy = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, hoy);
        String edad = String.valueOf(periodo.getYears());

        String sentenciaSQL = "call agregaC(?,?,?,?,?,?,?,?,?,?)";

        try (Connection conexion = this.con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoPaterno());
            comandoSQL.setString(3, cliente.getApellidoMaterno());
            comandoSQL.setString(4, cliente.getFehcadenacimiento());
            comandoSQL.setString(5, edad);
            comandoSQL.setString(6, cliente.getUsr());
            comandoSQL.setString(7, cliente.getContrasena());
            comandoSQL.setInt(10, dom.getNumero());
            comandoSQL.setString(8, dom.getColonia());
            comandoSQL.setString(9, dom.getCalle());

            int res = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "Se ha registrado el usuario", res);
            return true;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo registrar", e);
        }
        return false;
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

    @Override
    public boolean transeferencia(int cuenta1, double MontoCuenta1, double saldo, double MontoCuenta2, int cuenta2) throws PersistenciaExcepcion {
        String sentencia = ("call transferencia(?, ?, ?, ?, ?);");

        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

            comandoSQL.setInt(01, cuenta1);
            comandoSQL.setDouble(02, MontoCuenta1);
            comandoSQL.setDouble(03, saldo);
            comandoSQL.setDouble(04, MontoCuenta2);
            comandoSQL.setInt(05, cuenta2);

            ResultSet res = comandoSQL.executeQuery(sentencia);

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }

}
