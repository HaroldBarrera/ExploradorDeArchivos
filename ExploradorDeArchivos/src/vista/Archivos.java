package vista;

import controlador.archivosController;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class Archivos extends ScrollPane {

    archivosController controller = new archivosController();

    public Archivos(){
        //Carpetas principales
        DefaultMutableTreeNode main=new DefaultMutableTreeNode("User");

        //Carpetas secundarias
        DefaultMutableTreeNode documents=new DefaultMutableTreeNode("Documentos");
        DefaultMutableTreeNode images=new DefaultMutableTreeNode("Imagenes");
        DefaultMutableTreeNode downloads=new DefaultMutableTreeNode("Descargas");
        DefaultMutableTreeNode desktop=new DefaultMutableTreeNode("Escritorio");
        main.add(documents);
        main.add(images);
        main.add(downloads);
        main.add(desktop);

        //Items de la carpeta images
        controller.TreefindContenido("C:\\Users\\hsbar\\Pictures", images);

        //Items de la carpeta documents
        //controller.TreefindContenido("C:\\Users\\hsbar\\Documents", documents);

        //Items de la carpeta download
        controller.TreefindContenido("C:\\Users\\hsbar\\Downloads", downloads);

        //Items de la carpeta desktop
        //controller.TreefindContenido("C:\\Users\\hsbar\\Desktop", desktop);

        //Creacion del JTree
        JTree jt=new JTree(main);

        //Añadir el JTree
        add(jt);
    }

}
