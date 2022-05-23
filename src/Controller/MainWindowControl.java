package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.*;
import View.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainWindowControl implements ActionListener {

    public MainWindow m;
    private DefaultTableModel tmodelo;
    private JTable ta;

    public MainWindowControl(MainWindow m) {
        this.m = m;

        //ABRIR VENTANA CONEXIÓN
        
        //DESCONECTAR
        m.optionDesconectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Desconectar");
                Connect.Desconexion();
                
                m.disabeall();

            }
        });
        m.optionAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String bddname = m.bddTextfield.getText();
                    Connect.AbrirBdd(bddname);
                    m.etiNombreBDDShow.setText(bddname);
                    m.etiInformacion.setText("Base de datos en uso: " + bddname);
                    
                    //ACTIVAMOS MENÚ MOSTRAR TABLA
                    m.optionMostrar.setEnabled(true);
                } catch (SQLException ex) {
                    m.etiInformacion.setText("Base de datos no encontrada");
                    
                }

            }
        });

    }

    public MainWindowControl(JTable ta) {
        this.ta = ta;

        m.optionMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tmodelo = new DefaultTableModel(); //cada vez que se pulsa el
//botón se resetea el modelo y
                    ta.setModel(tmodelo); //se aplica de nuevo a la tabla

                    Connect.MostrarTabla(tmodelo, ta);

                } catch (SQLException ex) {

                    m.etiInformacion.setText("Tabla no encontrada");
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

}
