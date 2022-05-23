package modelos;

import javax.swing.*;

public class directorio extends JLabel {
    String nombre;
    ImageIcon icono = new ImageIcon("directorio.png");

    public directorio(String nombre) {
        this.nombre = nombre;
        setIcon(icono);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
