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
 * @author jesus
 */
public class ControlCliente implements iControl {

    private final ClienteDao clienteDao;

    public ControlCliente(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Override
    public Transferencias transeferencia(TransferenciasDto trans) throws PersistenciaExcepcion {
        return clienteDao.transeferencia(trans);
    }

    @Override
    public Clientes registrarUsuario(ClienteDto cliente, DomicilioDto domicilio) throws PersistenciaExcepcion {
        return clienteDao.registrarUsuario(cliente, domicilio);
    }

    @Override
    public Clientes login(String usr, String contrasenia) throws PersistenciaExcepcion {
        return clienteDao.login(usr, contrasenia);
    }

    @Override
    public List<String> ConsultarNumeroCuentas(int idCliente) throws PersistenciaExcepcion {
        return clienteDao.ConsultarNumeroCuentas(idCliente);
    }

    @Override
    public String encriptar(String contra) throws NoSuchAlgorithmException {
        return clienteDao.encriptar(contra);
    }

    @Override
    public List<Cuentas> ConsultarCuentas(int id) throws PersistenciaExcepcion {
        return clienteDao.ConsultarCuentas(id);
    }

    @Override
    public double consultarSaldo(long numCuenta) throws PersistenciaExcepcion {
        return clienteDao.consultarSaldo(numCuenta);
    }

    @Override
    public List<Transferencias> ConsultarTransferencias(int id) throws PersistenciaExcepcion {
        return clienteDao.ConsultarTransferencias(id);
    }

    @Override
    public List<Retiros> ConsultarRetiros(int id) throws PersistenciaExcepcion {
        return clienteDao.ConsultarRetiros(id);
    }

    @Override
    public void deposito(long numCuenta, double monto) throws PersistenciaExcepcion {
        clienteDao.deposito(numCuenta, monto);
    }

    @Override
    public Cuentas agregarCuenta(CuentaDto cuenta) throws PersistenciaExcepcion {
        return clienteDao.agregarCuenta(cuenta);
    }

    @Override
    public boolean eliminarCuenta(long numCuenta) throws PersistenciaExcepcion {
        return clienteDao.eliminarCuenta(numCuenta);
    }

    @Override
    public boolean retiroSinCuenta(RetiroDTO retiro) throws PersistenciaExcepcion {
        return clienteDao.retiroSinCuenta(retiro);
    }

    @Override
    public long generarFolio() throws PersistenciaExcepcion {
        return clienteDao.generarFolio();
    }

    @Override
    public int generarContra() throws PersistenciaExcepcion {
        return clienteDao.generarContra();
    }

    @Override
    public Cuentas ConsultarCuenta(int id) throws PersistenciaExcepcion {
        return clienteDao.ConsultarCuenta(id);
    }

    @Override
    public void modificarCliente(ClienteDto cliente, DomicilioDto dom) throws PersistenciaExcepcion {
        clienteDao.modificarCliente(cliente, dom);
    }

    @Override
    public Clientes consultarCliente(int id) throws PersistenciaExcepcion {
        return clienteDao.consultarCliente(id);
    }

    @Override
    public Domicilio consultarDomicilio(int idCliente) throws PersistenciaExcepcion {
        return clienteDao.consultarDomicilio(idCliente);
    }

    @Override
    public Retiros validarRetiros(RetiroDTO retiro) throws PersistenciaExcepcion {
        return clienteDao.validarRetiros(retiro);
    }

    @Override
    public Retiros ConsultarUnRetiro(int id) throws PersistenciaExcepcion {
        return clienteDao.ConsultarUnRetiro(id);
    }

    @Override
    public Cuentas ConsultarCuenta(long numCue) throws PersistenciaExcepcion {
        return clienteDao.ConsultarCuenta(numCue);
    }
}
