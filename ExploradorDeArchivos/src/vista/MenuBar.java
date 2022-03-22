package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuBar extends JMenuBar {

    private JMenu appsMenu, officeMenu, toolsMenu, cmdMenu, pcMenu;

    public MenuBar(){

        /* Menus principales */
        appsMenu=new JMenu("Aplicaciones");
        cmdMenu=new JMenu("Terminal");
        pcMenu=new JMenu("Configuracion del PC");
        add(appsMenu);
        add(cmdMenu);
        add(pcMenu);

        /* Submenus del menu de princiapl */
        officeMenu=new JMenu("Office");
        appsMenu.add(officeMenu);
        toolsMenu=new JMenu("Herramientas");
        appsMenu.add(toolsMenu);

        /* Items del menu de Office*/
        JMenuItem menuItem21=new JMenuItem("Word");
        officeMenu.add(menuItem21);

        JMenuItem menuItem22=new JMenuItem("Excel");
        officeMenu.add(menuItem22);

        JMenuItem menuItem23=new JMenuItem("Paint");
        officeMenu.add(menuItem23);


        /* Items del menu de herramientas */
        JMenuItem menuItem31=new JMenuItem("Bloc de notas");
        toolsMenu.add(menuItem31);

        JMenuItem menuItem32=new JMenuItem("Calculadora");
        toolsMenu.add(menuItem32);

    }

}
