/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteDao;

import ClienteDto.ClienteDto;
import ClienteDto.CuentaDto;
import ClienteDto.DomicilioDto;
import ClienteDto.RetiroDTO;
import ClienteDto.TransferenciasDto;
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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
            return null;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public Transferencias transeferencia(TransferenciasDto trans) throws PersistenciaExcepcion {
        String sentencia = ("call transferencia(?, ?, ?);");

        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

            comandoSQL.setLong(01, trans.getRemitente());
            comandoSQL.setLong(02, trans.getDestinatario());
            comandoSQL.setDouble(03, trans.getConcepto());

            ResultSet res = comandoSQL.executeQuery();

            Transferencias transferencia = new Transferencias(trans.getTipo(), trans.getConcepto(), trans.getRemitente(), trans.getDestinatario(), trans.getFechaDeTransferencia(), trans.getIdCuenta());

            return transferencia;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
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
                long numCuenta = res.getLong("numeroDeCuenta");
                String fecha = res.getString("fechaApertura");
                double saldo = res.getInt("monto");
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
                long destinatario = res.getLong("destinatario");
                String fecha = res.getString("fechaDeTrasferencia");
                long cuen = res.getLong("numeroDeCuenta");
                Transferencias trans = new Transferencias("Transferencia", monto, cuen, destinatario, fecha, id);
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
        String sentencia = String.format("select *,\"Retiro\" as tipo from retiroSinCuentea r join Cuentas cl on r.idCuenta = cl.idCuenta where cl.idCliente=1 and r.estado=\"Activo\"", id);

        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

            ResultSet res = comandoSQL.executeQuery(sentencia);

            while (res.next()) {
                double monto = res.getDouble("monto");
                Timestamp fecha = res.getTimestamp("fecha");
                LocalDateTime fecha2 = fecha.toLocalDateTime();
                int cuen = res.getInt("numeroDeCuenta");
                long numC = res.getLong("cuenta");
                Retiros ret = new Retiros("Retiro", numC, monto, fecha2, cuen);
                listR.add(ret);
            }

            return listR;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return listR;
    }

    @Override
    public void deposito(long numCuenta, double monto) throws PersistenciaExcepcion {
        double saldo = this.consultarSaldo(numCuenta);
        double saldoTotal = saldo + monto;
        String sentencia = "update Cuentas set monto=? where numeroDeCuenta=?;";
        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

            comandoSQL.setDouble(01, saldoTotal);
            comandoSQL.setLong(02, numCuenta);

            int res = comandoSQL.executeUpdate();

            if (res > 0) {
                LOG.log(Level.SEVERE, "Se pudo depositar");

            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo depositar", e);
        }
    }

    @Override
    public double consultarSaldo(long numCuenta) throws PersistenciaExcepcion {
        String sentencia = "SELECT monto FROM Cuentas WHERE numeroDeCuenta = ?";
        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

            comandoSQL.setLong(1, numCuenta);

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
            comandoSQL.setLong(3, cuenta.getNumeroDeCuenta());
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
    public boolean eliminarCuenta(long numCuenta) throws PersistenciaExcepcion {
        String sentenciaSQL = "DELETE FROM Cuentas WHERE numeroDeCuenta = ?";

        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL)) {
            comandoSQL.setLong(1, numCuenta);

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
        String sentenciaSQL = "INSERT INTO retiroSinCuentea (Folio, estado, contrasena, monto, fecha, idCuenta,cuenta)\n" + "VALUES (?, ?, ?, ?, ?, ?,?)";
        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL)) {
            comandoSQL.setLong(1, retiro.getFolio());
            comandoSQL.setString(2, "Espera");

            String contra = this.encriptar(String.valueOf(retiro.getContrasena()));
            comandoSQL.setString(3, contra);
            comandoSQL.setDouble(4, retiro.getMonto());

            comandoSQL.setTimestamp(5, java.sql.Timestamp.valueOf(retiro.getFecha()));
            comandoSQL.setInt(6, retiro.getIdCuenta());
            comandoSQL.setLong(7, retiro.getNumCuenta());

            int res = comandoSQL.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public long generarFolio() {
        long min = 1000000000L;
        long max = 9999999999L;
        return min + (long) (Math.random() * (max - min + 1));
    }

    @Override
    public int generarContra() {

        int min = 10000000;
        int max = 99999999;
        return min + (int) (Math.random() * (max - min + 1));
    }

    @Override
    public Cuentas ConsultarCuenta(int id) throws PersistenciaExcepcion {
        Cuentas cuenta;
        String sentencia = String.format("select * from Cuentas where idCuenta='%d'", id);
        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

            ResultSet res = comandoSQL.executeQuery(sentencia);

            long numCuenta = res.getLong("numeroDeCuenta");
            String fecha = res.getString("fechaApertura");
            double saldo = res.getInt("monto");
            cuenta = new Cuentas(numCuenta, fecha, saldo, id);

            return cuenta;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;

    }

    @Override
    public Cuentas ConsultarCuenta(long numCue) throws PersistenciaExcepcion {
        Cuentas cuenta = null;
        String sentencia = "SELECT * FROM Cuentas WHERE numeroDeCuenta = ?";
        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia)) {

            comandoSQL.setLong(1, numCue);
            ResultSet res = comandoSQL.executeQuery();

            if (res.next()) { // Comprueba si hay al menos una fila de resultados
                double saldo = res.getDouble("monto");
                long numCuenta = res.getLong("numeroDeCuenta");
                String fecha = res.getString("fechaApertura");
                int idCuenta = res.getInt("idCuenta");

                cuenta = new Cuentas(numCuenta, fecha, saldo, idCuenta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            throw new PersistenciaExcepcion("Error al consultar la cuenta: " + ex.getMessage());
        }
        return cuenta;

    }

    @Override
    public void modificarCliente(ClienteDto cliente, DomicilioDto dom) throws PersistenciaExcepcion {

        String sentencia;

        if (!cliente.getContrasena().equals("")) {
            sentencia = "UPDATE Clientes SET nombre=?, apellidopaterno=?, apellidomaterno=?, contrasena=? WHERE idCliente=?";

            try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

                comandoSQL.setString(1, cliente.getNombre());
                comandoSQL.setString(2, cliente.getApellidoPaterno());
                comandoSQL.setString(3, cliente.getApellidoMaterno());
                comandoSQL.setString(4, cliente.getContrasena());
                comandoSQL.setInt(5, cliente.getId());

                comandoSQL.executeUpdate();

                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, "Se actualizo el clinte");

            } catch (SQLException ex) {
                throw new PersistenciaExcepcion("Error al modificar el cliente: " + ex.getMessage());
            }
        } else {
            sentencia = "UPDATE Clientes SET nombre=?, apellidopaterno=?, apellidomaterno=? WHERE idCliente=?";

            try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

                comandoSQL.setString(1, cliente.getNombre());
                comandoSQL.setString(2, cliente.getApellidoPaterno());
                comandoSQL.setString(3, cliente.getApellidoMaterno());
                comandoSQL.setInt(4, cliente.getId());

                comandoSQL.executeUpdate();

                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, "Se actualizo el clinte");

            } catch (SQLException ex) {
                throw new PersistenciaExcepcion("Error al modificar el cliente: " + ex.getMessage());
            }
        }

        sentencia = "UPDATE Domicilios SET colonia=?, calle=?, numero=? WHERE idcliente=?";

        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

            comandoSQL.setString(1, dom.getColonia());
            comandoSQL.setString(2, dom.getCalle());
            comandoSQL.setInt(3, dom.getNumero());
            comandoSQL.setInt(4, cliente.getId());

            int filasAfectadas = comandoSQL.executeUpdate();

            if (filasAfectadas == 0) {
                throw new PersistenciaExcepcion("No se pudo modificar el domicilio, ID no encontrado.");
            }

        } catch (SQLException ex) {
            throw new PersistenciaExcepcion("Error al modificar el domicilio: " + ex.getMessage());
        }

    }

    @Override
    public Clientes consultarCliente(int id) throws PersistenciaExcepcion {

        String sentencia = String.format("SELECT * FROM Clientes WHERE idCliente='%d'", id);

        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

            ResultSet res = comandoSQL.executeQuery(sentencia);

            if (res.next()) {
                Clientes clienteConsultado = new Clientes();
                clienteConsultado.setId(res.getInt("idCliente"));
                clienteConsultado.setNombre(res.getString("nombre"));
                clienteConsultado.setApellidoPaterno(res.getString("apellidopaterno"));
                clienteConsultado.setApellidoMaterno(res.getString("apellidomaterno"));
                clienteConsultado.setFehcadenacimiento(res.getString("fechaDeNacimiento"));
                clienteConsultado.setUsr(res.getString("usr"));
                clienteConsultado.setContrasena(res.getString("contrasena"));

                return clienteConsultado;
            } else {
                throw new PersistenciaExcepcion("No se encontró ningún cliente con el ID especificado.");
            }

        } catch (SQLException ex) {
            throw new PersistenciaExcepcion("Error al consultar el cliente: " + ex.getMessage());
        }
    }

    public Domicilio consultarDomicilio(int id) throws PersistenciaExcepcion {
        Domicilio dom;

        String sentencia = String.format("SELECT * FROM Domicilios WHERE idcliente='%d'", id);

        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

            ResultSet res = comandoSQL.executeQuery(sentencia);

            dom = new Domicilio();
            dom.setIdDomicilio(res.getInt("idDomicilio"));
            dom.setColonia(res.getString("colonia"));
            dom.setCalle(res.getString("calle"));
            dom.setNumero(res.getInt("numero"));
            dom.setIdCliente(res.getInt("idcliente"));

            return dom;

        } catch (SQLException ex) {
            throw new PersistenciaExcepcion("Error al consultar los domicilios del cliente: " + ex.getMessage());
        }
    }

    @Override
    public Retiros validarRetiros(RetiroDTO retiro) throws PersistenciaExcepcion {
        Retiros ret = new Retiros("121");

        String sentenciaSQL = "update retiroSinCuentea set monto = ? where folio=?";
        String sentenciaSQL2 = "select * from retirosincuentea where folio = ?";
        String sentenciaSQL3 = "update retiroSinCuentea set estado='Activo', monto=? where folio=?";

        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL); PreparedStatement comandoSQL2 = conexion.prepareStatement(sentenciaSQL2); PreparedStatement comandoSQL3 = conexion.prepareStatement(sentenciaSQL3)) {

            comandoSQL.setDouble(1, retiro.getMonto());
            comandoSQL.setLong(2, retiro.getFolio());

            int res = comandoSQL.executeUpdate();

            comandoSQL2.setLong(1, retiro.getFolio());
            
            ResultSet res2 = comandoSQL2.executeQuery();

            
            if (res2.next()) {
                if (res2.getString("estado").equals("Cancelado")) {
                    return new Retiros("510");
                } else {
                    Timestamp fecha = res2.getTimestamp("fecha");
                    LocalDateTime fecha2 = fecha.toLocalDateTime();
                    Retiros rere = new Retiros("Retiro", res2.getLong("cuenta"), res2.getLong("Folio"), res2.getString("estado"), res2.getString("contrasena"), res2.getDouble("monto"), fecha2, res2.getInt("idCuenta"));
                    
                    String contrasenaRetiro = res2.getString("contrasena");
                    
                    if (this.encriptar(String.valueOf(retiro.getContrasena())).equals(contrasenaRetiro)) {
                        double retirado = rere.getMonto();
                        double saldo = this.consultarSaldo(res2.getLong("cuenta"));
                        double total = saldo - retirado;

                        comandoSQL3.setDouble(1, total);
                        comandoSQL3.setLong(2, retiro.getFolio());
                        int res3 = comandoSQL3.executeUpdate();

                        Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, "se ah validado");

                        return rere;
                    } else {
                        return new Retiros("320");
                    }
                }
            } else {
                return ret;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Retiros ConsultarUnRetiro(int id) throws PersistenciaExcepcion {
        Retiros retiro = new Retiros();
        String sentencia = String.format("select * from restioSinCuentea where folio = ?", id);

        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

            ResultSet res = comandoSQL.executeQuery(sentencia);
            double monto = res.getDouble("monto");
            String tipo = res.getString("Retiro");
            LocalDateTime fecha2 = LocalDateTime.now();
            int cuen = res.getInt("numeroDeCuenta");
            long numC = res.getLong("cuenta");
            Retiros ret = new Retiros("Retiro", numC, monto, fecha2, cuen);

            return retiro;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return retiro;
    }

}
