package com.pplam;

/**
 * @author derian-cordoba - 9/6/21
 * @project Bancos de preguntas #01
 */
public interface IPrueba {
    default String saltar(String... args) {
        return "Estoy saltando a una distancia de " + args[0];
    }
}
