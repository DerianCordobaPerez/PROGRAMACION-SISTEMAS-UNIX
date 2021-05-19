package com.pplam;
import com.pplam.interfaces.IAcciones;
import com.pplam.modelos.Persona;

public class Main {

    public static void main(String[] args) {
        IAcciones persona = new Persona();
        persona.correr(58.2);
        persona.saltar();
    }
}
