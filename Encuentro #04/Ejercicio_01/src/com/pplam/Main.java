package com.pplam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JButton boton = new JButton("Presioname");
    public Main() {
        this.mostrarboton();
        this.eventoBoton();
       this. setVisible(true);
       this.setSize(500, 300);
       this.setTitle("Hola mundo");
    }

    public void mostrarboton() {
        this.add(this.boton);
    }

    public void eventoBoton() {
        this.boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "El boton ha sido presionado");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
