/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ClienteDao;

import ClienteDto.ClienteDto;
import ClienteDto.DomicilioDto;
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
public interface iCliente {

//    public String Retiro(Movimientos mov) throws PersistenciaExcepcion;
    
    public boolean registrarUsuario(ClienteDto cliente, DomicilioDto dom) throws PersistenciaExcepcion;

    public Clientes login(String usr, String contrasenia) throws PersistenciaExcepcion;
    
//    public Clientes retiro(ClienteDto cli) throws PersistenciaExcepcion;
//    
    public boolean transeferencia(int cuenta1, double MontoCuenta1, double saldo, double MontoCuenta2, int cuenta2) throws PersistenciaExcepcion;
    
//    public List<Movimientos> historial(ClienteDto cli) throws PersistenciaExcepcion;
    public String encriptar(String contra) throws NoSuchAlgorithmException;
    
    public List<String> ConsultarCuentasTranseferencias(int id)throws PersistenciaExcepcion;
    
    public List<Cuentas> ConsultarCuentasInicio(int id)throws PersistenciaExcepcion;
    
    public List<Transferencias> ConsultarTransferencias(int id)throws PersistenciaExcepcion;

    public List<Retiros> ConsultarRetiros(int id)throws PersistenciaExcepcion;

    public void deposito(int numCuenta)throws PersistenciaExcepcion;
//    public Clientes modificar(ClienteDto cli) throws PersistenciaExcepcion;
//    
//    public Clientes agregarCuenta(ClienteDto cli) throws PersistenciaExcepcion;
//    
//    public Clientes eliminarCuenta(ClienteDto cli) throws PersistenciaExcepcion;
}
