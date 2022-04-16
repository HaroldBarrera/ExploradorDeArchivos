package controlador;

import java.io.IOException;

public class MenuBarController {

    public void AbrirTerminal() {
        try {
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \" cd C:\\");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AbrirBlocDeNotas() {
        try {
            Runtime.getRuntime().exec("notepad");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AbrirCalculadora() {
        try {
            Runtime.getRuntime().exec("calc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AbrirWord() {
        try {
            //String rutaWord = C:\Program Files\Microsoft Office\Office14\WINWORD.EXE;
            String rutaWord = "C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Word.EXE";
            Runtime.getRuntime().exec(rutaWord);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AbrirExcel() {
        try {
            Runtime.getRuntime().exec("excel");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AbrirPaint() {
        try {
            Runtime.getRuntime().exec("mspaint");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AbrirMezcladorDeVolumen() {
        try {
            Runtime.getRuntime().exec("sndvol");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AbrirInternetExplorer() {
        try {
            Runtime.getRuntime().exec("iexplore");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AbrirAdministradorDeTareas() {
        try {
            Runtime.getRuntime().exec("taskmgr");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AbrirServicios() {
        try {
            Runtime.getRuntime().exec("services.msc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AbrirHerramientaDeRecortes() {
        try {
            Runtime.getRuntime().exec("snippingtool");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
