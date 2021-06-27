package com.pplam;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Arrays;

/**
 * @author derian-cordoba - 16/6/21
 * @project Ejercicio_01
 */

public class Main extends JFrame {
    private final JButton boton = new JButton("Presioname");
    private final JLabel label = new JLabel("Ingrese un texto");
    private final JLabel advertencia = new JLabel("No hay texto en en la caja");
    private final JTextField caja = new JTextField();
    private final JPanel panelPrincipal = new JPanel();

    /**
     * Constructor Main
     */
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

    /**
     * Creacion del panel principal
     */
    public void creacionPanel() {
        this.panelPrincipal.setLayout(new GridLayout(4, 5));
        this.agregarComponentes();
        this.advertencia.setForeground(Color.RED);
        this.setContentPane(this.panelPrincipal);
        this.setResizable(false);
    }

    /**
     * creacion de una lista donde agregaremos los componentes al panel principal
     */
    public void agregarComponentes() {
        Arrays.asList(this.label, this.caja, this.boton, this.advertencia).forEach(this.panelPrincipal::add);
    }

    /**
     * Agregamos el evento al boton
     */
    public void eventoBoton() {
        this.boton.addActionListener(e -> JOptionPane.showMessageDialog(this, this.caja.getText()));
    }

    /**
     * Agregamos los evento sobre la caja de texto usando una interfaz funcional
     */
    public void eventoCajaTexto() {
        this.caja.getDocument().addDocumentListener((CambioTextoFuncional)(t, e) -> this.validacionEventos());
    }

    /**
     * Establecemos el comportamiento de los componentes sobre los eventos
     */
    public void validacionEventos() {
        this.boton.setEnabled(this.caja.getText().length() > 0);
        this.advertencia.setForeground(
                this.caja.getText().length() == 0
                        ? Color.RED
                        // Estamos aninando ternarios uno dentro de otro
                        // Esto corresponderia con un else if siendo el ultimo el else del condicional
                        : (this.caja.getText().length() > 50 ? Color.GREEN : Color.BLACK)
        );
        this.advertencia.setText(
                this.caja.getText().length() > 0
                        ? "La longitud de la cadena de texto es " + this.caja.getText().length()
                        : "No hay texto en en la caja"
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
