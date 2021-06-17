package com.pplam.modelos;

import com.pplam.controladores.ServidorControlador;
import com.pplam.interfaces.IFecha;
import com.pplam.utilidades.Utilidades;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Cliente {

    public static void main(String... args) throws MalformedURLException, NotBoundException, RemoteException {
        Utilidades.startRegistry(1099);
        IFecha servidorControlador = (IFecha) Naming.lookup("ObjetoFecha");

        System.out.println("Fecha enviada por el servidor => " + servidorControlador.fechaActual());
        System.out.println("Hora enviada por el servidor => " + servidorControlador.horaActual());
    }
}
