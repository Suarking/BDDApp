package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.*;
import View.*;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainWindowControl implements ActionListener {

    public MainWindow m;
    public DefaultTableModel tmodelo;
    public JTable ta;
    public DefaultComboBoxModel cmodelo;

    public MainWindowControl(MainWindow m) {
        this.m = m;
        //CONTROLADOR SIMPLE DE VENTANA PRINCIPAL

        //ABRIR VENTANA CONEXIÓN
        //DESCONECTAR
        m.optionDesconectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) throws NullPointerException {
        
                try {
                    //BORRAMOS LA TABLA ACTIVA
                    m.tmodelo.setRowCount(0);
                    m.tmodelo.setColumnCount(0);
                    //LLAMAMOS A DESCONECTAR
                    Connect.Desconexion();
                } catch (Exception ne) {

                }
                //DESHABILITAMOS ETIQUETAS, PANELES, ETC...
                disabeall();

            }
        });
        m.optionAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String bddname = m.bddTextfield.getText();
                    //LLAMAMOS AL MÉTODO PARA ABRIR LA BDD PASÁNDOLE EL NOMBRE 
                    //QUE HAY ESCRITO EN EL JTEXTFIELD CORRESPONDIENTE

                    Connect.AbrirBdd(bddname);
                    
                    //UTILIZAMOS EL RETURN DEL MÉTODO SETCOMBOARRAY PARA INTRODUCIR LOS 
                    //VALORES EN UN ARRAY LOCAL
                    ArrayList<String> comboTables = Connect.setComboArray();
                  

                    //INTRODUCIMOS LOS VALORES DEL ARRAY EN UN MODELO DE  JCOMBOBOX
                    DefaultComboBoxModel dml = new DefaultComboBoxModel();
                    for (int i = 0; i < comboTables.size(); i++) {
                        dml.addElement(comboTables.get(i));
                    }
                    //APLICAMOS EL MODELO AL COMBOBOX, ACTIVAMOS ELEMENTOS

                    m.comboListaTablas.setModel(dml);
                    m.comboListaTablas.setEnabled(true);
                    m.tablaTextfield.setEnabled(true);

                    //ACTUALIZAMOS INFORMACIÓN
                    m.etiNombreBDDShow.setText(bddname);
                    m.etiInformacion.setText("Base de datos en uso: " + bddname);
                    

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

    //CONSTRUCTOR POR DEFECTO
    public MainWindowControl() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    

}
