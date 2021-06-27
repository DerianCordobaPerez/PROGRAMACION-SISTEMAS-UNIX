package com.pplam;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * @author derian-cordoba - 23/6/21
 * @project Ejercicio_01
 */

@FunctionalInterface
public interface CambioTextoFuncional extends DocumentListener {

    void evento(DocumentEvent.EventType type, DocumentEvent e);

    @Override
    default void insertUpdate(DocumentEvent e) {
        evento(e.getType(), e);
    }

    @Override
    default void removeUpdate(DocumentEvent e) {
        evento(e.getType(), e);
    }

    @Override
    default void changedUpdate(DocumentEvent e) {
        evento(e.getType(), e);
    }
}
