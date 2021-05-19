package com.pplam.modelos;

public class Mamifero extends Animal {

    public Mamifero() {}

    public Mamifero(String especie, String nombre, double peso, int jaula) {
        super(especie, nombre, peso, jaula);
    }

    @Override
    public void queClaseDeAnimalEres() {
        System.out.println("Soy un mamifero llamado: " + this.getNombre() + "\nDe la Especie: " + this.getEspecie()
                + "\nPeso en Kg: " + this.getPeso() + "\nNumero de Jaula: " + this.getJaula());
    }
}
