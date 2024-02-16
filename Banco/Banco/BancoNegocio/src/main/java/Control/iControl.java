/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Control;

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
public interface iControl {
//     List<Movimientos> obtenerHistorial(ClienteDto cliente) throws PersistenciaExcepcion;
    public String encriptar(String contra) throws NoSuchAlgorithmException;
    boolean realizarTransferencia(int cuenta1, double montoCuenta1, double saldo, double montoCuenta2, int cuenta2) throws PersistenciaExcepcion;
    
    boolean registrarUsuario(ClienteDto cliente, DomicilioDto domicilio) throws PersistenciaExcepcion;
    
    Clientes iniciarSesion(String usr, String contrasenia) throws PersistenciaExcepcion;
    
    public List<String> ConsultarCuentasTranseferencias(int id)throws PersistenciaExcepcion;
    
    public List<Cuentas> ConsultarCuentasInicio(int id)throws PersistenciaExcepcion;
}
