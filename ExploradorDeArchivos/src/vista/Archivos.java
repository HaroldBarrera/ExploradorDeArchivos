package vista;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class Archivos extends ScrollPane {

    public Archivos(){
        //Carpetas principales
        DefaultMutableTreeNode main=new DefaultMutableTreeNode("Explorador");

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
        DefaultMutableTreeNode red=new DefaultMutableTreeNode("red");
        DefaultMutableTreeNode blue=new DefaultMutableTreeNode("blue");
        DefaultMutableTreeNode black=new DefaultMutableTreeNode("black");
        DefaultMutableTreeNode green=new DefaultMutableTreeNode("green");
        images.add(red); images.add(blue); images.add(black); images.add(green);

        //Items de la carpeta documents
        DefaultMutableTreeNode tarea=new DefaultMutableTreeNode("tarea.txt");
        DefaultMutableTreeNode php=new DefaultMutableTreeNode("conexion.php");
        DefaultMutableTreeNode python=new DefaultMutableTreeNode("helloworld.py");
        documents.add(tarea); documents.add(php); documents.add(python);

        //Items de la carpeta documents
        DefaultMutableTreeNode netbeans=new DefaultMutableTreeNode("netbeans.exe");
        downloads.add(netbeans);

        //Creacion del JTree
        JTree jt=new JTree(main);

        //Añadir el JTree
        add(jt);
    }

}
