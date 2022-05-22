package controlador;

import db.usuarioSchema;

import javax.swing.*;

public class usuariosController {
    usuarioSchema schema = new usuarioSchema();

    public usuariosController() {
    }

    public void CrearUsuario(){
        String nombreusuario = JOptionPane.showInputDialog("NOMBRE DE USUARIO:");
        String clave = JOptionPane.showInputDialog("CONTRASEÑA:");

        schema.create(nombreusuario, clave);
    }

    public void VerUsuarios(){
        schema.readAll();
    }

    public void buscarUsuario(){
        String nombreusuario = JOptionPane.showInputDialog("DIGITE EL NOMBRE DE LA CUENTA QUE DESEA BUSCAR:");
        schema.read(nombreusuario);
    }

    public void editarUsuario(){
        String bus = JOptionPane.showInputDialog("NOMBRE DE USUARIO AL CUAL EDITAR:");
        String nuevouser = JOptionPane.showInputDialog("NUEVO NOMBRE DE USUARIO:");
        String nuevaclave = JOptionPane.showInputDialog("NUEVA CONTRASEÑA:");

        schema.update(bus, nuevouser, nuevaclave);
    }

    public void borrarUsuario(){
        String bus = JOptionPane.showInputDialog("NOMBRE DE USUARIO A ELIMINAR: ");
        schema.delete(bus);
    }
}
