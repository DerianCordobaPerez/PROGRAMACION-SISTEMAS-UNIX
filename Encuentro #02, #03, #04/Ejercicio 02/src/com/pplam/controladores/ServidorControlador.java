package com.pplam.controladores;

import com.pplam.interfaces.IFecha;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ServidorControlador extends UnicastRemoteObject implements IFecha {
    private final Calendar calendario = new GregorianCalendar();

    public ServidorControlador() throws RemoteException {}

    @Override
    public String horaActual() throws RemoteException {
        return (calendario.get(Calendar.HOUR_OF_DAY) + ":" +
                calendario.get(Calendar.MINUTE) + ":" +
                calendario.get(Calendar.SECOND));
    }

    @Override
    public String fechaActual() throws RemoteException {
        return (calendario.get(Calendar.DAY_OF_MONTH) + "/" +
                calendario.get(Calendar.MONTH) + "/" +
                calendario.get(Calendar.YEAR));
    }
}
