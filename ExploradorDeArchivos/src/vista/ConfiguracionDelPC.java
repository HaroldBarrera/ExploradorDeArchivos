package vista;

import javax.swing.*;

public class ConfiguracionDelPC extends JFrame {

    public ConfiguracionDelPC(){
        setTitle("CONFIGURACION DEL PC");
        setSize(550, 550);
        setVisible(true);
        setLayout(null);

        JPanel memoria = memInfo();
        add(memoria);

        JPanel pc = pcInfo();
        add(pc);
    }

    public JPanel memInfo(){
        JPanel meminfo = new JPanel();
        meminfo.setBorder(BorderFactory.createTitledBorder("MEMORIA"));
        meminfo.setBounds(10,0,250,250);
        //Datos de la memoria
        Runtime runtime = Runtime.getRuntime();
        int dataSize = 1024 * 1024;
        String memMax = "Memoria máxima: " + runtime.maxMemory() / dataSize + "MB";
        String memTotal = "Memoria total: " + runtime.totalMemory() / dataSize + "MB";
        String memLibre = "Memoria libre: " + runtime.freeMemory() / dataSize + "MB";
        String memUsada = "Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / dataSize + "MB";

        JLabel l1 = new JLabel(memMax);
        JLabel l2 = new JLabel(memTotal);
        JLabel l3 = new JLabel(memLibre);
        JLabel l4 = new JLabel(memUsada);

        meminfo.add(l1);
        meminfo.add(l2);
        meminfo.add(l3);
        meminfo.add(l4);

        return meminfo;
    }

    public JPanel pcInfo(){
        JPanel pcinfo = new JPanel();
        pcinfo.setBorder(BorderFactory.createTitledBorder("PC"));
        pcinfo.setBounds(260,0,250,250);

        String sSistemaOperativo = System.getProperty("os.name");
        String sSistemaOperativoVersion = System.getProperty("os.version");
        String sSistemaOperativoArquitectura = System.getProperty("os.arch");
        String sNombreUsuario = System.getProperty("user.name");
        String sJava = System.getProperty("java.version");

        JLabel l1 = new JLabel("Sistema operativo: " + sSistemaOperativo + sSistemaOperativoVersion);
        JLabel l2 = new JLabel("Arquitectura: " + sSistemaOperativoArquitectura);
        JLabel l3 = new JLabel("Usuario: " + sNombreUsuario);
        JLabel l4 = new JLabel("Java: " + sJava);

        pcinfo.add(l1);
        pcinfo.add(l2);
        pcinfo.add(l3);
        pcinfo.add(l4);


        return pcinfo;
    }
}
