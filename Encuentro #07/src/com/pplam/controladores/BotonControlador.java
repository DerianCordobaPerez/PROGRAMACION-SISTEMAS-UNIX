package com.pplam.controladores;

import com.pplam.vistas.EditorVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author derian-cordoba - 3/7/21
 * @project Encuentro #07
 */
public record BotonControlador(EditorVista editorVista) implements ActionListener {

    public BotonControlador(EditorVista editorVista) {
        this.editorVista = editorVista;
        this.generarEventos();
    }

    private void generarEventos() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
