package com.pplam;

import com.pplam.interfaces.IMensaje;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author derian-cordoba
 * */

public class Cliente {
    private Cliente() {super();}

    public static void main(String... args) throws RemoteException, NotBoundException {
        // Obtenemos el registro creado en el servidor con el mismo puerto
        Registry registry = LocateRegistry.getRegistry(1099);

        // Mediante la 2da capa obtenemos el objeto visible con el nombre establecido en el servidor
        // El stub es una representacion del servidor, por ende podemos acceder a todos los metodos del servidor que la interfaces le proporcione
        IMensaje stub = (IMensaje) registry.lookup("ObjetoMensaje");

        // Mostramos por consola el mensaje enviado desde el servidor
        System.out.println("Mensaje: " + stub.mensaje());
    }
}
