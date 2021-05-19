package com.pplam.modelos;
import com.pplam.utilidades.Utilidades;

public class Insecto extends Animal{
    protected boolean vuela;

    public Insecto() {}

    public Insecto(String especie, String nombre, double peso, int jaula, boolean vuela) {
        super(especie, nombre, peso, jaula);
        this.vuela = vuela;
    }

    public void leerInsecto() {
        super.leerAnimal();
        this.setVuela(Utilidades.leerString("El insecto vuela? (Si o No)").equalsIgnoreCase("SI"));
    }

    @Override
    public void queClaseDeAnimalEres() {
        System.out.println("Soy un mamifero llamado: " + this.getNombre() + "\nDe la Especie: " + this.getEspecie() +
                "\nPeso en Kg: " + this.getPeso() + "\nJaula: No se Encuentra en Jaula\nVuela: " + (this.getVuela() ? "Si" : "No"));
    }

    public boolean getVuela() {
        return vuela;
    }

    public void setVuela(boolean vuela) {
        this.vuela = vuela;
    }
}
