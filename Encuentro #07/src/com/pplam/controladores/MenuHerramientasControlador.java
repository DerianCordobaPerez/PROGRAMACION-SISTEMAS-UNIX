package com.pplam.controladores;

import com.pplam.Main;
import com.pplam.componentes.MenuContextual;
import com.pplam.herramientas.Buscador;
import com.pplam.vistas.EditorVista;

import javax.swing.*;
import javax.swing.text.Caret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author derian-cordoba - 8/7/21
 * @project Encuentro #07
 */
public record MenuHerramientasControlador(EditorVista editorVista) implements ActionListener {

    public MenuHerramientasControlador(EditorVista editorVista) {
        this.editorVista = editorVista;
        this.generarEventos();
    }

    private void generarEventos() {
        this.editorVista.buscarMenuHerramientas.addActionListener(this);
        this.editorVista.cambiarColorMenuHerramientas.addActionListener(this);
        this.editorVista.deshabilitarBarraSuperiorMenuHerramientas.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Buscar"))
            new Buscador().buscadorPalabra(this.editorVista);

        if(e.getActionCommand().equalsIgnoreCase("Cambiar color del fondo")) {
            this.editorVista.textArea.setBackground(JColorChooser.showDialog(this.editorVista, "Elige  el color", this.editorVista.textArea.getBackground()));
        }

        if(e.getActionCommand().equalsIgnoreCase("Deshabilitar menu superior"))
            this.editorVista.barraSuperior.setVisible(!((AbstractButton)e.getSource()).getModel().isSelected());
    }
}
