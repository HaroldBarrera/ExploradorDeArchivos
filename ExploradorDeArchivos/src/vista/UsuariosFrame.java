package vista;

import controlador.usuariosController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
                controller.CrearUsuario();
                actualizar();
            }
        });

        editar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.editarUsuario();
            }
        });

        eliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.borrarUsuario();
            }
        });

        ver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
        JPanel main = new JPanel();//Creando el JPanel
        //Elementos
        ArrayList<Object> cuentas = controller.VerUsuarios();
        JTextArea listacuentas = new JTextArea();
        listacuentas.setEditable(false);
        listacuentas.setBounds(0, 0, 500, 350);
        for(Object cuenta : cuentas){
            listacuentas.append(cuenta.toString() + "\n");
        }

        //Agregando los elementos
        JLabel prueba = new JLabel("AQUI IRA LOS USUARIOS");
        main.setBorder(BorderFactory.createLineBorder(Color.blue));
        main.add(listacuentas);

        //Regresando el JPanel creado
        return main;
    }

    private void actualizar(){
        this.setVisible(false);
        new UsuariosFrame();
    }
}
