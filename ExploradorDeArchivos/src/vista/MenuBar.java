package vista;

import controlador.MenuBarController;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar implements ActionListener, MenuListener {

    private JMenu appsMenu, officeMenu, toolsMenu, cmdMenu, pcMenu, userMenu;
    private JMenuItem notepad, calculator, word, excel, paint, vol, recortes;

    //Controlador
    MenuBarController controller = new MenuBarController();

    public MenuBar(){

        /* Menus principales */
        appsMenu=new JMenu("Aplicaciones");
        cmdMenu=new JMenu("Terminal");
        pcMenu=new JMenu("Configuracion del PC");
        userMenu = new JMenu("Cuentas");
        add(appsMenu);
        add(cmdMenu);
        add(pcMenu);
        add(userMenu);

        /* Submenus del menu de princiapl */
        officeMenu=new JMenu("Office");
        appsMenu.add(officeMenu);
        toolsMenu=new JMenu("Herramientas");
        appsMenu.add(toolsMenu);

        /* Items del menu de Office*/
        word=new JMenuItem("Word");
        officeMenu.add(word);

        excel=new JMenuItem("Excel");
        officeMenu.add(excel);

        paint=new JMenuItem("Paint");
        officeMenu.add(paint);


        /* Items del menu de herramientas */
        notepad=new JMenuItem("Bloc de notas");
        toolsMenu.add(notepad);

        calculator=new JMenuItem("Calculadora");
        toolsMenu.add(calculator);

        vol=new JMenuItem("Mezclador de volumen");
        toolsMenu.add(vol);

        recortes=new JMenuItem("Herramienta de recortes");
        toolsMenu.add(recortes);

        //Agregando las funciones
        //MenuListeners
        cmdMenu.addMenuListener(this);
        pcMenu.addMenuListener(this);
        userMenu.addMenuListener(this);

        //ActionListeners
        notepad.addActionListener(this);
        calculator.addActionListener(this);
        word.addActionListener(this);
        excel.addActionListener(this);
        paint.addActionListener(this);
        vol.addActionListener(this);
        recortes.addActionListener(this);

    }

    //ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == notepad){
            controller.AbrirBlocDeNotas();
        }

        if (e.getSource() == calculator){
            controller.AbrirCalculadora();
        }

        if (e.getSource() == word){
            controller.AbrirWord();
        }

        if (e.getSource() == excel){
            controller.AbrirExcel();
        }

        if (e.getSource() == paint){
            controller.AbrirPaint();
        }

        if (e.getSource() == vol){
            controller.AbrirMezcladorDeVolumen();
        }

        if (e.getSource() == recortes){
            controller.AbrirHerramientaDeRecortes();
        }
    }

    //MenuListener
    @Override
    public void menuSelected(MenuEvent e) {
        if (e.getSource() == cmdMenu){
            controller.AbrirTerminal();
        }

        if (e.getSource() == pcMenu){
            new ConfiguracionDelPC();
        }

        if (e.getSource() == userMenu){
            new UsuariosFrame();
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
