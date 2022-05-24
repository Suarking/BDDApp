/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Connect;
import View.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SubwindowConecctionControl implements ActionListener {

    public SubwindowConnection s;
    public MainWindow m;

    public SubwindowConecctionControl(SubwindowConnection s, MainWindow m) throws Exception{
        this.s = s;
        this.m = m;
        
        m.optionConectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (s.subWindow.isVisible()) {
                        
                    } else {
                        s.subWindow.setVisible(true);
                    }
                    
                   

                } catch (Exception ex) {
                    Logger.getLogger(MainWindowControl.class.getName()).log(Level.SEVERE, null, ex);
                }
                

            }
        });

        s.connectButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                    

                try {
                    String user = s.userSubTextField.getText();
                    String port = s.portSubTextField.getText();
                    
                    //LLAMAMOS AL MÉTODO ESTÁTICO CONEXIÓN, PASANDO VALORES DE LOS JTEXTFIELD DE CREDENCIALES
                    Connect.Conexion(user, port);
                    //PASAMOS CREDENCIALES DE CONEXIÓN A PANEL PRINCIPAL
                    m.etiUsuarioShow.setText(user);
                    m.etiPuertoShow.setText(port);
                    m.etiConectado.setText("Conectado");
                    m.etiConectado.setForeground(Color.GREEN);
                    //FIJAMOS EL ESTADO EN CONECTAR
                    s.etiStatus.setText("CONECTADO");
                    //FIJAMOS LA INFO EN CONECTADO
                    m.etiInformacion.setText("CONECTADO AL SERVIDOR MYSQL");
                    m.conexPanel.setEnabled(true);
                    
                   
                    //DESHABILITAMOS CONECTAR EN EL MENÚ, HABILITAMOS DESCONECTAR
                    m.optionConectar.setEnabled(false);
                    m.optionDesconectar.setEnabled(true);
                    
                    //HABILITAMOS EL PANEL BASE DE DATOS Y ABRIR
                    m.bddTextfield.setEnabled(true);
                    m.optionAbrir.setEnabled(true);
                    
                } catch (Exception ex) {
                    s.etiStatus.setText("No ha sido posible conectar");
                }

                
            }
        });
        s.cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                s.subWindow.setVisible(false);
                
            }
        });
        
    }

    public SubwindowConecctionControl() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
