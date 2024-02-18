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
 * @author jesus
 */
public interface iControl {
    
    public Clientes registrarUsuario(ClienteDto cliente, DomicilioDto dom) throws PersistenciaExcepcion;

    public Clientes login(String usr, String contrasenia) throws PersistenciaExcepcion;
    
    public Transferencias transeferencia(TransferenciasDto trans) throws PersistenciaExcepcion;
    
    public String encriptar(String contra) throws NoSuchAlgorithmException;
    
    public List<String> ConsultarNumeroCuentas(int id)throws PersistenciaExcepcion;
    
    public List<Cuentas> ConsultarCuentas(int id)throws PersistenciaExcepcion;
    
    public Cuentas ConsultarCuenta(int id)throws PersistenciaExcepcion;
    
    public List<Transferencias> ConsultarTransferencias(int id)throws PersistenciaExcepcion;

    public List<Retiros> ConsultarRetiros(int id)throws PersistenciaExcepcion;

    public void deposito(long numCuenta, double monto)throws PersistenciaExcepcion;
    
    public double consultarSaldo(long numCuenta)throws PersistenciaExcepcion;
    
    public Cuentas agregarCuenta(CuentaDto cuenta)throws PersistenciaExcepcion;
    
    public boolean eliminarCuenta(long numCuenta)throws PersistenciaExcepcion;
    
    public boolean retiroSinCuenta(RetiroDTO retiro) throws PersistenciaExcepcion;
    
    public long generarFolio() throws PersistenciaExcepcion;
    
    public int generarContra() throws PersistenciaExcepcion;
    
    public void modificarCliente(ClienteDto cliente,DomicilioDto dom) throws PersistenciaExcepcion;
    
    public Clientes consultarCliente(int id) throws PersistenciaExcepcion;
    
    public Domicilio consultarDomicilio(int id) throws PersistenciaExcepcion;
}
