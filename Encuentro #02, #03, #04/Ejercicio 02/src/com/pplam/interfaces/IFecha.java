package com.pplam.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFecha extends Remote {
    String horaActual() throws RemoteException;

    String fechaActual() throws RemoteException;
}