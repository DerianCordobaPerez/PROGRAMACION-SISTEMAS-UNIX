package com.pplam.controladores;

import com.pplam.Main;
import com.pplam.componentes.MenuContextual;
import com.pplam.vistas.EditorVista;

import javax.swing.*;
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
        this.editorVista.deshabilitarBarraSuperior.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Deshabilitar menu superior"))
            this.editorVista.barraSuperior.setVisible(!((AbstractButton)e.getSource()).getModel().isSelected());
    }
}
