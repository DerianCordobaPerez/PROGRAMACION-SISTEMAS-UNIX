package com.pplam.modelos;

import com.pplam.interfaces.ICliente;
import com.pplam.interfaces.IConexion;

import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.Unreferenced;

/**
 * @author derian-cordoba - 22/5/21
 * @project Ejercicio 03
 */

public class Conexion implements IConexion, Unreferenced {
    ICliente cliente;
    String nombre;

    /**
     * Constructor Conexion
     * @param nombre Nombre del cliente nuevo
     * @param cliente Cliente nuevo
     */
    public Conexion(String nombre, ICliente cliente) throws RemoteException {
        this.nombre = nombre;
        this.cliente = cliente;
        UnicastRemoteObject.exportObject(this, Registry.REGISTRY_PORT);
    }

    /**
     * Cerrara la sesion actual del cliente en sesion
     */
    @Override
    public void cerrarSesion() throws RemoteException {
        this.unreferenced();
        LoginServidor.clientes.remove(this.nombre);
        System.out.println("El cliente => " + this.nombre + " a cerrado sesion");
    }

    /**
     * Convierte el numero obtenido por el parametro a String
     * @param destinatario Cliente al que se le enviara el numero entero
     * @param numero Numero recibido por el servidor
     * @return Valor del numero en formato String
     */
    @Override
    public String pasarEntero(String destinatario, int numero, int divisor) {
        System.out.println("Servidor recibio de => " + this.nombre + " el numero: " + numero);
        if(numero >= 10) {
            ICliente cliente = LoginServidor.clientes.get(destinatario);
            try {
                cliente.dividirNumero(numero, divisor);
            } catch (RemoteException exception) {
                exception.printStackTrace();
            }
        }
        return String.valueOf(numero);
    }

    @Override
    public void unreferenced() {
        try {
            UnicastRemoteObject.unexportObject(this, true);
        } catch (NoSuchObjectException e) {
            e.printStackTrace();
        }
    }
}
