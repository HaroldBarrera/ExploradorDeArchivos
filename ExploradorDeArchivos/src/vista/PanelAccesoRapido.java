package vista;

import controlador.archivosController;
import controlador.usuariosController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelAccesoRapido extends JPanel {

    archivosController controller = new archivosController();

    public PanelAccesoRapido(){
        setLayout(null);
        setBackground(Color.white);

        JLabel c1 = new JLabel("Documentos");
        c1.setIcon(new ImageIcon("carpeta.png"));
        c1.setBounds(50, 50, 250, 250);

        JLabel c2 = new JLabel("Imagenes");
        c2.setIcon(new ImageIcon("carpeta.png"));
        c2.setBounds(350, 50, 250, 250);

        JLabel c3 = new JLabel("Descargas");
        c3.setIcon(new ImageIcon("carpeta.png"));
        c3.setBounds(50, 250, 250, 250);

        JLabel computador = new JLabel("PC");
        computador.setIcon(new ImageIcon("computador.png"));
        computador.setBounds(350, 250, 250, 250);
        computador.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ConfiguracionDelPC();
            }
        });

        add(c1);
        add(c2);
        add(c3);
        add(computador);

        this.setComponentPopupMenu(new MenuClicDerecho());

        //Login de usuarios
        JPanel usuarios = panelLoginUsuario();
        usuarios.setBounds(0,0, 685, 35);
        add(usuarios);
    }

    public JPanel panelLoginUsuario(){
        JPanel user = new JPanel();
        user.setBorder(BorderFactory.createLineBorder(Color.blue));

        JLabel usuario = new JLabel("CONECTADO COMO:");
        JLabel nombreusuario = new JLabel("prueba");

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
        return user;
    }
}
