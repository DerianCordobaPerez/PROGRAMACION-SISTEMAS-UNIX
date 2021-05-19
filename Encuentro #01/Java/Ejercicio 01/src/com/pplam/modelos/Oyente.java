package com.pplam.modelos;
import java.util.Scanner;

public class Oyente extends Participante {
    private String grado;
    public Oyente() {
        super();
    }

    public Oyente(String nombre, String apellido, String email, String grado) {
        super(nombre, apellido, email);
        this.setGrado(grado);
    }

    public void leerOyente() {
        super.leerParticipante();
        System.out.println("Grado: ");
        this.setGrado(new Scanner(System.in).nextLine());
    }

    public void mostrarOyente() {
        super.mostrarParticipante();
        System.out.println("\nGrado:" + this.getGrado());
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
}
