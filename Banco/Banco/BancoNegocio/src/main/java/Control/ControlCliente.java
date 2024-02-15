/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import ClienteDao.iCliente;
import ClienteDto.ClienteDto;
import Dominio.Clientes;
import Dominio.Movimientos;
import Excepciones.PersistenciaExcepcion;
import java.util.List;

/**
 *
 * @author jesus
 */
public class ControlCliente implements iControl{
private final iCliente clienteDao;

    public ControlCliente(iCliente clienteDao) {
        this.clienteDao = clienteDao;
    }

//    public Clientes retiro(ClienteDto cli) throws PersistenciaExcepcion {
//        return clienteDao.retiro(cli);
//    }
//
//    public Clientes transeferencia(ClienteDto cli) throws PersistenciaExcepcion {
//        return clienteDao.transeferencia(cli);
//    }

    public List<Movimientos> historial(ClienteDto cli) throws PersistenciaExcepcion {
        return clienteDao.historial(cli);
    }

//    public Clientes agregarCliente(ClienteDto cli) throws PersistenciaExcepcion {
//        return clienteDao.agregarCliente(cli);
//    }
//
//    public Clientes modificar(ClienteDto cli) throws PersistenciaExcepcion {
//        return clienteDao.modificar(cli);
//    }
//
//    public Clientes agregarCuenta(ClienteDto cli) throws PersistenciaExcepcion {
//        return clienteDao.agregarCuenta(cli);
//    }
//
//    public Clientes eliminarCuenta(ClienteDto cli) throws PersistenciaExcepcion {
//        return clienteDao.eliminarCuenta(cli);
//    }

    @Override
    public void registrarUsuario(Clientes cliente) throws PersistenciaExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean login(String usr, String contrasenia) throws PersistenciaExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
