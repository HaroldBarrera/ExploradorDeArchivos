package controlador;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class archivosController {

    public archivosController() {
    }

    public void crearCarpeta(){
        String nombrecarpeta = JOptionPane.showInputDialog("DIGITE NOMBRE DE LA CARPETA A CREAR:");
        File directorio = new File("C:\\Users\\hsbar\\Desktop\\"+nombrecarpeta);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
    }

    public void borrarCarpeta(){
        String nombrecarpeta = JOptionPane.showInputDialog("DIGITE NOMBRE DE LA CARPETA A BORRAR:");
        File directorio = new File("C:\\Users\\hsbar\\Desktop\\"+nombrecarpeta);
        directorio.delete();
        if (!directorio.exists()) {
            System.out.println("Directorio borrado");
        }else{
            System.out.println("Error al borrar directorio");
        }
    }

    public void copiarCarpeta(){
        String nombrecarpeta = JOptionPane.showInputDialog("DIGITE NOMBRE DE LA CARPETA A COPIAR:");
        File directorio = new File("C:\\Users\\hsbar\\Desktop\\"+nombrecarpeta+"(copia)");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio copiado");
            } else {
                System.out.println("Error al copiar directorio");
            }
        }
    }

    public void crearArchivoDeTexto(){
        try {
            String nombretexto = JOptionPane.showInputDialog("DIGITE NOMBRE DEL ARCHIVO DE TEXTO A CREAR:");
            String ruta = "C:\\Users\\hsbar\\Desktop\\"+nombretexto+".txt";
            String contenido = JOptionPane.showInputDialog("DIGITE EL CONTENIDO DEL TEXTO:");
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moverArchivoDeTexto(){
        String carpeta1 = JOptionPane.showInputDialog("DIGITE NOMBRE DE LA CARPETA A INICIAL");
        String carpeta2 = JOptionPane.showInputDialog("DIGITE NOMBRE DE LA CARPETA A FINAL");
        Path origenPath = FileSystems.getDefault().getPath("C:\\Users\\hsbar\\Desktop\\"+carpeta1+"\\ejemplo1.txt");
        Path destinoPath = FileSystems.getDefault().getPath("C:\\Users\\hsbar\\Desktop\\"+carpeta2+"\\ejemplo1.txt");

        try {
            Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void copiarArchivoDeTexto(){

    }

    public void borrarArchivoDeTexto(){
        String arc = JOptionPane.showInputDialog("DIGITE EL NOMBRE DEL ARCHIVO A BORRAR: ");
        File fichero = new File("C:\\Users\\hsbar\\Desktop\\"+arc+".txt");
        fichero.delete();
        if (!fichero.exists())
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        else
            System.out.println("El fichero no puede ser borrado");
    }

    //Archivos del panel principal
    public void contarNumeroArchivos(String direccion){
        File folder = new File(direccion);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }

    //Archivos del Jtree
    public void TreefindContenido(String direccion, DefaultMutableTreeNode rama){
        File folder = new File(direccion);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
                DefaultMutableTreeNode node=new DefaultMutableTreeNode(listOfFiles[i].getName());
                rama.add(node);
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
                String carpeta = "\\" + listOfFiles[i].getName();
                String nuevaDireccion = direccion + carpeta;
                DefaultMutableTreeNode node=new DefaultMutableTreeNode(listOfFiles[i].getName());
                TreefindContenido(nuevaDireccion, node);
                rama.add(node);
            }
        }
    }
}
