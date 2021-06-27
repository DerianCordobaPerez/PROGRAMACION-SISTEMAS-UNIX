package com.pplam;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main extends JFrame {

    private final JTextField input = new JTextField();
    private final JButton boton = new JButton("Enviar nombre");
    private final JPanel panelPrincipal = new JPanel();

    public Main() {
        this.creacionPanel();
        this.setTitle("Titulo de la ventana");
        this.eventoBoton();
        this.setVisible(true);
        this.setSize(500, 300);
    }

    private void creacionPanel() {
        this.panelPrincipal.setLayout(new GridLayout(4, 5));
        this.agregarComponentes();
        this.setContentPane(this.panelPrincipal);
        this.setResizable(false);
    }

    public void eventoBoton() {
        this.boton.addActionListener(e -> {
            Bienvenida.getInstance(this.input.getText());
            this.dispose();
        });
    }

    public void agregarComponentes() {
        Arrays.asList(this.input, this.boton).forEach(this.panelPrincipal::add);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
