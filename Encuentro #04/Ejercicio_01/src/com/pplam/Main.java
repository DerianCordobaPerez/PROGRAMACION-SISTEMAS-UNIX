package com.pplam;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JButton boton = new JButton("Presioname");
    private JLabel label = new JLabel("Ingrese un texto");

    private JTextField text = new JTextField();
    private JPanel mainPanel = new JPanel();

    public Main() {
        this.panel();
        this.eventoBoton();

        this. setVisible(true);
        this.setSize(500, 300);
        this.setTitle("Hola mundo");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void panel() {
        this.mainPanel.setLayout(new GridLayout(4, 5));
        mostrarCajaDialog();
        mostrarboton();
        this.setContentPane(this.mainPanel);
    }

    public void mostrarboton() {
        this.mainPanel.add(this.boton);
    }

    public void mostrarCajaDialog() {
        this.mainPanel.add(this.label);
        this.mainPanel.add(this.text);
    }

    public void eventoBoton() {
        this.boton.addActionListener(e -> {
            String texto = this.text.getText();
            JOptionPane.showMessageDialog(null, texto);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
