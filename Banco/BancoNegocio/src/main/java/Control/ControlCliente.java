/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import ClienteDao.ClienteDao;
import ClienteDao.iCliente;
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
 *  ControlCliente es una clase que implementa la interfaz iControl y actúa como
 * intermediario entre la capa de presentación y la capa de persistencia para
 * operaciones relacionadas con clientes, cuentas y transacciones.
 * 
 * @author Jesús Alberto Morales Rojas - 245335, Ximena Oliva Andrade - 247563
 *
 */
public class ControlCliente implements iControl {

    //Atributos de la clase
    private final ClienteDao clienteDao;

    /**
     * Constructor de ControlCliente.
     *
     * @param clienteDao Objeto ClienteDao que se utilizará para interactuar con
     * la capa de persistencia.
     */
    public ControlCliente(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

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
    @Override
    public Transferencias transeferencia(TransferenciasDto trans) throws PersistenciaExcepcion {
        return clienteDao.transeferencia(trans);
    }

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
    @Override
    public Clientes registrarUsuario(ClienteDto cliente, DomicilioDto domicilio) throws PersistenciaExcepcion {
        return clienteDao.registrarUsuario(cliente, domicilio);
    }

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
    @Override
    public Clientes login(String usr, String contrasenia) throws PersistenciaExcepcion {
        return clienteDao.login(usr, contrasenia);
    }

    /**
     * Consulta los números de cuenta asociados a un cliente específico.
     *
     * @param idCliente ID del cliente del cual se desean consultar las cuentas.
     * @return Una lista de Strings que representan los números de cuenta
     * asociados al cliente.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public List<String> ConsultarNumeroCuentas(int idCliente) throws PersistenciaExcepcion {
        return clienteDao.ConsultarNumeroCuentas(idCliente);
    }

    /**
     * Encripta una contraseña utilizando un algoritmo específico.
     *
     * @param contra Contraseña a encriptar.
     * @return La contraseña encriptada.
     * @throws NoSuchAlgorithmException Si el algoritmo de encriptación no está
     * disponible en el entorno.
     */
    @Override
    public String encriptar(String contra) throws NoSuchAlgorithmException {
        return clienteDao.encriptar(contra);
    }

    /**
     * Consulta las cuentas asociadas a un cliente específico.
     *
     * @param id ID del cliente del cual se desean consultar las cuentas.
     * @return Una lista de objetos Cuentas que representan las cuentas
     * asociadas al cliente.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public List<Cuentas> ConsultarCuentas(int id) throws PersistenciaExcepcion {
        return clienteDao.ConsultarCuentas(id);
    }

    /**
     * Consulta el saldo de una cuenta específica.
     *
     * @param numCuenta Número de cuenta del cual se desea consultar el saldo.
     * @return El saldo de la cuenta especificada.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public double consultarSaldo(long numCuenta) throws PersistenciaExcepcion {
        return clienteDao.consultarSaldo(numCuenta);
    }

    /**
     * Consulta las transferencias asociadas a un cliente específico.
     *
     * @param id ID del cliente del cual se desean consultar las transferencias.
     * @return Una lista de objetos Transferencias que representan las
     * transferencias asociadas al cliente.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public List<Transferencias> ConsultarTransferencias(int id) throws PersistenciaExcepcion {
        return clienteDao.ConsultarTransferencias(id);
    }

    /**
     * Consulta los retiros asociados a un cliente específico.
     *
     * @param id ID del cliente del cual se desean consultar los retiros.
     * @return Una lista de objetos Retiros que representan los retiros
     * asociados al cliente.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public List<Retiros> ConsultarRetiros(int id) throws PersistenciaExcepcion {
        return clienteDao.ConsultarRetiros(id);
    }

    /**
     * Realiza un depósito en una cuenta específica.
     *
     * @param numCuenta Número de cuenta en la cual se realizará el depósito.
     * @param monto Monto a depositar.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public void deposito(long numCuenta, double monto) throws PersistenciaExcepcion {
        clienteDao.deposito(numCuenta, monto);
    }

    /**
     * Agrega una nueva cuenta asociada a un cliente.
     *
     * @param cuenta Objeto CuentaDto que contiene los detalles de la nueva
     * cuenta.
     * @return Un objeto Cuentas que representa la nueva cuenta agregada.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public Cuentas agregarCuenta(CuentaDto cuenta) throws PersistenciaExcepcion {
        return clienteDao.agregarCuenta(cuenta);
    }

    /**
     * Elimina una cuenta específica.
     *
     * @param numCuenta Número de cuenta que se desea eliminar.
     * @return true si la cuenta se eliminó correctamente, false de lo
     * contrario.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public boolean eliminarCuenta(long numCuenta) throws PersistenciaExcepcion {
        return clienteDao.eliminarCuenta(numCuenta);
    }

    /**
     * Realiza un retiro sin cuenta asociado a un cliente.
     *
     * @param retiro Objeto RetiroDTO que contiene los detalles del retiro.
     * @return true si el retiro sin cuenta se realizó correctamente, false de
     * lo contrario.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public boolean retiroSinCuenta(RetiroDTO retiro) throws PersistenciaExcepcion {
        return clienteDao.retiroSinCuenta(retiro);
    }

    /**
     * Genera un número de folio único para identificar transacciones.
     *
     * @return Un número de folio único generado.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public long generarFolio() throws PersistenciaExcepcion {
        return clienteDao.generarFolio();
    }

    /**
     * Genera una contraseña aleatoria para utilizar en el sistema.
     *
     * @return Una contraseña aleatoria generada.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public int generarContra() throws PersistenciaExcepcion {
        return clienteDao.generarContra();
    }

    /**
     * Consulta una cuenta específica por su ID.
     *
     * @param id ID de la cuenta que se desea consultar.
     * @return Un objeto Cuentas que representa la cuenta consultada.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public Cuentas ConsultarCuenta(int id) throws PersistenciaExcepcion {
        return clienteDao.ConsultarCuenta(id);
    }

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
    @Override
    public boolean modificarCliente(ClienteDto cliente, DomicilioDto dom) throws PersistenciaExcepcion {
        return clienteDao.modificarCliente(cliente, dom);
    }

    /**
     * Consulta un cliente específico por su ID.
     *
     * @param id ID del cliente que se desea consultar.
     * @return Un objeto Clientes que representa al cliente consultado.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public Clientes consultarCliente(int id) throws PersistenciaExcepcion {
        return clienteDao.consultarCliente(id);
    }

    /**
     * Consulta el domicilio asociado a un cliente específico por su ID.
     *
     * @param idCliente ID del cliente del cual se desea consultar el domicilio.
     * @return Un objeto Domicilio que representa el domicilio asociado al
     * cliente.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public Domicilio consultarDomicilio(int idCliente) throws PersistenciaExcepcion {
        return clienteDao.consultarDomicilio(idCliente);
    }

    /**
     * Valida un retiro realizado sin cuenta asociado a un cliente.
     *
     * @param retiro Objeto RetiroDTO que contiene los detalles del retiro a
     * validar.
     * @return Un objeto Retiros que representa el retiro validado.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public Retiros validarRetiros(RetiroDTO retiro) throws PersistenciaExcepcion {
        return clienteDao.validarRetiros(retiro);
    }

    /**
     * Consulta un retiro específico por su ID.
     *
     * @param id ID del retiro que se desea consultar.
     * @return Un objeto Retiros que representa el retiro consultado.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public Retiros ConsultarUnRetiro(int id) throws PersistenciaExcepcion {
        return clienteDao.ConsultarUnRetiro(id);
    }

    /**
     * Consulta una cuenta específica por su número de cuenta.
     *
     * @param numCue Número de cuenta que se desea consultar.
     * @return Un objeto Cuentas que representa la cuenta consultada.
     * @throws PersistenciaExcepcion Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public Cuentas ConsultarCuenta(long numCue) throws PersistenciaExcepcion {
        return clienteDao.ConsultarCuenta(numCue);
    }
}
