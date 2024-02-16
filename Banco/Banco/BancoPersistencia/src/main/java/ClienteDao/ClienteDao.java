/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteDao;

import ClienteDto.ClienteDto;
import ClienteDto.DomicilioDto;
import Conexion.Conexion;
import Conexion.IConexion;
import Dominio.Clientes;
import Dominio.Domicilio;
//import Dominio.Movimientos;
import Excepciones.PersistenciaExcepcion;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    private String idCliente = "", nombre = "", apellidoPaterno = "", apellidoMaterno = "", edad = "", fechaDeNacimiento = "", usr = "", contrasena = "";

    private static final Logger LOG = Logger.getLogger(Connection.class.getName());

    public ClienteDao(IConexion con) {
        this.con = con;
    }

//    @Override
//    public List<Movimientos> historial(ClienteDto cli) throws PersistenciaExcepcion {
//        List<Movimientos> lisHis = new ArrayList<>();
//
//        String sentencia = String.format("select m.tipo as TipoMovimiento,c.numeroDeCuenta as Cuenta,m.fecha as Fecha,m.saldo as Saldo from Movimientos m inner join Cuentas c on m.idcuenta = c.idCuenta inner join Clientes cl on c.idcliente = cl.idCliente where cl.idCliente ='%d' order by m.fecha desc", cli.getId());
//
//        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {
//
//            ResultSet res = comandoSQL.executeQuery(sentencia);
//
//            while (res.next()) {
//
//                Movimientos mov = new Movimientos(res.getString("TipoMovimiento"), res.getString("fecha"), res.getDouble("saldo"), res.getInt("Cuenta"));
//
//                lisHis.add(mov);
//            }
//
//            return lisHis;
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
//        }
//        return null;
//
//    }
//
    public String encriptar(String contra) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(contra.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte hashByte : hashBytes) {
            String hex = Integer.toHexString(0xff & hashByte);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString().substring(0, Math.min(hexString.length(), 70));
    }

    @Override
    public boolean registrarUsuario(ClienteDto cliente, DomicilioDto dom) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNacimiento = LocalDate.parse(cliente.getFehcadenacimiento(), formatoFecha);
        LocalDate hoy = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, hoy);
        String edad = String.valueOf(periodo.getYears());

        if (periodo.getYears() > 100) {
            return false;
        }
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
    public Clientes login(String usr, String contrasenia) throws PersistenciaExcepcion {
            String sentenciaSQL = "SELECT * FROM Clientes WHERE usr = ? AND contrasena = ?";

            
            try {
                String contra = encriptar(contrasenia);

                try (Connection conexion = this.con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {
                    comandoSQL.setString(1, usr);
                    comandoSQL.setString(2, contra);

                    try (ResultSet res = comandoSQL.executeQuery()) {
                        if (res.next()) {
                            return new Clientes(res.getInt("idCliente"), res.getString("nombre"),
                                    res.getString("apellidopaterno"), res.getString("apellidomaterno"),
                                    res.getString("fechaDeNacimiento"), res.getString("usr"), res.getString("contrasena"));
                        }
                    }
                }
            } catch (SQLException e) {
                LOG.log(Level.SEVERE, "No se pudo iniciar sesión", e);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;

        }

        @Override
        public boolean transeferencia
        (int cuenta1, double MontoCuenta1, double saldo, double MontoCuenta2, int cuenta2) throws PersistenciaExcepcion {
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

        @Override
        public List<String> ConsultarCuentas
        (int id) throws PersistenciaExcepcion {
            List<String> listC = new ArrayList<>();
            String sentencia = String.format("select numeroDeCuenta from Cuentas c join Clientes cl on c.idcliente = cl.idCliente where cl.idCliente='%d'", id);

            try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

                ResultSet res = comandoSQL.executeQuery(sentencia);

                while (res.next()) {
                    String cuenta = res.getString("numeroDeCuenta");
                    listC.add(cuenta);
                }

                return listC;
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            return listC;
        }

    }
