/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Control;

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
 *
 * @author Jesús Alberto Morales Rojas - 245335, Ximena Oliva Andrade - 247563
 *
 * Interfaz que construye todos los métodos de la clase ControlCliente
 */
public interface iControl {

    /**
     * Registra un nuevo usuario en el sistema junto con su información de
     * domicilio.
     *
     * @param cliente Objeto ClienteDto que contiene los detalles del nuevo
     * cliente.
     * @param domicilio Objeto DomicilioDto que contiene los detalles del
     * domicilio del nuevo cliente.
     * @return Un objeto Clientes que representa al nuevo cliente registrado.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public Clientes registrarUsuario(ClienteDto cliente, DomicilioDto dom) throws PersistenciaExcepcion;

    /**
     * Permite que un usuario inicie sesión en el sistema.
     *
     * @param usr Nombre de usuario del cliente.
     * @param contrasenia Contraseña del cliente.
     * @return Un objeto Clientes que representa al cliente que ha iniciado
     * sesión.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public Clientes login(String usr, String contrasenia) throws PersistenciaExcepcion;

    /**
     * Realiza una transferencia de fondos entre cuentas.
     *
     * @param trans Objeto TransferenciasDto que contiene los detalles de la
     * transferencia.
     * @return Un objeto Transferencias que representa la transferencia
     * realizada.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public Transferencias transeferencia(TransferenciasDto trans) throws PersistenciaExcepcion;

    /**
     * Encripta una contraseña utilizando un algoritmo específico.
     *
     * @param contra Contraseña a encriptar.
     * @return La contraseña encriptada.
     * @throws NoSuchAlgorithmException Si el algoritmo de encriptación no está
     * disponible en el entorno.
     */
    public String encriptar(String contra) throws NoSuchAlgorithmException;

    /**
     * Consulta los números de cuenta asociados a un cliente específico.
     *
     * @param idCliente ID del cliente del cual se desean consultar las cuentas.
     * @return Una lista de Strings que representan los números de cuenta
     * asociados al cliente.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public List<String> ConsultarNumeroCuentas(int id) throws PersistenciaExcepcion;

    /**
     * Consulta las cuentas asociadas a un cliente específico.
     *
     * @param id ID del cliente del cual se desean consultar las cuentas.
     * @return Una lista de objetos Cuentas que representan las cuentas
     * asociadas al cliente.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public List<Cuentas> ConsultarCuentas(int id) throws PersistenciaExcepcion;

    /**
     * Consulta una cuenta específica por su ID.
     *
     * @param id ID de la cuenta que se desea consultar.
     * @return Un objeto Cuentas que representa la cuenta consultada.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public Cuentas ConsultarCuenta(int id) throws PersistenciaExcepcion;

    /**
     * Consulta las transferencias asociadas a un cliente específico.
     *
     * @param id ID del cliente del cual se desean consultar las transferencias.
     * @return Una lista de objetos Transferencias que representan las
     * transferencias asociadas al cliente.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public List<Transferencias> ConsultarTransferencias(int id) throws PersistenciaExcepcion;

    /**
     * Consulta los retiros asociados a un cliente específico.
     *
     * @param id ID del cliente del cual se desean consultar los retiros.
     * @return Una lista de objetos Retiros que representan los retiros
     * asociados al cliente.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public List<Retiros> ConsultarRetiros(int id) throws PersistenciaExcepcion;

    /**
     * Realiza un depósito en una cuenta específica.
     *
     * @param numCuenta Número de cuenta en la cual se realizará el depósito.
     * @param monto Monto a depositar.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public void deposito(long numCuenta, double monto) throws PersistenciaExcepcion;

    /**
     * Consulta el saldo de una cuenta específica.
     *
     * @param numCuenta Número de cuenta del cual se desea consultar el saldo.
     * @return El saldo de la cuenta especificada.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public double consultarSaldo(long numCuenta) throws PersistenciaExcepcion;

    /**
     * Agrega una nueva cuenta asociada a un cliente.
     *
     * @param cuenta Objeto CuentaDto que contiene los detalles de la nueva
     * cuenta.
     * @return Un objeto Cuentas que representa la nueva cuenta agregada.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public Cuentas agregarCuenta(CuentaDto cuenta) throws PersistenciaExcepcion;

    /**
     * Elimina una cuenta específica.
     *
     * @param numCuenta Número de cuenta que se desea eliminar.
     * @return true si la cuenta se eliminó correctamente, false de lo
     * contrario.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public boolean eliminarCuenta(long numCuenta) throws PersistenciaExcepcion;

    /**
     * Realiza un retiro sin cuenta asociado a un cliente.
     *
     * @param retiro Objeto RetiroDTO que contiene los detalles del retiro.
     * @return true si el retiro sin cuenta se realizó correctamente, false de
     * lo contrario.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public boolean retiroSinCuenta(RetiroDTO retiro) throws PersistenciaExcepcion;

    /**
     * Genera un número de folio único para identificar transacciones.
     *
     * @return Un número de folio único generado.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public long generarFolio() throws PersistenciaExcepcion;

    /**
     * Genera una contraseña aleatoria para utilizar en el sistema.
     *
     * @return Una contraseña aleatoria generada.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public int generarContra() throws PersistenciaExcepcion;

    /**
     * Modifica la información de un cliente y su domicilio asociado.
     *
     * @param cliente Objeto ClienteDto que contiene los detalles actualizados
     * del cliente.
     * @param dom Objeto DomicilioDto que contiene los detalles actualizados del
     * domicilio.
     * @return true si la modificación se realizó correctamente, false de lo
     * contrario.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public boolean modificarCliente(ClienteDto cliente, DomicilioDto dom) throws PersistenciaExcepcion;

    /**
     * Consulta un cliente específico por su ID.
     *
     * @param id ID del cliente que se desea consultar.
     * @return Un objeto Clientes que representa al cliente consultado.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public Clientes consultarCliente(int id) throws PersistenciaExcepcion;

    /**
     * Consulta el domicilio asociado a un cliente específico por su ID.
     *
     * @param id ID del cliente del cual se desea consultar el domicilio.
     * @return Un objeto Domicilio que representa el domicilio asociado al
     * cliente.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public Domicilio consultarDomicilio(int id) throws PersistenciaExcepcion;

    /**
     * Valida un retiro realizado sin cuenta asociado a un cliente.
     *
     * @param retiro Objeto RetiroDTO que contiene los detalles del retiro a
     * validar.
     * @return Un objeto Retiros que representa el retiro validado.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public Retiros validarRetiros(RetiroDTO retiro) throws PersistenciaExcepcion;

    /**
     * Consulta un retiro específico por su ID.
     *
     * @param id ID del retiro que se desea consultar.
     * @return Un objeto Retiros que representa el retiro consultado.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public Retiros ConsultarUnRetiro(int id) throws PersistenciaExcepcion;

    /**
     * Consulta una cuenta específica por su número de cuenta.
     *
     * @param numCue Número de cuenta que se desea consultar.
     * @return Un objeto Cuentas que representa la cuenta consultada.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    public Cuentas ConsultarCuenta(long numCue) throws PersistenciaExcepcion;
}
