package vista;

import javax.swing.*;
import java.awt.*;

public class inicio extends JFrame {

    MenuBar menu = new MenuBar();
    PanelAccesoRapido panel = new PanelAccesoRapido();
    Archivos archivos = new Archivos();

    public inicio(){
        setTitle("Explorador de archivos");
        setVisible(true);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(menu, BorderLayout.NORTH);
        add(panel);
        add(archivos, BorderLayout.WEST);
    }

    public static void main(String[] args) {
        new inicio();
    }

}
