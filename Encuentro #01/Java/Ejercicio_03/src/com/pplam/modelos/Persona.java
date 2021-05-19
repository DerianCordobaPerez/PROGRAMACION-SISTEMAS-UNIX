package com.pplam.modelos;
import com.pplam.interfaces.IAcciones;

public class Persona implements IAcciones {

    @Override
    public void correr(double velocidad) {
        System.out.println("Estoy corriendo a la velocidad de " + velocidad);
    }

    @Override
    public void saltar() {
        System.out.println("La persona esta saltando");
    }
}
