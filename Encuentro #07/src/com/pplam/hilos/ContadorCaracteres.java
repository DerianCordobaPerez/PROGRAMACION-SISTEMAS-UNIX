package com.pplam.hilos;

import com.pplam.vistas.EditorVista;

/**
 * @author derian-cordoba - 6/7/21
 * @project Encuentro #07
 */
public record ContadorCaracteres(EditorVista editorVista) implements Runnable {

    @SuppressWarnings("InfiniteLoopStatement")
    @Override
    public void run() {
        while (true) {
            try {
                this.editorVista.cantidadCaracteres.setText("Cantidad de caracteres: " + (this.editorVista.textArea.getText().length() - this.editorVista.textArea.getLineCount() + 1));
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
