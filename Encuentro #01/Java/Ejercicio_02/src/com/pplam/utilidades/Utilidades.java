package com.pplam.utilidades;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Utilidades {
    private static final Random numeroAleatorio;

    static {
         numeroAleatorio = new Random(System.currentTimeMillis());
    }

    /**
     * @param inicio numero del inicio de donde se generaran los numeros
     * @param _final numero del final de donde se generaran los numeros
     * @return int numero aleatorio
     */
    public static int generarNumero(int inicio, int _final) {
        return numeroAleatorio.nextInt(_final - inicio + 1) + inicio;
    }

    /**
     * @param enunciado enunciado presentado en pantalla
     * @return String cadena leida por el usuario
     */
    public static String leerString(String enunciado) {
        String cadena;
        do {
            System.out.println(enunciado);
            cadena = new Scanner(System.in).nextLine().trim();
        } while(cadena.isBlank() || cadena.isEmpty());
        return cadena;
    }

    /**
     * @param enunciado enunciado presentado en pantalla
     * @param minimo numero minimo
     * @param maximo numero maximo
     * @return double valor leido
     */
    public static double leerDouble(String enunciado, int minimo, int maximo) {
        double numero;
        try {
            System.out.println(enunciado);
            numero = new Scanner(System.in).nextDouble();
        } catch (Exception exception) {
            System.out.println("El formato del dato ingresado no es el correcto el valor que se le dara sera aleatorio");
            numero = generarNumero(minimo, maximo);
        }
        return numero;
    }

    /**
     * @param enunciado enunciado presentado en pantalla
     * @param minimo numero minimo
     * @param maximo numero maximo
     * @return int valor leido
     */
    public static int leerInt(String enunciado, int minimo, int maximo) {
        int numero;
        try {
            System.out.println(enunciado);
            numero = new Scanner(System.in).nextInt();
        } catch (Exception exception) {
            System.out.println("El formato del dato ingresado no es el correcto el valor que se le dara sera aleatorio");
            numero = generarNumero(minimo, maximo);
        }
        return numero;
    }

    public static int Menu() {
        try {
            return leerInt("OPCIONES DEL SUBMENU\n1. Mamifero\n2. Ave\n3. Insecto\n4. Salir", 1, 3);
        }
        catch (Exception exception) {
            System.out.println("EL FORMATO DE LA OPCION NO ES EL ADECUADO!");
            return generarNumero(1, 3);
        }
    }
}
