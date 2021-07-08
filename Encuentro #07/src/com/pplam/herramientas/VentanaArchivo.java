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

    public String abrirArchivo() {
        if(this.ventanaArchivo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                String linea, contenido;
                BufferedReader buffer = new BufferedReader(new FileReader(this.ventanaArchivo.getSelectedFile().getAbsolutePath()));

                contenido = buffer.readLine();
                while((linea = buffer.readLine()) != null)
                    contenido = String.format("%s\n%s", contenido, linea);

                return contenido;
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public void guardarArchivo(EditorVista editorVista) throws IOException {
        if(this.ventanaArchivo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(this.ventanaArchivo.getSelectedFile().getAbsolutePath()));
            escritor.write(editorVista.textArea.getText());
            escritor.flush();
            escritor.close();
        }
    }
}
