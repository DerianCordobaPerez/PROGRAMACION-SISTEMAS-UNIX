package com.pplam.vistas;

import com.pplam.componentes.MenuContextual;
import com.pplam.controladores.ComboControlador;
import com.pplam.controladores.BotonControlador;
import com.pplam.controladores.MenuArchivoControlador;
import com.pplam.controladores.MenuHerramientasControlador;
import com.pplam.hilos.ContadorCaracteres;
import com.pplam.hilos.ContadorFilas;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author derian-cordoba - 3/7/21
 * @project Encuentro #07
 */
public class EditorVista extends JFrame {
    public final JTextArea textArea = new JTextArea();
    public final JComboBox<String> fuentes = new JComboBox<>(), tamanios = new JComboBox<>();
    public final JLabel cantidadFilas = new JLabel("Cantidad de filas: 0"), cantidadCaracteres = new JLabel("Cantidad de caracteres: 0");
    public final JMenuBar barraMenu = new JMenuBar();
    public final JMenu menuArchivo = new JMenu("Archivo"), menuHerramientas = new JMenu("Herramientas");
    public final JMenuItem nuevoMenuArchivo = new JMenuItem("Nuevo"), abrirMenuArchivo = new JMenuItem("Abrir"), guardarMenuArchivo = new JMenuItem("Guardar"), imprimirMenuArchivo = new JMenuItem("Imprimir"), cerrarMenuArchivo = new JMenuItem("Cerrar");
    public final JCheckBoxMenuItem deshabilitarBarraSuperior = new JCheckBoxMenuItem("Deshabilitar menu superior");
    public final JToolBar barraSuperior = new JToolBar();
    private final JPanel panelPrincipal = new JPanel(), barraEstado = new JPanel();
    private final JScrollPane panelScroll = new JScrollPane(this.textArea);
    private final int inicio = 8, ultimo = 50;

    public EditorVista() {
        this.pack();
        this.setLocationRelativeTo(null);
        this.creacionPanel();
        this.setSize(800, 600);
        this.setTitle("Bloc de notas con hilos");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        new BotonControlador(this);
        new ComboControlador(this);
        new MenuArchivoControlador(this);
        new MenuHerramientasControlador(this);
        new MenuContextual().agregarMenuContextual(this.textArea);
        new Thread(new ContadorCaracteres(this)).start();
        new ContadorFilas(this).start();
    }

    private void creacionPanel() {
        this.panelPrincipal.setLayout(new BorderLayout());
        this.agregarComponentes();
        this.setContentPane(this.panelPrincipal);
        this.setResizable(false);
        this.agregarMenu();
        this.creacionBarraEstado();
        this.agregarFuentes();
        this.agregarTamanios();
    }

    private void creacionBarraEstado() {
        this.barraEstado.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.panelPrincipal.add(this.barraEstado, BorderLayout.SOUTH);
        this.barraEstado.setPreferredSize(new Dimension(this.panelPrincipal.getWidth(), 30));
        this.barraEstado.setLayout(new BoxLayout(this.barraEstado, BoxLayout.X_AXIS));
        this.cantidadFilas.setHorizontalAlignment(SwingUtilities.LEFT);
        this.cantidadCaracteres.setHorizontalAlignment(SwingUtilities.CENTER);
    }

    private void agregarComponentes() {
        Arrays.asList(this.fuentes, this.tamanios).forEach(this.barraSuperior::add);
        this.panelPrincipal.add(this.barraSuperior, BorderLayout.NORTH);
        Collections.singletonList(this.panelScroll).forEach(this.panelPrincipal::add);
        Arrays.asList(this.cantidadFilas, new JToolBar.Separator(), this.cantidadCaracteres).forEach(this.barraEstado::add);
    }

    private void agregarMenu() {
        this.setJMenuBar(this.barraMenu);
        this.agregarMenuItems();
        Arrays.asList(this.menuArchivo, this.menuHerramientas).forEach(this.barraMenu::add);
    }

    private void agregarMenuItems() {
        Arrays.asList(this.nuevoMenuArchivo, this.abrirMenuArchivo, this.guardarMenuArchivo, new JPopupMenu.Separator(), this.imprimirMenuArchivo, new JPopupMenu.Separator(), this.cerrarMenuArchivo).forEach(this.menuArchivo::add);
        Arrays.asList(this.deshabilitarBarraSuperior).forEach(this.menuHerramientas::add);
    }

    private void agregarFuentes() {
        for(String fuente : GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames())
            this.fuentes.addItem(fuente);
    }

    private void agregarTamanios() {
        for(int i = this.inicio; i <= this.ultimo; i += 2)
            this.tamanios.addItem(String.valueOf(i));
    }

}
