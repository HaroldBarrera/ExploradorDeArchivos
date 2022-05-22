package vista;

import controlador.usuariosController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UsuariosFrame extends JFrame {

    usuariosController controller = new usuariosController();

    public UsuariosFrame() {
        setTitle("Gestion de cuentas");
        setVisible(true);
        setSize(600, 600);
        setLayout(null);

        JPanel crud = panelBotones();
        JPanel main = panelMain();
        crud.setBounds(0,400, 600, 200);
        main.setBounds(0,0, 600, 400);

        add(crud);
        add(main);
    }

    public JPanel panelBotones(){
        JPanel crud = new JPanel();//Creacion del JPanel

        //Elementos
        JLabel prueba = new JLabel("AQUI IRA LOS BOTONES DEL CRUD");
        JButton crear = new JButton("Crear cuenta");
        JButton editar = new JButton("Editar cuenta");
        JButton eliminar = new JButton("Eliminar cuenta");
        JButton ver = new JButton("Ver cuentas");

        //Logica de los botones
        crear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("CREAR");
                controller.CrearUsuario();
            }
        });

        editar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("EDITAR");
                controller.editarUsuario();
            }
        });

        eliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("ELIMINAR");
                controller.borrarUsuario();
            }
        });

        ver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("VER");
                controller.VerUsuarios();
                controller.buscarUsuario();
            }
        });

        //Agregando los elementos al JPanel
        crud.setBorder(BorderFactory.createLineBorder(Color.red));
        crud.add(crear);
        crud.add(editar);
        crud.add(eliminar);
        crud.add(ver);

        //Regresando el JPanel creado
        return crud;
    }

    public JPanel panelMain(){
        JPanel main = new JPanel();
        //main.setLayout(null);

        JLabel prueba = new JLabel("AQUI IRA LOS USUARIOS");
        main.setBorder(BorderFactory.createLineBorder(Color.blue));
        main.add(prueba);

        return main;
    }
}
