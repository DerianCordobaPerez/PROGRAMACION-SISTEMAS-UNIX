package com.pplam;

import javax.swing.*;
import java.awt.*;

/**
 * @author derian-cordoba - 23/6/21
 * @project Ejercicio_02
 */

public class Bienvenida extends JFrame {

    private final JLabel enunciado = new JLabel();
    private final JPanel panelSecundario = new JPanel();

    private static Bienvenida instancia = null;

    public static Bienvenida getInstance(String nombre) {
        if(instancia == null)
            instancia = new Bienvenida(nombre);
        return instancia;
    }

    private Bienvenida(String nombre) {
        this.enunciado.setText("Bienvenido " + nombre);
        this.setTitle("Titulo de la ventana secundaria");
        this.creacionPanel();
        this.setVisible(true);
        this.setSize(200, 100);
    }

    private void creacionPanel() {
        this.panelSecundario.setLayout(new GridLayout(1, 1));
        this.panelSecundario.add(this.enunciado);
        this.setContentPane(this.panelSecundario);
        this.setResizable(false);
    }

}
