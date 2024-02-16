/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ClienteDao;

import ClienteDto.ClienteDto;
import ClienteDto.DomicilioDto;
import Dominio.Clientes;
import Dominio.Domicilio;
import Dominio.Movimientos;
import Excepciones.PersistenciaExcepcion;
import java.util.List;

/**
 *
 * @author jesus
 */
public interface iCliente {

    
    public void registrarUsuario(Clientes cliente) throws PersistenciaExcepcion;
    
    public String Retiro(Movimientos mov) throws PersistenciaExcepcion;
    
    public void registrarUsuario(ClienteDto cliente, DomicilioDto dom) throws PersistenciaExcepcion;

    public boolean login(String usr, String contrasenia) throws PersistenciaExcepcion;
    
//    public Clientes retiro(ClienteDto cli) throws PersistenciaExcepcion;
//    
//    public Clientes transeferencia(ClienteDto cli) throws PersistenciaExcepcion;
    
    public List<Movimientos> historial(ClienteDto cli) throws PersistenciaExcepcion;
    
//    public Clientes modificar(ClienteDto cli) throws PersistenciaExcepcion;
//    
//    public Clientes agregarCuenta(ClienteDto cli) throws PersistenciaExcepcion;
//    
//    public Clientes eliminarCuenta(ClienteDto cli) throws PersistenciaExcepcion;
}
