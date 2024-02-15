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

/**
 *
 * @author jesus
 */
public interface iCliente {
    public String Retiro(Movimientos mov) throws PersistenciaExcepcion;
    public void registrarUsuario(ClienteDto cliente, DomicilioDto dom) throws PersistenciaExcepcion;
    public boolean login(String usr, String contrasenia) throws PersistenciaExcepcion;
}
