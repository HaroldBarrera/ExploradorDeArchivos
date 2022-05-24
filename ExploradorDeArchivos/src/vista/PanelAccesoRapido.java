package vista;

import controlador.archivosController;
import controlador.usuariosController;
import modelos.archivo;
import modelos.directorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PanelAccesoRapido extends JPanel {

    archivosController controller = new archivosController();
    static int WIDTH = 700;
    static int HEIGHT = 700;

    public PanelAccesoRapido(){
        setLayout(null);
        setBackground(Color.white);
        setSize(WIDTH, HEIGHT);

        this.setComponentPopupMenu(new MenuClicDerecho());

        //Direccion
        JPanel contenido = panelDirectorio();
        contenido.setBounds(0, 80, 685, 40);
        add(contenido);

        //Login de usuarios
        JPanel usuarios = panelLoginUsuario();
        usuarios.setBounds(0,0, 685, 80);
        add(usuarios);
    }

    private JPanel verArchivosCarpetas(ArrayList<ArrayList<String>> contenido){
        JPanel panelContenido = new JPanel();
        panelContenido.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        panelContenido.setLayout(null);

        //Logica
        ArrayList<String> archivos = contenido.get(0);
        ArrayList<String> carpetas = contenido.get(1);
        int separadorX = 0;
        int separadorY = 0;
        int contadorX = 1;
        System.out.println("--------ARCHIVOS-------");
        for (int i = 0; i < archivos.size(); i++) {
            System.out.println("contador: " + contadorX);
            if (contadorX < 4){
                archivo nuevo = new archivo(archivos.get(i));
                nuevo.setBounds(separadorX, separadorY, nuevo.getAncho(), nuevo.getAltura());
                separadorX += nuevo.getAncho();
                contadorX++;
                panelContenido.add(nuevo);
            }else{
                archivo nuevo = new archivo(archivos.get(i));
                nuevo.setBounds(separadorX, separadorY, nuevo.getAncho(), nuevo.getAltura());
                separadorX = 0;
                separadorY += nuevo.getAltura();
                contadorX = 1;
                panelContenido.add(nuevo);
            }
        }
        System.out.println("-----------------------");
        System.out.println("--------CARPETAS-------");
        for (int i = 0; i < carpetas.size(); i++) {
            System.out.println("contador: " + contadorX);
            if (contadorX < 4){
                directorio nuevo = new directorio(carpetas.get(i));
                nuevo.setBounds(separadorX, separadorY, nuevo.getAncho(), nuevo.getAltura());
                separadorX += nuevo.getAncho();
                contadorX++;
                panelContenido.add(nuevo);
            }else{
                directorio nuevo = new directorio(carpetas.get(i));
                nuevo.setBounds(separadorX, separadorY, nuevo.getAncho(), nuevo.getAltura());
                separadorX = 0;
                separadorY += nuevo.getAltura();
                contadorX = 1;
                panelContenido.add(nuevo);
            }
        }
        System.out.println("-----------------------");

        return panelContenido;
    }

    public JPanel panelDirectorio(){
        JPanel lugar = new JPanel();
        lugar.setBorder(BorderFactory.createLineBorder(Color.red));

        JTextField direccion = new JTextField("", 40);
        JButton btnCambiarDireccion = new JButton("CAMBIAR");

        String prueba1 = "C:\\Users\\hsbar\\Desktop\\Prueba";
        String prueba2 = "C:\\Users\\hsbar\\Desktop";
        String prueba3 = "C:\\Users\\hsbar\\Desktop\\criptografia";
        direccion.setText(prueba2);
        //actualizarContenido(controller.contarNumeroArchivos(direccion.getText()));

        JPanel visual = verArchivosCarpetas(controller.contarNumeroArchivos(direccion.getText()));
        visual.setBounds(0, 120, 685, 500);
        this.add(visual);

        btnCambiarDireccion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.contarNumeroArchivos(direccion.getText());
            }
        });

        lugar.add(direccion);
        lugar.add(btnCambiarDireccion);

        return lugar;
    }

    public JPanel panelLoginUsuario(){
        JPanel user = new JPanel();
        user.setBorder(BorderFactory.createLineBorder(Color.blue));

        JLabel usuario = new JLabel("CONECTADO COMO:");
        JLabel nombreusuario = new JLabel("prueba");
        JLabel computador = new JLabel("PC");
        computador.setIcon(new ImageIcon("computador.png"));
        computador.setBounds(350, 250, 250, 250);
        computador.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ConfiguracionDelPC();
            }
        });
        usuariosController usercontroller = new usuariosController();
        nombreusuario.setText(usercontroller.IniciarSesion());

        JButton signin = new JButton("CAMBIAR CUENTA");
        signin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nombreusuario.setText(usercontroller.IniciarSesion());
            }
        });

        user.add(usuario);
        user.add(nombreusuario);
        user.add(signin);
        user.add(computador);
        return user;
    }
}
