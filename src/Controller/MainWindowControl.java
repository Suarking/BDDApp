package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.*;
import View.*;

public class MainWindowControl implements ActionListener {

    public MainWindow v;
    
    public MainWindowControl (MainWindow v){
        this.v = v;
        
        //ABRIR VENTANA CONEXIÓN
        v.optionConectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubwindowConnection subSPL = new SubwindowConnection();
                System.out.println("Creando subventana");
                

            }
        });
        //DESCONECTAR
        v.optionDesconectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Desconectar");
                Connect.Desconexion();

            }
        });
        
        
        
    }

    public MainWindowControl() {
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        

        
    }

}
