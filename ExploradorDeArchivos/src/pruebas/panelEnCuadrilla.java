package pruebas;
import javax.swing.*;
import java.awt.*;

public class panelEnCuadrilla extends JPanel {
    static int WIDTH = 400;
    static int HEIGHT = 400;
    static int UNIDADES_SIZE = 25;
    static int UNIDADES = (WIDTH * HEIGHT)/UNIDADES_SIZE;
    final int x[] = new int[UNIDADES];
    final int y[] = new int[UNIDADES];

    panelEnCuadrilla(){
        setBounds(0, 0, WIDTH, HEIGHT);
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        for (int i = 0; i < HEIGHT/UNIDADES_SIZE; i++) {
            g.drawLine(i * UNIDADES_SIZE, 0, i * UNIDADES_SIZE, HEIGHT);
            g.drawLine(0, i * UNIDADES_SIZE, WIDTH, i * UNIDADES_SIZE);
        }
    }

    public static void main(String[] args) {
        JFrame main = new JFrame();
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setSize(390, 385);
        main.add(new panelEnCuadrilla());
        main.setVisible(true);
    }
}

