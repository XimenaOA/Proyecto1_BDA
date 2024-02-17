/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Control;

import ClienteDto.ClienteDto;
import ClienteDto.CuentaDto;
import ClienteDto.DomicilioDto;
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
public interface iControl {
    
    public Clientes registrarUsuario(ClienteDto cliente, DomicilioDto dom) throws PersistenciaExcepcion;

    public Clientes login(String usr, String contrasenia) throws PersistenciaExcepcion;
    //no sirve
    public boolean transeferencia(int cuenta1, double MontoCuenta1, double saldo, double MontoCuenta2, int cuenta2) throws PersistenciaExcepcion;
    
    public String encriptar(String contra) throws NoSuchAlgorithmException;
    
    public List<String> ConsultarNumeroCuentas(int id)throws PersistenciaExcepcion;
    
    public List<Cuentas> ConsultarCuentas(int id)throws PersistenciaExcepcion;
    
    public List<Transferencias> ConsultarTransferencias(int id)throws PersistenciaExcepcion;

    public List<Retiros> ConsultarRetiros(int id)throws PersistenciaExcepcion;

    public void deposito(int numCuenta, double monto)throws PersistenciaExcepcion;
    
    public double consultarSaldo(int numCuenta)throws PersistenciaExcepcion;
    
    public Cuentas agregarCuenta(CuentaDto cuenta)throws PersistenciaExcepcion;
    
    public boolean eliminarCuenta(int numCuenta)throws PersistenciaExcepcion;
}
