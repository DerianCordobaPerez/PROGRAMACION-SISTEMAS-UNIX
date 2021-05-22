package com.pplam;

import com.pplam.interfaces.IMensaje;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author derian-cordoba
 * */

public class Server implements IMensaje {
    private String mensaje;
    public Server() {}

    @Override
    public String mensaje() {
        return "Mensaje enviado desde el servidor: " + this.mensaje;
    }

    // String... define un arreglo de String, es lo mismo que hacer String[] args
    public static void main(String... args) throws RemoteException {
        // Creacion de la clase Server, este sera el objeto que exportaremos hacia al cliente
        Server server = new Server();

        // Establecemos el mensaje que se le enviara al cliente
        server.mensaje = "Hola desde el servidor";

        // declaramos la 2da capa para crear la exportacion del objeto, en este caso el objeto Server
        IMensaje stub = (IMensaje) UnicastRemoteObject.exportObject(server, 0);

        // creamos el registro con el puerto donde se ejecutara la conexion del rmi
        Registry registry = LocateRegistry.createRegistry(1099);

        // Hacemos visible el objeto para todos los clientes con el nombre ObjetoMensaje
        registry.rebind("ObjetoMensaje", stub);

        System.out.println("Servidor encendido");
    }
}
