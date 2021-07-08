package com.pplam.controladores;

import com.pplam.herramientas.VentanaArchivo;
import com.pplam.vistas.EditorVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.IOException;

/**
 * @author derian-cordoba - 7/7/21
 * @project Encuentro #07
 */
public record MenuArchivoControlador(EditorVista editorVista) implements ActionListener {

    public MenuArchivoControlador(EditorVista editorVista) {
        this.editorVista = editorVista;
        this.generarEventos();
    }

    private void generarEventos() {
        this.editorVista.nuevoMenuArchivo.addActionListener(this);
        this.editorVista.abrirMenuArchivo.addActionListener(this);
        this.editorVista.imprimirMenuArchivo.addActionListener(this);
        this.editorVista.guardarMenuArchivo.addActionListener(this);
        this.editorVista.cerrarMenuArchivo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Nuevo")) {
            if(this.guardarArchivoConAlerta()) return;
            this.editorVista.textArea.setText("");
        }

        if(e.getActionCommand().equalsIgnoreCase("Abrir")) {
            if (this.guardarArchivoConAlerta()) return;
            new VentanaArchivo().abrirArchivo(this.editorVista);
        }

        if(e.getActionCommand().equalsIgnoreCase("Guardar")) {
            try {
                new VentanaArchivo().guardarArchivo(this.editorVista);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        if(e.getActionCommand().equalsIgnoreCase("Imprimir")) {
            try {
                if(this.editorVista.textArea.getText().length() > 0)
                    this.editorVista.textArea.print();
                else
                    JOptionPane.showMessageDialog(this.editorVista, "No hay caracteres para imprimir");
            } catch (PrinterException printerException) {
                printerException.printStackTrace();
            }
        }

        if(e.getActionCommand().equalsIgnoreCase("Cerrar")) {
            if (this.guardarArchivoConAlerta()) return;
            this.editorVista.dispose();
            System.exit(0);
        }
    }

    private boolean guardarArchivoConAlerta() {
        if(this.editorVista.textArea.getText().length() > 0) {
            int opcion = JOptionPane.showConfirmDialog(this.editorVista, "Quieres guardar el documento");
            if(opcion == JOptionPane.OK_OPTION)
                try {
                    new VentanaArchivo().guardarArchivo(this.editorVista);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            else return opcion == JOptionPane.CANCEL_OPTION;
        }
        return false;
    }
}
