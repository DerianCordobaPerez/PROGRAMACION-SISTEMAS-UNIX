package com.pplam.modelos;
import com.pplam.configuraciones.Configuraciones;
import com.pplam.interfaces.ICliente;
import com.pplam.interfaces.IConexion;
import com.pplam.interfaces.ILogin;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 * @author derian-cordoba - 22/5/21
 * @project Ejercicio 03
 */

public class Cliente implements ICliente {
    IConexion conexion;
    String nombre, target;

    /**
     * Constructor Cliente
     * @param nombre Nombre del cliente
     * @param target Nombre del cliente con el que haremos comunicacion
     */
    public Cliente(String nombre, String target) {
        this.nombre = nombre;
        this.target = target;
    }

    /**
     * Divide el numero obtenido por el parametro a la mitad
     * @param numero Numero recibido por el cliente al cual le haremos la division
     * @param divisor Numero con el cual haremos la division
     */
    @Override
    public void dividirNumero(int numero, int divisor) throws RemoteException {
        System.out.println("Nombre: " + this.nombre + " recibio: \"" + this.conexion.pasarEntero(this.target,numero / divisor, divisor) + "\"");
    }

    /**
     * Metodo principal
     * @param args Argumentos de consola
     */
    public static void main(String... args) throws RemoteException, NotBoundException {
        System.out.println("Ingrese el nombre del cliente y el target");
        Cliente cliente = new Cliente(new Scanner(System.in).nextLine(), new Scanner(System.in).nextLine());

        Registry registry = LocateRegistry.getRegistry();
        ILogin login = (ILogin) registry.lookup(Configuraciones.nombreServidor);

        System.out.println("Ingrese el puerto del Cliente => " + cliente.nombre);
        UnicastRemoteObject.exportObject(cliente, new Scanner(System.in).nextInt());

        cliente.conexion = login.login(cliente.nombre, cliente);
        if(cliente.nombre.equalsIgnoreCase("Cliente 01")) {
            System.out.println("Ingrese el numero a trabajar y el divisor: ");
            cliente.conexion.pasarEntero(cliente.target, new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt());
        }
    }
}
