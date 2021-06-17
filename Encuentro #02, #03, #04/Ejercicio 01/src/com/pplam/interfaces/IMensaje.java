package com.pplam.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author derian-cordoba
 * */

public interface IMensaje extends Remote {

    /**
     * Metodo con el objetivo de enviar un mensaje
     * @return String mensaje enviado
     * @throws RemoteException
     */
    String mensaje() throws RemoteException;
}
