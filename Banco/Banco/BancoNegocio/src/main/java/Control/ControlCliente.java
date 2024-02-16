/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import ClienteDao.ClienteDao;
import ClienteDao.iCliente;
import ClienteDto.ClienteDto;
import ClienteDto.DomicilioDto;
import Dominio.Clientes;
import Dominio.Cuentas;
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
//
//    @Override
//    public List<Movimientos> obtenerHistorial(ClienteDto cliente) throws PersistenciaExcepcion {
//        return clienteDao.historial(cliente);
//    }

    @Override
    public boolean realizarTransferencia(int cuenta1, double montoCuenta1, double saldo, double montoCuenta2, int cuenta2) throws PersistenciaExcepcion {
        return clienteDao.transeferencia(cuenta1, montoCuenta1, saldo, montoCuenta2, cuenta2);
    }

    @Override
    public boolean registrarUsuario(ClienteDto cliente, DomicilioDto domicilio) throws PersistenciaExcepcion {
        return clienteDao.registrarUsuario(cliente, domicilio);
    }

    @Override
    public Clientes iniciarSesion(String usr, String contrasenia) throws PersistenciaExcepcion {
        return clienteDao.login(usr, contrasenia);
    }

    @Override
    public List<String> ConsultarCuentasTranseferencias(int idCliente) throws PersistenciaExcepcion {
        return clienteDao.ConsultarCuentasTranseferencias(idCliente);
    }
 
    @Override
    public String encriptar(String contra) throws NoSuchAlgorithmException {
        return clienteDao.encriptar(contra);
    }

    @Override
    public List<Cuentas> ConsultarCuentasInicio(int id) throws PersistenciaExcepcion {
        return clienteDao.ConsultarCuentasInicio(id);
    }
}
