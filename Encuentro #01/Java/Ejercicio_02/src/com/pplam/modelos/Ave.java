package com.pplam.modelos;

import com.pplam.utilidades.Utilidades;

public class Ave extends Animal {
    protected String colorPlumaje;
    protected double alturaMaxima;

    public Ave() {}

    public Ave(String especie, String nombre, double peso, int jaula, String colorPlumaje, double alturaMaxima) {
        super(especie, nombre, peso, jaula);
        this.setColorPlumaje(colorPlumaje);
        this.setAlturaMaxima(alturaMaxima);
    }

    public void leerAve() {
        super.leerAnimal();
        this.setColorPlumaje(Utilidades.leerString("Color plumaje: "));
        this.setAlturaMaxima(Utilidades.leerDouble("Altura maxima: ", 50, 250));
    }

    @Override
    public void queClaseDeAnimalEres() {
        System.out.println("Soy una Ave llamada: " + this.getNombre() + "\nDe la Especie: " + this.getEspecie() + "\nPeso en Kg: " + this.getPeso()
                + "\nNumero de Jaula: " + this.getJaula() + "\nColor de Plumaje: " + this.getColorPlumaje() + "\nAltura Maxima de Vuelo: " + this.getAlturaMaxima());
    }

    public String getColorPlumaje() {
        return colorPlumaje;
    }

    public void setColorPlumaje(String colorPlumaje) {
        this.colorPlumaje = colorPlumaje;
    }

    public double getAlturaMaxima() {
        return alturaMaxima;
    }

    public void setAlturaMaxima(double alturaMaxima) {
        this.alturaMaxima = alturaMaxima;
    }
}
