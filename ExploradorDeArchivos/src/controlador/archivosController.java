package controlador;

import javax.swing.*;
import java.io.File;

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
}
