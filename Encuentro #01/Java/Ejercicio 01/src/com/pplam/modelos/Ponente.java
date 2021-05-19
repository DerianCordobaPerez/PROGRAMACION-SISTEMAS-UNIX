package com.pplam.modelos;

import java.util.Scanner;

public class Ponente extends Participante {
    private String titulo, tematica;

    public Ponente() {
        super();
    }

    /**
     * @param nombre nombre
     * @param apellido apellido
     * @param email email
     * @param titulo titulo
     * @param tematica tematica
     */
    public Ponente(String nombre, String apellido, String email, String titulo, String tematica) {
        super(nombre, apellido, email);
        this.setTitulo(titulo);
        this.setTematica(tematica);
    }

    public void leerPonente() {
        super.leerParticipante();
        System.out.println("Titulo: ");
        this.setTitulo(new Scanner(System.in).nextLine());

        System.out.println("Tematica: ");
        this.setTematica(new Scanner(System.in).nextLine());
    }

    public void mostrarPonente() {
        super.mostrarParticipante();
        System.out.println("\nTitulo:" + this.getTitulo() + "\nTematica: " + this.getTematica());
    }

    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTematica() {
        return tematica;
    }

    /**
     * @param tematica tematica
     */
    public void setTematica(String tematica) {
        this.tematica = tematica;
    }
}
