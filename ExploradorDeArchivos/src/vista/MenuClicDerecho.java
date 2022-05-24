package vista;

import controlador.archivosController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuClicDerecho extends JPopupMenu implements ActionListener {

    JMenu menuArchivos, menuDirectorios;
    JMenuItem addArchivo, moveArchivo, delArchivo, addCarpeta, copyCarpeta, delCarpeta;
    archivosController controller = new archivosController();

    public MenuClicDerecho() {
        menuArchivos = new JMenu("Archivo");
        menuDirectorios = new JMenu("Carpeta");

        add(menuArchivos);
        add(menuDirectorios);

        addArchivo = new JMenuItem("Crear archivo");
        moveArchivo = new JMenuItem("Mover archivo");
        delArchivo = new JMenuItem("Borrar archivo");
        menuArchivos.add(addArchivo);
        menuArchivos.add(moveArchivo);
        menuArchivos.add(delArchivo);

        addCarpeta = new JMenuItem("Crear carpeta");
        copyCarpeta = new JMenuItem("Copiar carpeta");
        delCarpeta = new JMenuItem("Borrar carpeta");
        menuDirectorios.add(addCarpeta);
        menuDirectorios.add(copyCarpeta);
        menuDirectorios.add(delCarpeta);

        addArchivo.addActionListener(this);
        moveArchivo.addActionListener(this);
        delArchivo.addActionListener(this);
        addCarpeta.addActionListener(this);
        copyCarpeta.addActionListener(this);
        delCarpeta.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addArchivo){
            controller.crearArchivoDeTexto();
        }

        if (e.getSource() == moveArchivo){
            controller.moverArchivoDeTexto();
        }

        if (e.getSource() == delArchivo){
            controller.borrarArchivoDeTexto();
        }

        if (e.getSource() == addCarpeta){
            controller.crearCarpeta();
        }

        if (e.getSource() == copyCarpeta){
            controller.copiarCarpeta();
        }

        if (e.getSource() == delCarpeta){
            controller.borrarCarpeta();
        }
    }
}
