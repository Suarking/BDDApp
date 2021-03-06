package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SubwindowConnection {

    public JLabel etiSubUser;
    public JLabel etiSubPassword;
    public JLabel etiSubPort;
    public JTextField userSubTextField;
    public JTextField passwordSubTextField;
    public JTextField portSubTextField;

    //ESTADO DE LA CONEXIÓN
    public JLabel etiStatus;

    //FRAME
    public JFrame subWindow;

    //PANELES
    public JPanel credentialsPanel;
    public JPanel statusPanel;
    public JPanel connectPanel;
    public JPanel subPanel;

    //BOTONES
    public JButton connectButton;
    public JButton cancelButton;

    public SubwindowConnection() throws Exception {
        //===========MARCO PRINCIPAL===========

        subWindow = new JFrame();
        subWindow.setSize(400, 300);        //DIMENSIONES
        subWindow.setResizable(false);      //NO REDIMENSIONABLE
        subWindow.setLocationRelativeTo(null);      //CENTRADA
        subWindow.setTitle("Servidor");      //TÍTULO

        //==========PANEL PRINCIPAL===========
        subPanel = new JPanel();
        subPanel.setLayout(new BorderLayout());

        //==========PANEL USER===============
        credentialsPanel = new JPanel();
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
        statusPanel = new JPanel();
        statusPanel.setLayout(new GridLayout(1, 2));
        statusPanel.setBackground(Color.CYAN);

        JLabel etiBlank = new JLabel("");
        etiStatus = new JLabel("ESTADO");

        statusPanel.add(etiBlank);
        statusPanel.add(etiStatus);

        //==========PANEL BOTONES CONECTAR===============
        connectPanel = new JPanel();
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
        //LISTENERS PRUEBA, EN REALIDAD LO GESTIONARÍA EN SUBWINDOWCONNECTIONCONTROL
        //.addActionListener(new SubwindowConecctionControl(this)); //MANDA CONTROL AL CONTROLADOR CORRESPONDIENTE
    }

    public void disableonstart() {
        subWindow.setVisible(false);
    }

}
