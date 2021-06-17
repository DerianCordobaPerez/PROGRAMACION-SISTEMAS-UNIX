package com.pplam.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author derian-cordoba - 22/5/21
 * @project Ejercicio 03
 */

public interface ICliente extends Remote {

    /**
     * Divide el numero obtenido por el parametro a la mitad
     * @param numero Numero recibido por el cliente al cual le haremos la division
     * @param divisor Numero con el cual haremos la division
     */
    void dividirNumero(int numero, int divisor) throws RemoteException;
}
