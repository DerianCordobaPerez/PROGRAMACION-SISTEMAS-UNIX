package com.pplam.modelos;

import com.pplam.configuraciones.Configuraciones;
import com.pplam.interfaces.ICliente;
import com.pplam.interfaces.IConexion;
import com.pplam.interfaces.ILogin;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * @author derian-cordoba - 22/5/21
 * @project Ejercicio 03
 */

public class LoginServidor implements ILogin {
    static Map<String, ICliente> clientes = new HashMap<>();

    /**
     * Crea una nueva sesion en el servidor con el cliente que se acaba de registrar
     * @param nombre Nombre del nuevo cliente
     * @param cliente Nuevo cliente
     * @return Nueva conexion creada con el nuevo cliente
     */
    @Override
    public IConexion login(String nombre, ICliente cliente) throws RemoteException {
        Conexion conexion = new Conexion(nombre, cliente);
        clientes.put(nombre, cliente);
        System.out.println("Cliente con el nombre => " + nombre + " se ha logueado!");
        return conexion;
    }

    /**
     * Metodo principal
     * @param args Argumentos de consola
     */
    public static void main(String... args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        LoginServidor loginServidor = new LoginServidor();

        UnicastRemoteObject.exportObject(loginServidor, Registry.REGISTRY_PORT);
        registry.rebind(Configuraciones.nombreServidor, loginServidor);
        System.out.println("Servidor encendido");
    }
}
