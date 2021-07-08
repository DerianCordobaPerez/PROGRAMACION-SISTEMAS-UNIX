package com.pplam.controladores;

import com.pplam.vistas.EditorVista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * @author derian-cordoba - 7/7/21
 * @project Encuentro #07
 */
public record ComboControlador(EditorVista editorVista) implements ActionListener {

    public ComboControlador(EditorVista editorVista) {
        this.editorVista = editorVista;
        this.generarEventos();
    }

    private void generarEventos() {
        this.editorVista.fuentes.addActionListener(this);
        this.editorVista.tamanios.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.editorVista.textArea.setFont(new Font(Objects.requireNonNull(
                this.editorVista.fuentes.getSelectedItem()).toString(),
                Font.PLAIN,
                Integer.parseInt(Objects.requireNonNull(this.editorVista.tamanios.getSelectedItem()).toString()))
        );
    }
}
