/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteDao;

import ClienteDto.ClienteDto;
import ClienteDto.CuentaDto;
import ClienteDto.DomicilioDto;
import ClienteDto.RetiroDTO;
import Conexion.Conexion;
import Conexion.IConexion;
import Dominio.Clientes;
import Dominio.Cuentas;
import Dominio.Domicilio;
import Dominio.Retiros;
import Dominio.Transferencias;
//import Dominio.Movimientos;
import Excepciones.PersistenciaExcepcion;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
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

        return hexString.toString().substring(0, Math.min(hexString.length(), 10));
    }

    @Override
    public Clientes registrarUsuario(ClienteDto cliente, DomicilioDto dom) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNacimiento = LocalDate.parse(cliente.getFehcadenacimiento(), formatoFecha);
        LocalDate hoy = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, hoy);
        String edad = String.valueOf(periodo.getYears());

        if (periodo.getYears() > 100) {
            return null;
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

            Clientes cli = new Clientes(cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getFehcadenacimiento());
            int res = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "Se ha registrado el usuario", res);
            return cli;

        } catch (SQLException e) {

            LOG.log(Level.SEVERE, "No se pudo registrar", e);
        }
        return null;
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

    @Override
    public List<String> ConsultarNumeroCuentas(int id) throws PersistenciaExcepcion {
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

    @Override
    public List<Cuentas> ConsultarCuentas(int id) throws PersistenciaExcepcion {
        List<Cuentas> listC = new ArrayList<>();
        String sentencia = String.format("select * from Cuentas c join Clientes cl on c.idcliente = cl.idCliente where cl.idCliente='%d'", id);

        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

            ResultSet res = comandoSQL.executeQuery(sentencia);

            while (res.next()) {
                int numCuenta = res.getInt("numeroDeCuenta");
                String fecha = res.getString("fechaApertura");
                int saldo = res.getInt("monto");
                Cuentas cuenta = new Cuentas(numCuenta, fecha, saldo, id);
                listC.add(cuenta);
            }

            return listC;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return listC;
    }

    @Override
    public List<Transferencias> ConsultarTransferencias(int id) throws PersistenciaExcepcion {
        List<Transferencias> listT = new ArrayList<>();
        String sentencia = String.format("select * from transferencias t join Cuentas cl on t.idCuenta = cl.idCuenta where cl.idCliente='%d'", id);

        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

            ResultSet res = comandoSQL.executeQuery(sentencia);

            while (res.next()) {
                double monto = res.getDouble("monto");
                int destinatario = res.getInt("destinatario");
                String fecha = res.getString("fechaDeTrasferencia");
                int cuen = res.getInt("numeroDeCuenta");
                Transferencias trans = new Transferencias(monto, destinatario, fecha, cuen);
                listT.add(trans);
            }

            return listT;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return listT;
    }

    @Override
    public List<Retiros> ConsultarRetiros(int id) throws PersistenciaExcepcion {
        List<Retiros> listR = new ArrayList<>();
        String sentencia = String.format("select *, \"Retiros\" as Retiro from retiroSinCuentea r join Cuentas cl on r.idCuenta = cl.idCuenta where cl.idCliente='%d'", id);

        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

            ResultSet res = comandoSQL.executeQuery(sentencia);

            while (res.next()) {
                double monto = res.getDouble("monto");
                String tipo = res.getString("Retiro");
                Date fecha = res.getDate("fecha");
                int cuen = res.getInt("numeroDeCuenta");
                Retiros ret = new Retiros(tipo, monto, fecha, cuen);
                listR.add(ret);
            }

            return listR;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return listR;
    }

    @Override
    public void deposito(int numCuenta, double monto) throws PersistenciaExcepcion {
        double saldo = this.consultarSaldo(numCuenta);
        double saldoTotal = saldo + monto;
        String sentencia = "update Cuentas set monto=? where numeroDeCuenta=?;";
        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

            comandoSQL.setDouble(01, saldoTotal);
            comandoSQL.setInt(02, numCuenta);

            int res = comandoSQL.executeUpdate();

            if (res > 0) {
                LOG.log(Level.SEVERE, "Se pudo depositar");

            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo depositar", e);
        }
    }

    @Override
    public double consultarSaldo(int numCuenta) throws PersistenciaExcepcion {
        String sentencia = "SELECT monto FROM Cuentas WHERE numeroDeCuenta = ?";
        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

            comandoSQL.setInt(1, numCuenta);

            ResultSet res = comandoSQL.executeQuery();

            if (res.next()) {
                double monto = res.getDouble("monto");
                return monto;
            } else {
                throw new RuntimeException("La cuenta no existe.");
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo consultar", e);
        }
        return 0;
    }

    @Override
    public Cuentas agregarCuenta(CuentaDto cuenta) throws PersistenciaExcepcion {
        String sentencia = "INSERT INTO Cuentas (fechaApertura, monto, numeroDeCuenta, estado, idcliente) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {
            comandoSQL.setString(1, cuenta.getFechaApertura());
            comandoSQL.setDouble(2, cuenta.getSaldo());
            comandoSQL.setString(3, String.valueOf(cuenta.getNumeroDeCuenta()));
            comandoSQL.setString(4, "Activo");
            comandoSQL.setInt(5, cuenta.getIdCliente());

            Cuentas cuentas = new Cuentas(cuenta.getNumeroDeCuenta(), cuenta.getFechaApertura(), cuenta.getSaldo(), cuenta.getIdCliente());
            int res = comandoSQL.executeUpdate();

            if (res > 0) {
                LOG.log(Level.INFO, "Cuenta agregada exitosamente");
                return cuentas;
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo agregar la cuenta", e);
        }
        return null;
    }

    @Override
    public boolean eliminarCuenta(int numCuenta) throws PersistenciaExcepcion {
        String sentenciaSQL = "DELETE FROM Cuentas WHERE numeroDeCuenta = ?";

        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL)) {
            comandoSQL.setInt(1, numCuenta);

            int res = comandoSQL.executeUpdate();

            if (res > 0) {
                LOG.log(Level.INFO, "Cuenta eliminada exitosamente");
                return true;
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo eliminar la cuenta", e);
        }
        return false;
    }

    @Override
    public boolean retiroSinCuenta(RetiroDTO retiro) throws PersistenciaExcepcion {
     String sentenciaSQL = "INSERT INTO retiroSinCuentea (Folio, estado, contrasena, monto, fecha, idCuenta)\n"  + "VALUES (?, ?, ?, ?, ?, ?)";
       try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL)) {
            comandoSQL.setLong(1, retiro.getFolio());
            comandoSQL.setString(2, retiro.getEstado());
            comandoSQL.setString(3, retiro.getContrasena());
            comandoSQL.setDouble(4, retiro.getMonto());
            comandoSQL.setDate(5, (Date) retiro.getFecha());
            comandoSQL.setInt(6, retiro.getIdCuenta());
            

            int res = comandoSQL.executeUpdate();

            if (res > 0) {
                LOG.log(Level.INFO, "Cuenta eliminada exitosamente");
                return true;
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo eliminar la cuenta", e);
        }
           
    }
    
    public long generarFolio() {
        long min = 1000000000L;
        long max = 9999999999L;
        return min + (long) (Math.random() * (max - min + 1));
    }

     public int generarContra(){
    
        int min = 10000000;
        int max = 99999999;
        return min + (int) (Math.random() * (max - min + 1));
    }
}
