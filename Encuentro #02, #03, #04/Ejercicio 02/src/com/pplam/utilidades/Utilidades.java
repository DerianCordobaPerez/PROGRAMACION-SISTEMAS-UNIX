package com.pplam.utilidades;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Utilidades {
    /**
     * verifica la conexion en caso de encontrar uno, en caso contrario la creara
     * @param port puerto donde se conectara
     * @throws RemoteException
     */
    public static void startRegistry(int port) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(port);
            registry.list();
        } catch (RemoteException e) {
            Registry registry = LocateRegistry.createRegistry(port);
        }
    }
}
