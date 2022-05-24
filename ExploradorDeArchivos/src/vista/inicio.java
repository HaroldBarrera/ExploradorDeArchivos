package vista;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import db.MongoConnector;

import javax.swing.*;
import java.awt.*;

public class inicio extends JFrame {

    MenuBar menu = new MenuBar();
    PanelAccesoRapido panel = new PanelAccesoRapido();
    Archivos archivos = new Archivos();

    public inicio(){
        setTitle("Explorador de archivos");
        setVisible(true);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(menu, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(panel);
        add(scrollPane);
        add(archivos, BorderLayout.WEST);
    }

    public static void main(String[] args) {
        new inicio();
        /*MongoConnector db = new MongoConnector();
        MongoDatabase prueba = db.Conectar();
        System.out.println(prueba.getName());*/
    }

}
