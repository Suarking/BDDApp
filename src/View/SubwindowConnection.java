
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SubwindowConnection {

    JLabel etiSubUser;
    JLabel etiSubPassword;
    JLabel etiSubPort;
    JTextField userSubTextField;
    JTextField passwordSubTextField;
    JTextField portSubTextField;
    
    //ESTADO DE LA CONEXIÓN
    JLabel etiStatus;
    

    
    //BOTONES
    JButton connectButton;
    JButton cancelButton;

    public SubwindowConnection() {
        //===========MARCO PRINCIPAL===========
        JFrame subWindow = new JFrame();
        subWindow.setSize(400, 300);        //DIMENSIONES
        subWindow.setResizable(false);      //NO REDIMENSIONABLE
        subWindow.setLocationRelativeTo(null);      //CENTRADA
        subWindow.setTitle("Servidor");      //TÍTULO

        //==========PANEL PRINCIPAL===========
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BorderLayout());
        

        //==========PANEL USER===============
        JPanel credentialsPanel = new JPanel();
        //credentialsPanel.setSize(380, 100);

        credentialsPanel.setLayout(new GridLayout(3, 2));

        etiSubUser = new JLabel("Usuario: ");
        etiSubPassword = new JLabel("Password: ");
        etiSubPort = new JLabel("Puerto: ");
        userSubTextField = new JTextField("root");
        passwordSubTextField = new JPasswordField();
        portSubTextField = new JTextField("3307");

        credentialsPanel.add(etiSubUser);
        credentialsPanel.add(userSubTextField);
        credentialsPanel.add(etiSubPassword);
        credentialsPanel.add(passwordSubTextField);
        credentialsPanel.add(etiSubPort);
        credentialsPanel.add(portSubTextField);

        
        
                
        //==========PANEL ESTADO===============
        
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new GridLayout(1, 2));
        statusPanel.setBackground(Color.CYAN);

        JLabel etiBlank = new JLabel("");
        etiStatus = new JLabel("ESTADO");
        
        statusPanel.add(etiBlank);
        statusPanel.add(etiStatus);
        
        
        //==========PANEL BOTONES CONECTAR===============
        
        JPanel connectPanel = new JPanel();
        connectPanel.setLayout(new FlowLayout());
        
        connectButton = new JButton("Conectar");
        cancelButton = new JButton("Aceptar");
        
        connectPanel.add(connectButton);
        connectPanel.add(cancelButton);
        
        
        
        
    

        
        
        //AÑADIR PANELES AL PRINCIPAL
        subPanel.add(credentialsPanel, BorderLayout.NORTH);
        subPanel.add(statusPanel, BorderLayout.CENTER);
        subPanel.add(connectPanel, BorderLayout.SOUTH);
        
        
        
        //AÑADIR CONTENIDO DE PRINCIPAL A FRAME
        subWindow.getContentPane().add(subPanel);
        

        subWindow.setVisible(true);     //VISIBILIDAD
        subWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //----------------------------------------------------------
        //LISTENERS
        
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               subWindow.setVisible(false);
            }
        });
        

        
    }
}
