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
import Dominio.Clientes;
import Dominio.Cuentas;
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
    public boolean transeferencia(int cuenta1, double montoCuenta1, double saldo, double montoCuenta2, int cuenta2) throws PersistenciaExcepcion {
        return clienteDao.transeferencia(cuenta1, montoCuenta1, saldo, montoCuenta2, cuenta2);
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
    public double consultarSaldo(int numCuenta) throws PersistenciaExcepcion {
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
    public void deposito(int numCuenta, double monto) throws PersistenciaExcepcion {
        clienteDao.deposito(numCuenta, monto);
    }

    @Override
    public Cuentas agregarCuenta(CuentaDto cuenta) throws PersistenciaExcepcion {
        return clienteDao.agregarCuenta(cuenta);
    }

    @Override
    public boolean eliminarCuenta(int numCuenta) throws PersistenciaExcepcion {
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
    
    
    
}
