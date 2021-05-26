package com.pplam.modelos;

import com.pplam.controladores.ServidorControlador;
import com.pplam.interfaces.IFecha;
import com.pplam.utilidades.Utilidades;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Servidor {

    public static void main(String... args) throws RemoteException, MalformedURLException {
        IFecha servidorControlador = new ServidorControlador();
        Utilidades.startRegistry(1099);
        Naming.rebind("ObjetoFecha", servidorControlador);
        System.out.println("Servidor encendido");
    }
}
