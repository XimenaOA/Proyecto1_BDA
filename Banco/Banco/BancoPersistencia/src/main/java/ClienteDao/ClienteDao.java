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
 * Interfaz que contiene los métodos para controlar la información de un cliente y 
 * sus distintos movimientos para realizar un caso de uso
 * 
 * @author Jesús Alberto Morales Rojas - 245335, Ximena Oliva Andrade - 247563
 */
public class ClienteDao implements iCliente {

    final IConexion con;

    private static final Logger LOG = Logger.getLogger(Connection.class.getName());

    /**
     * Constructor de la clase ClienteDao.
     *
     * @param con La interfaz de conexión a utilizar.
     */
    public ClienteDao(IConexion con) {
        this.con = con;
    }

    /**
     * Método para encriptar una contraseña utilizando el algoritmo SHA-256.
     *
     * @param contra La contraseña a encriptar.
     * @return La contraseña encriptada.
     * @throws NoSuchAlgorithmException Si no se encuentra el algoritmo de
     * encriptación.
     */
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

    /**
     * Registra un nuevo usuario en el sistema junto con su domicilio.
     *
     * @param cliente El DTO del cliente a registrar.
     * @param dom El DTO del domicilio del cliente.
     * @return El cliente registrado.
     */
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

    /**
     * Permite a un usuario iniciar sesión en el sistema.
     *
     * @param usr El nombre de usuario.
     * @param contrasenia La contraseña del usuario.
     * @return El cliente que ha iniciado sesión.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
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

    /**
     * Realiza una transferencia de fondos entre dos cuentas.
     *
     * @param trans El DTO de la transferencia a realizar.
     * @return La transferencia realizada.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
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

    /**
     * Consulta el número de cuentas asociadas a un cliente.
     *
     * @param id El ID del cliente.
     * @return Una lista de números de cuentas asociadas al cliente.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
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

    /**
     * Consulta las cuentas asociadas a un cliente.
     *
     * @param id El ID del cliente.
     * @return Una lista de cuentas asociadas al cliente.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
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

    /**
     * Realiza un depósito en una cuenta específica.
     *
     * @param numCuenta El número de cuenta en la que se realizará el depósito.
     * @param monto El monto a depositar.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
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

    /**
     * Consulta los retiros asociados a un cliente específico.
     *
     * @param id El ID del cliente.
     * @return Una lista de retiros realizados por el cliente.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
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

    /**
     * Consulta el saldo de una cuenta específica.
     *
     * @param numCuenta El número de cuenta.
     * @return El saldo de la cuenta.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
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

    /**
     * Agrega una nueva cuenta a la base de datos.
     *
     * @param cuenta El DTO de la cuenta a agregar.
     * @return La cuenta agregada.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
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

    /**
     * Elimina una cuenta de la base de datos.
     *
     * @param numCuenta El número de cuenta a eliminar.
     * @return true si la cuenta fue eliminada con éxito, false en caso
     * contrario.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
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

    /**
     * Registra un retiro sin asociarlo a una cuenta.
     *
     * @param retiro El DTO del retiro.
     * @return true si el retiro sin cuenta se registró con éxito, false en caso
     * contrario.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
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

    /**
     * Genera un folio aleatorio para identificar una transacción.
     *
     * @return El folio generado.
     */
    @Override
    public long generarFolio() {
        long min = 1000000000L;
        long max = 9999999999L;
        return min + (long) (Math.random() * (max - min + 1));
    }

    /**
     * Genera una contraseña aleatoria para una transacción.
     *
     * @return La contraseña generada.
     */
    @Override
    public int generarContra() {

        int min = 10000000;
        int max = 99999999;
        return min + (int) (Math.random() * (max - min + 1));
    }

    /**
     * Consulta una cuenta en la base de datos por su ID.
     *
     * @param id El ID de la cuenta.
     * @return La cuenta consultada.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
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

    /**
     * Consulta una cuenta en la base de datos por su número de cuenta.
     *
     * @param numCue El número de cuenta a consultar.
     * @return La cuenta consultada.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
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

    /**
     * Modifica los datos de un cliente y su domicilio en la base de datos.
     *
     * @param cliente El DTO del cliente con los datos modificados.
     * @param dom El DTO del domicilio con los datos modificados.
     * @return true si se modificaron los datos con éxito, false en caso
     * contrario.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    @Override
    public boolean modificarCliente(ClienteDto cliente, DomicilioDto dom) throws PersistenciaExcepcion {
        String sentenciaCliente;
        String sentenciaDomicilio;
        Connection conexion = null;
        PreparedStatement comandoSQL = null;

        try {
            conexion = con.crearConexion();

            sentenciaCliente = "UPDATE Clientes SET nombre=?, apellidopaterno=?, apellidomaterno=?";
            if (cliente.getContrasena() != null) {
                sentenciaCliente += ", contrasena=?";
            }
            sentenciaCliente += " WHERE idCliente=?";

            comandoSQL = conexion.prepareStatement(sentenciaCliente);
            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoPaterno());
            comandoSQL.setString(3, cliente.getApellidoMaterno());

            int parametro = 4;
            if (cliente.getContrasena() != null) {
                comandoSQL.setString(parametro++, cliente.getContrasena());
            }
            comandoSQL.setInt(parametro, cliente.getId());

            comandoSQL.executeUpdate();

            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, "Se actualizó el cliente");

            sentenciaDomicilio = "UPDATE Domicilios SET colonia=?, calle=?, numero=? WHERE idcliente=?";
            comandoSQL = conexion.prepareStatement(sentenciaDomicilio);
            comandoSQL.setString(1, dom.getColonia());
            comandoSQL.setString(2, dom.getCalle());
            comandoSQL.setInt(3, dom.getNumero());
            comandoSQL.setInt(4, cliente.getId());

            int filasAfectadas = comandoSQL.executeUpdate();

            if (filasAfectadas == 0) {
                throw new PersistenciaExcepcion("No se pudo modificar el domicilio, ID no encontrado.");
            } else {
                return true;
            }

        } catch (SQLException ex) {
            throw new PersistenciaExcepcion("Error al modificar el cliente o el domicilio: " + ex.getMessage());
        }
    }

    /**
     * Consulta un cliente en la base de datos por su ID.
     *
     * @param id El ID del cliente a consultar.
     * @return El cliente consultado.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
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

  /**
   * Método que consulta los domicilios registrados mediante una lista en donde
   * se obtienen todos los datos para buscar el domicilio en la lista
   * @param id ID del domicilio
   * @return Regresa un nulo
   * @throws PersistenciaExcepcion Excepcion de consulta
   */
    @Override
    public Domicilio consultarDomicilio(int id) throws PersistenciaExcepcion {
        Domicilio dom;

        String sentencia = String.format("SELECT * FROM Domicilios WHERE idcliente='%d'", id);

        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia);) {

            ResultSet res = comandoSQL.executeQuery(sentencia);

            if (res.next()) {
                dom = new Domicilio();
                dom.setIdDomicilio(res.getInt("idDomicilio"));
                dom.setColonia(res.getString("colonia"));
                dom.setCalle(res.getString("calle"));
                dom.setNumero(res.getInt("numero"));
                dom.setIdCliente(res.getInt("idcliente"));
                return dom;
            }
            return null;

        } catch (SQLException ex) {
            throw new PersistenciaExcepcion("Error al consultar los domicilios del cliente: " + ex.getMessage());
        }
    }

    /**
     * Método que valida los retiros, con ayuda de actualizaciones
     * dentro de la base de datos
     * @param retiro Retiro
     * @return El retiro validado
     * @throws PersistenciaExcepcion Excepcion
     */
    @Override
    public Retiros validarRetiros(RetiroDTO retiro) throws PersistenciaExcepcion {
        Retiros ret = new Retiros("121");

        String sentenciaSQL = "update retiroSinCuentea set estado = ? where folio=?";
        String sentenciaSQL2 = String.format("select * from retirosincuentea where folio = %d", retiro.getFolio());
        String sentenciaSQL3 = "update Cuentas set monto=? where numeroDeCuenta=?";

        try (Connection conexion = con.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL); PreparedStatement comandoSQL2 = conexion.prepareStatement(sentenciaSQL2); PreparedStatement comandoSQL3 = conexion.prepareStatement(sentenciaSQL3)) {

            comandoSQL.setString(1, "Espera");
            comandoSQL.setLong(2, retiro.getFolio());

            int res = comandoSQL.executeUpdate();

            ResultSet res2 = comandoSQL2.executeQuery();

            if (res2.next()) {
                if (res2.getString("estado").equals("Cancelado")) {
                    return new Retiros("510");
                } else {
                    Timestamp fecha = res2.getTimestamp("fecha");
                    LocalDateTime fecha2 = fecha.toLocalDateTime();
                    Retiros rere = new Retiros("Retiro", res2.getLong("cuenta"), res2.getLong("Folio"),
                            res2.getString("estado"), String.valueOf(retiro.getContrasena()), res2.getDouble("monto"), fecha2,
                            res2.getInt("idCuenta"));

                    String contrasenaRetiro = res2.getString("contrasena");

                    if (this.encriptar(String.valueOf(retiro.getContrasena())).equals(contrasenaRetiro)) {
                        double retirado = rere.getMonto();
                        double saldo = this.consultarSaldo(res2.getLong("cuenta"));
                        double total = saldo - retirado;

                        comandoSQL3.setDouble(1, total);
                        comandoSQL3.setLong(2, rere.getNumCuenta());
                        int res3 = comandoSQL3.executeUpdate();

                        Logger.getLogger(ClienteDao.class.getName()).log(Level.INFO, "se ah validado");

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

    /**
     * Consulta un retiro en la base de datos por su ID.
     *
     * @param id El ID del retiro a consultar.
     * @return El retiro consultado.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
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

    /**
     * Consulta las transferencias realizadas por un cliente.
     *
     * @param id El ID del cliente cuyas transferencias se desean consultar.
     * @return Una lista de transferencias realizadas por el cliente
     * especificado.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
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

}
