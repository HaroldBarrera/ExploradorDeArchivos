package controlador;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

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
}
