package com.pplam.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author derian-cordoba - 22/5/21
 * @project Ejercicio 03
 */

public interface ILogin extends Remote {

    /**
     * Crea una nueva sesion en el servidor con el cliente que se acaba de registrar
     * @param nombre Nombre del nuevo cliente
     * @param cliente Cliente nuevo
     * @return Nueva conexion creada con el nuevo cliente
     */
    IConexion login(String nombre, ICliente cliente) throws RemoteException;
}
