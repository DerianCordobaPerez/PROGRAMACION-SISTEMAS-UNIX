package com.pplam.componentes;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.*;
import java.util.Arrays;

/**
 * @author derian-cordoba - 7/7/21
 * @project Encuentro #07
 */
public class MenuContextual extends JPopupMenu {
    private final Clipboard clipboard;
    private final UndoManager manegador;
    private JMenuItem deshacer, rehacer, cortar, copiar, pegar, eliminar, seleccionarTodo;
    private JTextComponent componenteTexto;

    public MenuContextual()  {
        this.manegador = new UndoManager();
        this.clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        this.asignarItems();
        this.agregarItems();
    }

    private JMenuItem asignarPropiedadItems(String texto, int evento, ActionListener accion) {
        JMenuItem componente = new JMenuItem(texto);
        componente.setEnabled(false);
        componente.setAccelerator(KeyStroke.getKeyStroke(evento, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        componente.addActionListener(accion);
        return componente;
    }

    private void asignarItems()  {
        this.deshacer = this.asignarPropiedadItems("Deshacer", KeyEvent.VK_Z, e -> this.manegador.undo());
        this.rehacer = this.asignarPropiedadItems("Rehacer", KeyEvent.VK_Y, e -> this.manegador.redo());
        this.cortar = this.asignarPropiedadItems("Cortar", KeyEvent.VK_X, e -> this.componenteTexto.cut());
        this.copiar = this.asignarPropiedadItems("Copiar", KeyEvent.VK_C, e -> this.componenteTexto.copy());
        this.pegar = this.asignarPropiedadItems("Pegar", KeyEvent.VK_V, e -> this.componenteTexto.paste());
        this.eliminar = this.asignarPropiedadItems("Eliminar", KeyEvent.VK_DELETE, e -> this.componenteTexto.replaceSelection(""));
        this.seleccionarTodo = this.asignarPropiedadItems("Seleccionar Todo", KeyEvent.VK_A, e -> this.componenteTexto.selectAll());
    }

    private void agregarItems() {
        Arrays.asList(this.deshacer, this.rehacer, new Separator(), this.cortar, this.copiar, this.pegar, this.eliminar, new Separator(), this.seleccionarTodo).forEach(this::add);
    }

    private void agregarEventos(JTextComponent componenteTexto) {
        componenteTexto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent eventoPresionado) {
                if ((eventoPresionado.getKeyCode() == KeyEvent.VK_Z) && ((eventoPresionado.getModifiersEx() & Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()) != 0)) {
                    if (manegador.canUndo())
                        manegador.undo();
                }

                if ((eventoPresionado.getKeyCode() == KeyEvent.VK_Y) && ((eventoPresionado.getModifiersEx() & Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()) != 0)) {
                    if (manegador.canRedo())
                        manegador.redo();
                }
            }
        });

        componenteTexto.addMouseListener(new MouseAdapter()  {
            @Override
            public void mousePressed(MouseEvent e) {
                manejadorMenuContextual(e);
            }

            @Override
            public void mouseReleased(MouseEvent e)  {
                manejadorMenuContextual(e);
            }
        });

        componenteTexto.getDocument().addUndoableEditListener(e -> this.manegador.addEdit(e.getEdit()));
    }

    private void manejadorMenuContextual(MouseEvent e) {
        if (e.isPopupTrigger())
            procesoClick(e);
    }

    private void procesoClick(MouseEvent e)  {
        this.componenteTexto = (JTextComponent) e.getSource();
        this.componenteTexto.requestFocus();
        String textoSeleccionado = this.componenteTexto.getSelectedText(), texto = this.componenteTexto.getText();

        this.deshacer.setEnabled(this.manegador.canUndo());
        this.rehacer.setEnabled(this.manegador.canRedo());
        this.cortar.setEnabled(textoSeleccionado != null && textoSeleccionado.length() > 0);
        this.copiar.setEnabled(textoSeleccionado != null && textoSeleccionado.length() > 0);
        this.eliminar.setEnabled(textoSeleccionado != null && textoSeleccionado.length() > 0);
        this.pegar.setEnabled(this.clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor) && this.componenteTexto.isEnabled());
        this.seleccionarTodo.setEnabled(texto != null && texto.length() > 0);
        this.show(this.componenteTexto, e.getX(), e.getY());
    }

    public void agregarMenuContextual(JTextComponent componente)  {
        new MenuContextual().agregarEventos(componente);
    }
}
