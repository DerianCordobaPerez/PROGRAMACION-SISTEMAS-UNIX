package com.pplam.modelos;

import com.pplam.utilidades.Utilidades;

public abstract class Animal {
    protected String especie, nombre;
    protected double peso;
    protected int jaula;

    public Animal() {}

    public Animal(String especie, String nombre, double peso, int jaula) {
        this.setEspecie(especie);
        this.setNombre(nombre);
        this.setPeso(peso);
        this.setJaula(jaula);
    }

    public abstract void queClaseDeAnimalEres();

    public void leerAnimal() {
        this.setEspecie(Utilidades.leerString("Especie: "));
        this.setNombre(Utilidades.leerString("Nombre: "));
        this.setPeso(Utilidades.leerDouble("Peso: ", 1, 500));
        if(!(this instanceof Insecto))
            this.setJaula(Utilidades.leerInt("Jaula: ", 1, 50));
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getJaula() {
        return jaula;
    }

    public void setJaula(int jaula) {
        this.jaula = jaula;
    }
}
