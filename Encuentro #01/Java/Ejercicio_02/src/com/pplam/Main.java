package com.pplam;

import com.pplam.modelos.*;
import com.pplam.utilidades.Utilidades;

public class Main {

    public static void main(String... args) {
        int opcion;
        do {
            opcion = Utilidades.Menu();
        } while(opcion < 1 || opcion > 4);

        switch (opcion) {
            case 1 -> {
                Mamifero mamifero = new Mamifero();
                mamifero.leerAnimal();
                mamifero.queClaseDeAnimalEres();
            }
            case 2 -> {
                Ave ave = new Ave();
                ave.leerAve();
                ave.queClaseDeAnimalEres();
            }
            case 3 -> {
                Insecto insecto = new Insecto();
                insecto.leerInsecto();
                insecto.queClaseDeAnimalEres();
            }
            case 4 -> System.out.println("Programa Finalizado");
        }
    }
}
