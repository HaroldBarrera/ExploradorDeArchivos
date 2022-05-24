package modelos;

import javax.swing.*;
import java.awt.*;

public class directorio extends JLabel {
    String nombre;
    ImageIcon icono = new ImageIcon("directorio.png");
    int altura = 64;
    int ancho = altura + 100;

    public directorio(String nombre) {
        setText(nombre);
        setIcon(icono);
        //setBorder(BorderFactory.createLineBorder(Color.green));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAltura() {
        return altura;
    }

    public int getAncho() {
        return ancho;
    }
}
