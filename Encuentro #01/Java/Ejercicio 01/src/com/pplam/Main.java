package com.pplam;
import com.pplam.modelos.*;

public class Main {

    public static void main(String[] args) {
        Oyente oyente = new Oyente();
        oyente.leerOyente();
        oyente.mostrarOyente();

        Ponente ponente = new Ponente();
        ponente.leerPonente();
        ponente.mostrarPonente();

    }
}
