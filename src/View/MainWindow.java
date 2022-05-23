package View;

import Controller.MainWindowControl;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class MainWindow extends JFrame{

    //OPCIONES DEL MENÚ SUPERIOR
    JMenuItem optionConectar;
    JMenuItem optionDesconectar;
    JMenuItem optionAbrir;
    JMenuItem optionMostrar;

    //OPCIONES DEL MENÚ SERVIDOR
    JMenuItem servidorOption;
    JMenuItem conectarOption;
    JMenuItem desconectarOption;
    //BASE DE DATOS
    JMenuItem bddOption;
    JMenuItem abrirOption;
    //TABLA
    JMenuItem tablaOption;
    JMenuItem mostrarOption;

    //MARCOS SECUNDARIOS
    //PANEL CONEXION, ETIQUETAS
    JLabel etiUsuario;
    JLabel etiUsuarioShow;
    JLabel etiPuerto;
    JLabel etiPuertoShow;
    JLabel etiConectado;

    //PANEL BDD, ETIQUETAS, TEXTFIELD
    JLabel etiNombreBDD;
    JLabel etiNombreBDDShow;
    JTextField bddTextfield;

    //PANEL TABLA, ETIQUETAS, TEXTFIELD
    JLabel etiNombreTabla;
    JLabel etiNombreTablaShow;
    JTextField tablaTextfield;

    //PANEL MOSTRARTABLA
    //ETIQUETAS, TEXTFIELD
    JComboBox etiListaProvisional;
    JLabel etiListaProvisional2;
    JTable ta;

    //PANEL INFORMACIÓN
    JLabel etiInformacion;

    public MainWindow() {

        //===========MARCO PRINCIPAL===========
        JFrame MainWindow = new JFrame();
        MainWindow.setSize(900, 450);        //DIMENSIONES
        MainWindow.setResizable(false);      //NO REDIMENSIONABLE
        MainWindow.setLocationRelativeTo(null);      //CENTRADA
        MainWindow.setTitle("Database App Suar PL");      //TÍTULO

        //==========PANEL PRINCIPAL===========
        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 900, 450);

        //----------------------------------------------------------
        //==========MENÚ SUPERIOR===========
        JMenuBar mb = new JMenuBar();
        mb.setPreferredSize(new Dimension(900, 20));
        //ELEMENTOS DEL MENÚ
        JMenu m1 = new JMenu("Servidor");
        JMenu m2 = new JMenu("Base de Datos");
        JMenu m3 = new JMenu("Tabla");

        //OPCIONES DEL MENÚ
        optionConectar = new JMenuItem("Conectar");
        optionDesconectar = new JMenuItem("Desconectar");
        optionDesconectar.setEnabled(false); //DESHABILITADO POR DEFECTO
        optionAbrir = new JMenuItem("Abrir");
        optionAbrir.setEnabled(false);      //DESHABILITADO POR DEFECTO
        optionMostrar = new JMenuItem("Mostrar");
        optionMostrar.setEnabled(false); //DESHABILITADO POR DEFECTO

        //AÑADIR OPCIONES A LOS ELEMENTOS
        m1.add(optionConectar);
        m1.add(optionDesconectar);
        m2.add(optionAbrir);
        m3.add(optionMostrar);

        //AÑADIR ELEMENTOS AL MENÚ
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);

        //==========PANEL DE CONEXIÓN==========
        JPanel conexPanel = new JPanel();
        conexPanel.setBorder(BorderFactory.createTitledBorder("Datos de la conexión"));
        conexPanel.setLayout(new FlowLayout(1, 90, 3));
        conexPanel.setBounds(0, 0, 900, 50);
        conexPanel.setEnabled(false); //DESHABILITADO POR DEFECTO

        //OBJETOS DE PANEL DE CONEXIÓN
        etiUsuario = new JLabel("Usuario: ");
        etiUsuarioShow = new JLabel("root");
        etiUsuarioShow.setForeground(Color.BLUE);
        etiPuerto = new JLabel("Puerto: ");
        etiPuertoShow = new JLabel("3307");
        etiPuertoShow.setForeground(Color.BLUE);
        etiConectado = new JLabel("Desconectado");
        etiConectado.setForeground(Color.RED); //Color por defecto

        //AÑADIENDO OBJETOS AL PANEL
        conexPanel.add(etiUsuario);
        conexPanel.add(etiUsuarioShow);
        conexPanel.add(etiPuerto);
        conexPanel.add(etiPuertoShow);
        conexPanel.add(etiConectado);

        //-----------------------------------------------------------
        //==========PANEL DE BASE DE DATOS==============
        JPanel bddPanel = new JPanel();
        bddPanel.setBorder(BorderFactory.createTitledBorder("Base de datos"));
        bddPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        bddPanel.setEnabled(false); //DESHABILITADO POR DEFECTO

        etiNombreBDD = new JLabel("Nombre: ");
        bddTextfield = new JTextField();
        bddTextfield.setColumns(68);
        bddTextfield.setEnabled(false);
        etiNombreBDDShow = new JLabel("infodata");
        etiNombreBDDShow.setForeground(Color.BLUE);

        //OBJETOS DE PANEL DE BDD
        bddPanel.add(etiNombreBDD);
        bddPanel.add(bddTextfield);
        bddPanel.add(etiNombreBDDShow);

        //-----------------------------------------------------------
        //PANEL TABLA
        JPanel tablaPanel = new JPanel();
        tablaPanel.setBorder(BorderFactory.createTitledBorder("Tabla"));
        tablaPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        tablaPanel.setEnabled(false);  //DESHABILITADO POR DEFECTO

        etiNombreTabla = new JLabel("Nombre: ");
        tablaTextfield = new JTextField();
        tablaTextfield.setColumns(73);
        tablaTextfield.setEnabled(false);

        //OBJETOS DE PANEL DE TABLA
        tablaPanel.add(etiNombreTabla);
        tablaPanel.add(tablaTextfield);

        //-----------------------------------------------------------
        //PANEL MOSTRAR TABLA
        JPanel mostrarTablaPanel = new JPanel();
        mostrarTablaPanel.setPreferredSize(new Dimension(878, 165));
        mostrarTablaPanel.setBorder(BorderFactory.createTitledBorder("Mostrar tabla"));
        mostrarTablaPanel.setLayout(new FlowLayout(1, 50, 0));
        mostrarTablaPanel.setEnabled(false);  //DESHABILITADO POR DEFECTO

        etiListaProvisional = new JComboBox();
        etiListaProvisional.setPrototypeDisplayValue("XXXXXXXXXXXX");
        etiListaProvisional.setEnabled(false);

        mostrarTablaPanel.add(etiListaProvisional);

        ta = new JTable();
        ta.setPreferredScrollableViewportSize(new Dimension(620, 120));
        JScrollPane sp = new JScrollPane(ta);
        mostrarTablaPanel.add(sp);

        //-----------------------------------------------------------
        //PANEL INFORMACIÓN
        JPanel infoPanel = new JPanel();
        infoPanel.setPreferredSize(new Dimension(870, 45));
        infoPanel.setBorder(BorderFactory.createTitledBorder("Información"));
        infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        etiInformacion = new JLabel("Información");

        //OBJETOS DE PANEL DE TABLA
        infoPanel.add(etiInformacion);

        //AÑADIENDO PANELES AL PANEL PRINCIPAL
        mainPanel.add(mb);
        mainPanel.add(conexPanel);
        mainPanel.add(bddPanel);
        mainPanel.add(tablaPanel);
        mainPanel.add(mostrarTablaPanel);
        mainPanel.add(infoPanel);

        //AÑADIENDO EL CONTENIDO DEL PANEL PRINCIPAL AL FRAME
        MainWindow.getContentPane().add(mainPanel);

        MainWindow.setVisible(true);     //VISIBILIDAD
        MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//CERRAR AL SALIR
        
        
        
        
        //LISTENERS PRUEBA
        optionConectar.addActionListener(new MainWindowControl(this));      //MANDA CONTROL AL CONTROLADOR CORRESPONDIENTE
        
        optionConectar.addActionListener(new ActionListener() {     //PRUEBA, LO GESTIONA DESDE AQUÍ
            @Override
            public void actionPerformed(ActionEvent e) {
                SubwindowConnection subSPL = new SubwindowConnection();

            }
        });
                

        
    }

}
