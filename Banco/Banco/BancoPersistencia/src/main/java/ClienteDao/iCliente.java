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

    public String Retiro(Movimientos mov) throws PersistenciaExcepcion;
    
    public boolean registrarUsuario(ClienteDto cliente, DomicilioDto dom) throws PersistenciaExcepcion;

    public boolean login(String usr, String contrasenia) throws PersistenciaExcepcion;
    
//    public Clientes retiro(ClienteDto cli) throws PersistenciaExcepcion;
//    
    public boolean transeferencia(int cuenta1, double MontoCuenta1, double saldo, double MontoCuenta2, int cuenta2) throws PersistenciaExcepcion;
    
    public List<Movimientos> historial(ClienteDto cli) throws PersistenciaExcepcion;
    
    public List<String> ConsultarCuentas(int id)throws PersistenciaExcepcion;
//    public Clientes modificar(ClienteDto cli) throws PersistenciaExcepcion;
//    
//    public Clientes agregarCuenta(ClienteDto cli) throws PersistenciaExcepcion;
//    
//    public Clientes eliminarCuenta(ClienteDto cli) throws PersistenciaExcepcion;
}
