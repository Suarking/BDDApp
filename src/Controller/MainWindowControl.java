package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.*;
import View.*;
import java.awt.Color;
import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainWindowControl implements ActionListener {

    public MainWindow m;
    public DefaultTableModel tmodelo;
    public JTable ta;
    public DefaultComboBoxModel cmodelo;

    public MainWindowControl(MainWindow m) {
        this.m = m;

        //ABRIR VENTANA CONEXIÓN
        //DESCONECTAR
        m.optionDesconectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                disabeall();
                m.tmodelo.setRowCount(0);
                m.tmodelo.setColumnCount(0);
                Connect.Desconexion();

            }
        });
        m.optionAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String bddname = m.bddTextfield.getText();

                    Connect.AbrirBdd(bddname);
                    ArrayList<String> comboTables = Connect.setComboArray();
                    String[] comboStringTables = comboTables.toArray(new String[comboTables.size()]);

                    DefaultComboBoxModel dml = new DefaultComboBoxModel();
                    for (int i = 0; i < comboTables.size(); i++) {
                        dml.addElement(comboTables.get(i));
                    }

                    m.comboListaTablas.setModel(dml);
                    m.comboListaTablas.setEnabled(true);
                    m.tablaTextfield.setEnabled(true);

                    //System.out.println(comboArray.length);
                    m.etiNombreBDDShow.setText(bddname);
                    m.etiInformacion.setText("Base de datos en uso: " + bddname);
                    Connect.setComboArray();

                    //ACTIVAMOS MENÚ MOSTRAR TABLA
                    m.optionMostrar.setEnabled(true);
                    m.bddPanel.setEnabled(true);
                    m.mostrarTablaPanel.setEnabled(true);
                    m.tablaPanel.setEnabled(true);
                } catch (SQLException ex) {
                    m.etiInformacion.setText("Base de datos no encontrada");

                }

            }
        });

    }

    //CONSTRUCTOR POR DEFECTO
    public MainWindowControl() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void disabeall() {

        //PANELES
        m.mainPanel.setEnabled(false);
        m.conexPanel.setEnabled(false);
        m.bddPanel.setEnabled(false);
        m.tablaPanel.setEnabled(false);
        m.mostrarTablaPanel.setEnabled(false);

        //JTEXTFIELDS
        m.bddTextfield.setEnabled(false);
        m.tablaTextfield.setEnabled(false);

        //OPCIONES DE MENÚ
        m.optionConectar.setEnabled(true);
        m.optionDesconectar.setEnabled(false);
        m.optionAbrir.setEnabled(false);
        m.optionMostrar.setEnabled(false);

        //COMBOBOX
        m.comboListaTablas.removeAllItems();
        m.comboListaTablas.addItem("Selecciona Tabla");
        m.comboListaTablas.setEnabled(false);

        //TABLA USADA
        m.etiNombreBDDShow.setText("          ");
        m.bddTextfield.setText("");
        m.tablaTextfield.setText("");

        //DATOS DE CONEXIÓN E INFORMACIÓN
        m.etiInformacion.setText("Información");
        m.etiUsuarioShow.setText("");
        m.etiPuertoShow.setText("");
        m.etiConectado.setText("Desconectado");
        m.etiConectado.setForeground(Color.RED); //Color por defecto

    }

}
