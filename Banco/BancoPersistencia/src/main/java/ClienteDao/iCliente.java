/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ClienteDao;

import ClienteDto.ClienteDto;
import ClienteDto.CuentaDto;
import ClienteDto.DomicilioDto;
import ClienteDto.RetiroDTO;
import ClienteDto.TransferenciasDto;
import Dominio.Clientes;
import Dominio.Cuentas;
import Dominio.Domicilio;
import Dominio.Retiros;
import Dominio.Transferencias;
//import Dominio.Movimientos;
import Excepciones.PersistenciaExcepcion;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Interfaz que define las operaciones que deben ser implementadas por una clase
 * de acceso a datos (DAO) para la entidad Cliente. Define métodos para
 * registrar usuarios, realizar el login, realizar transferencias, encriptar
 * contraseñas, consultar información de cuentas y realizar operaciones
 * relacionadas con las cuentas como depósitos y retiros, entre otros.
 * 
 * @author Jesús Alberto Morales Rojas - 245335, Ximena Oliva Andrade - 247563
 *
 */
public interface iCliente {

    /**
     * Registra un nuevo usuario en el sistema junto con su domicilio.
     *
     * @param cliente El DTO del cliente a registrar.
     * @param dom El DTO del domicilio del cliente.
     * @return El cliente registrado.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public Clientes registrarUsuario(ClienteDto cliente, DomicilioDto dom) throws PersistenciaExcepcion;

    /**
     * Realiza el login de un usuario en el sistema.
     *
     * @param usr El nombre de usuario.
     * @param contrasenia La contraseña del usuario.
     * @return El cliente que ha iniciado sesión.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public Clientes login(String usr, String contrasenia) throws PersistenciaExcepcion;

    /**
     * Realiza una transferencia entre cuentas.
     *
     * @param trans El DTO de la transferencia a realizar.
     * @return La transferencia realizada.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public Transferencias transeferencia(TransferenciasDto trans) throws PersistenciaExcepcion;

    /**
     * Encripta una contraseña utilizando un algoritmo específico.
     *
     * @param contra La contraseña a encriptar.
     * @return La contraseña encriptada.
     * @throws NoSuchAlgorithmException Si no se encuentra el algoritmo de
     * encriptación.
     */
    public String encriptar(String contra) throws NoSuchAlgorithmException;

    /**
     * Consulta los números de cuenta asociados a un cliente.
     *
     * @param id El ID del cliente.
     * @return Una lista de números de cuenta.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public List<String> ConsultarNumeroCuentas(int id) throws PersistenciaExcepcion;

    /**
     * Consulta todas las cuentas asociadas a un cliente.
     *
     * @param id El ID del cliente.
     * @return Una lista de cuentas asociadas al cliente.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public List<Cuentas> ConsultarCuentas(int id) throws PersistenciaExcepcion;

    /**
     * Consulta una cuenta específica por su ID.
     *
     * @param id El ID de la cuenta.
     * @return La cuenta consultada.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public Cuentas ConsultarCuenta(int id) throws PersistenciaExcepcion;

    /**
     * Consulta una cuenta específica por su número.
     *
     * @param numCue El número de cuenta.
     * @return La cuenta consultada.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public Cuentas ConsultarCuenta(long numCue) throws PersistenciaExcepcion;

    /**
     * Consulta todas las transferencias asociadas a un cliente.
     *
     * @param id El ID del cliente.
     * @return Una lista de transferencias asociadas al cliente.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public List<Transferencias> ConsultarTransferencias(int id) throws PersistenciaExcepcion;

    /**
     * Consulta todos los retiros asociados a un cliente.
     *
     * @param id El ID del cliente.
     * @return Una lista de retiros asociados al cliente.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public List<Retiros> ConsultarRetiros(int id) throws PersistenciaExcepcion;

    /**
     * Realiza un depósito en una cuenta.
     *
     * @param numCuenta El número de cuenta.
     * @param monto El monto a depositar.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public void deposito(long numCuenta, double monto) throws PersistenciaExcepcion;

    /**
     * Consulta el saldo de una cuenta.
     *
     * @param numCuenta El número de cuenta.
     * @return El saldo de la cuenta.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public double consultarSaldo(long numCuenta) throws PersistenciaExcepcion;

    /**
     * Agrega una nueva cuenta al sistema.
     *
     * @param cuenta El DTO de la cuenta a agregar.
     * @return La cuenta agregada.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public Cuentas agregarCuenta(CuentaDto cuenta) throws PersistenciaExcepcion;

    /**
     * Elimina una cuenta del sistema.
     *
     * @param numCuenta El número de cuenta a eliminar.
     * @return true si la cuenta se elimina correctamente, false en caso
     * contrario.
     * @throws PersistenciaExcepcion
     */
    /**
     * Elimina una cuenta del sistema.
     *
     * @param numCuenta El número de cuenta a eliminar.
     * @return true si la cuenta se elimina correctamente, false en caso
     * contrario.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public boolean eliminarCuenta(long numCuenta) throws PersistenciaExcepcion;

    /**
     * Realiza un retiro sin necesidad de una cuenta asociada.
     *
     * @param retiro El DTO del retiro a realizar.
     * @return true si el retiro se realiza correctamente, false en caso
     * contrario.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public boolean retiroSinCuenta(RetiroDTO retiro) throws PersistenciaExcepcion;

    /**
     * Genera un folio único para identificar una transacción.
     *
     * @return El folio generado.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public long generarFolio() throws PersistenciaExcepcion;

    /**
     * Genera una contraseña aleatoria para un cliente.
     *
     * @return La contraseña generada.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public int generarContra() throws PersistenciaExcepcion;

    /**
     * Modifica la información de un cliente en el sistema junto con su
     * domicilio.
     *
     * @param cliente El DTO del cliente con la información actualizada.
     * @param dom El DTO del domicilio con la información actualizada.
     * @return true si la modificación se realiza correctamente, false en caso
     * contrario.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public boolean modificarCliente(ClienteDto cliente, DomicilioDto dom) throws PersistenciaExcepcion;

    /**
     * Consulta la información de un cliente por su ID.
     *
     * @param id El ID del cliente.
     * @return El cliente consultado.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public Clientes consultarCliente(int id) throws PersistenciaExcepcion;

    /**
     * Consulta la información de un domicilio por su ID.
     *
     * @param id El ID del domicilio.
     * @return El domicilio consultado.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public Domicilio consultarDomicilio(int id) throws PersistenciaExcepcion;

    /**
     * Valida un retiro antes de realizarlo.
     *
     * @param retiro El DTO del retiro a validar.
     * @return El retiro validado.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public Retiros validarRetiros(RetiroDTO retiro) throws PersistenciaExcepcion;

    /**
     * Consulta un retiro específico por su ID.
     *
     * @param id El ID del retiro.
     * @return El retiro consultado.
     * @throws PersistenciaExcepcion Si ocurre un error en la persistencia de
     * datos.
     */
    public Retiros ConsultarUnRetiro(int id) throws PersistenciaExcepcion;
}
