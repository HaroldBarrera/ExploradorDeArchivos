package vista;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class Archivos extends ScrollPane {

    public Archivos(){
        //Carpetas principales
        DefaultMutableTreeNode style=new DefaultMutableTreeNode("Style");

        //Carpetas secundarias
        DefaultMutableTreeNode color=new DefaultMutableTreeNode("color");
        DefaultMutableTreeNode font=new DefaultMutableTreeNode("font");
        style.add(color);
        style.add(font);

        //Items de la carpeta color
        DefaultMutableTreeNode red=new DefaultMutableTreeNode("red");
        DefaultMutableTreeNode blue=new DefaultMutableTreeNode("blue");
        DefaultMutableTreeNode black=new DefaultMutableTreeNode("black");
        DefaultMutableTreeNode green=new DefaultMutableTreeNode("green");
        color.add(red); color.add(blue); color.add(black); color.add(green);

        //Creacion del JTree
        JTree jt=new JTree(style);

        add(jt);
    }

}
