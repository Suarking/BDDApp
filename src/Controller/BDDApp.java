package Controller;

import View.*;

public class BDDApp {

    public static void main(String[] args) throws Exception {
        //CREAMOS LAS VISTAS

        MainWindow mainSPL = new MainWindow();
        SubwindowConnection subSPL = new SubwindowConnection();

        subSPL.disableonstart();
        
        //CREAMOS EL CONTROLADOR DE AMBAS VISTAS
        SubwindowConecctionControl subcontSPL = new SubwindowConecctionControl(subSPL, mainSPL);

    }

}
