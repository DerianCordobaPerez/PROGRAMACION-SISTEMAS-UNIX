package com.pplam;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Arrays;

public class Main extends JFrame {
    private final JButton boton = new JButton("Presioname");
    private final JLabel label = new JLabel("Ingrese un texto");
    private final JLabel advertencia = new JLabel("No hay texto en en la caja");
    private final JTextField caja = new JTextField();
    private final JPanel panelPrincipal = new JPanel();

    public Main() {
        this.boton.setEnabled(false);
        this.creacionPanel();
        this.eventoBoton();
        this.eventoCajaTexto();
        this.setVisible(true);
        this.setSize(500, 300);
        this.setTitle("Hola mundo");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void creacionPanel() {
        this.panelPrincipal.setLayout(new GridLayout(4, 5));
        this.agregarComponentes();
        this.advertencia.setForeground(Color.RED);
        this.setContentPane(this.panelPrincipal);
        this.setResizable(false);
    }

    public void agregarComponentes() {
        Arrays.asList(this.label, this.caja, this.boton, this.advertencia).forEach(this.panelPrincipal::add);
    }

    public void eventoBoton() {
        this.boton.addActionListener(e -> JOptionPane.showMessageDialog(this, this.caja.getText()));
    }

    public void eventoCajaTexto() {
        this.caja.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validacionBoton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validacionBoton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validacionBoton();
            }
        });
    }

    private void validacionBoton() {
        this.boton.setEnabled(this.caja.getText().length() > 0);
        this.advertencia.setVisible(this.caja.getText().length() == 0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
