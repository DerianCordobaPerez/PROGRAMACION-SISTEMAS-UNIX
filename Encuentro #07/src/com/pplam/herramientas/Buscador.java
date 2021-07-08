package com.pplam.herramientas;

import com.pplam.vistas.EditorVista;

import javax.swing.*;

/**
 * @author derian-cordoba - 8/7/21
 * @project Encuentro #07
 */
public record Buscador() {

    public void buscadorPalabra(EditorVista editorVista) {
        String textoBuscar = JOptionPane.showInputDialog(editorVista.textArea, "Ingrese el texto a buscar", editorVista.textArea.getSelectedText() == null ? "" : editorVista.textArea.getSelectedText());
        editorVista.textArea.setCaretPosition(editorVista.textArea.getText().indexOf(textoBuscar, editorVista.textArea.getCaret().getDot() != editorVista.textArea.getCaret().getMark() ? editorVista.textArea.getCaret().getDot() : 0));
        editorVista.textArea.moveCaretPosition(editorVista.textArea.getText().indexOf(textoBuscar, editorVista.textArea.getCaret().getDot() != editorVista.textArea.getCaret().getMark() ? editorVista.textArea.getCaret().getDot() : 0) + textoBuscar.length());
    }
}
