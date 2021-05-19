package com.pplam.interfaces;

public interface IAcciones {

    /**
     * @param velocidad velocidad a la que corre
     */
    void correr(double velocidad);

    default void saltar() {
        System.out.println("Estoy saltando");
    }
}
