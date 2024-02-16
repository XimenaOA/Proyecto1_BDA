/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Control;

import ClienteDto.ClienteDto;
import ClienteDto.DomicilioDto;
import Dominio.Clientes;
import Dominio.Movimientos;
import Excepciones.PersistenciaExcepcion;
import java.util.List;

/**
 *
 * @author jesus
 */
public interface iControl {
     List<Movimientos> obtenerHistorial(ClienteDto cliente) throws PersistenciaExcepcion;
    
    boolean realizarTransferencia(int cuenta1, double montoCuenta1, double saldo, double montoCuenta2, int cuenta2) throws PersistenciaExcepcion;
    
    boolean registrarUsuario(ClienteDto cliente, DomicilioDto domicilio) throws PersistenciaExcepcion;
    
    boolean iniciarSesion(String usr, String contrasenia) throws PersistenciaExcepcion;
    
    List<String> consultarCuentas(int idCliente) throws PersistenciaExcepcion;
    
}
