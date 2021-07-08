package com.pplam.herramientas;

import com.pplam.vistas.EditorVista;

import javax.swing.*;
import java.io.*;

/**
 * @author derian-cordoba - 7/7/21
 * @project Encuentro #07
 */
public final class VentanaArchivo {
    private final JFileChooser ventanaArchivo = new JFileChooser("f:");

    public void abrirArchivo(EditorVista editorVista) {
        if(this.ventanaArchivo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                String linea;
                BufferedReader buffer = new BufferedReader(new FileReader(this.ventanaArchivo.getSelectedFile().getAbsolutePath()));

                editorVista.textArea.setText("");
                while((linea = buffer.readLine()) != null)
                    editorVista.textArea.append(String.format("%s\n", linea));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void guardarArchivo(EditorVista editorVista) throws IOException {
        if(this.ventanaArchivo.showSaveDialog(editorVista) == JFileChooser.APPROVE_OPTION) {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(this.ventanaArchivo.getSelectedFile().getAbsolutePath()));
            escritor.write(editorVista.textArea.getText());
            escritor.flush();
            escritor.close();
        }
    }
}
