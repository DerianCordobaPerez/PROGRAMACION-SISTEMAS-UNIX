package com.pplam.hilos;

import com.pplam.vistas.EditorVista;

/**
 * @author derian-cordoba - 4/7/21
 * @project Encuentro #07
 */
public class ContadorFilas extends Thread{
    private final EditorVista editorVista;

    public ContadorFilas(EditorVista editorVista) {
        this.editorVista = editorVista;
    }

    @SuppressWarnings("InfiniteLoopStatement")
    @Override
    public void run() {
        while(true)
            this.editorVista.cantidadFilas.setText("Cantidad de lineas: " + (this.editorVista.textArea.getLineCount()));
    }
}
