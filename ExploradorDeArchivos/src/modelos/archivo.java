package modelos;

import javax.swing.*;

public class archivo extends JLabel{
    String nombre;
    ImageIcon icono = new ImageIcon("directorio.png");

    public archivo(String nombre) {
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
