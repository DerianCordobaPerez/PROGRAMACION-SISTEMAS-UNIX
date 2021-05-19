package com.pplam.modelos;
import java.util.Scanner;

public class Participante {
    private String nombre, apellido, email;

    public Participante() {}

    public Participante(String nombre, String apellido, String email) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEmail(email);
    }

    public void leerParticipante() {
        System.out.println("Nombre: ");
        this.setNombre(new Scanner(System.in).nextLine());

        System.out.println("Apellido: ");
        this.setApellido(new Scanner(System.in).nextLine());

        System.out.println("Email: ");
        this.setEmail(new Scanner(System.in).nextLine());
    }

    protected void mostrarParticipante() {
        System.out.print("Nombre: " + this.getNombre() + "\nApellido: " + this.getApellido() + "\nEmail: " + this.getEmail());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
