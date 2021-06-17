package com.pplam.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author derian-cordoba - 22/5/21
 * @project Ejercicio 03
 */

public interface IConexion extends Remote {

    /**
     * Cerrara la sesion actual del cliente en sesion
     */
    void cerrarSesion() throws RemoteException;

    /**
     * Convierte el numero obtenido por el parametro a String
     * @param destinatario Cliente al que se le enviara el numero entero
     * @param numero Numero recibido por el servidor
     * @param divisor Numero con el que dividiremos
     * @return Valor del numero en formato String
     */
    String pasarEntero(String destinatario, int numero, int divisor) throws RemoteException;
}
