package com.pplam;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * @author derian-cordoba - 16/6/21
 * @project Ejercicio_01
 */

@FunctionalInterface
public interface CambioTexto extends DocumentListener {

    void evento(DocumentEvent.EventType type, DocumentEvent e);

    @Override
    default void insertUpdate(DocumentEvent e) {
        this.evento(e.getType(), e);
    }

    @Override
    default void removeUpdate(DocumentEvent e) {
        this.evento(e.getType(), e);
    }

    @Override
    default void changedUpdate(DocumentEvent e) {
        this.evento(e.getType(), e);
    }
}
