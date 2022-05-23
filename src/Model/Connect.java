package Model;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class Connect {

    static Connection conexión1;
    static Statement s;
    static ResultSet rs;
    static ResultSetMetaData rsmd;

    public Connect() {

    }

    public static void Conexion() {

        try {
            //ESTABLECEMOS CONEXIÓN
            conexión1
                    = DriverManager.getConnection("jdbc:mysql://localhost:3307/", "root", ""); //HABRÍA QUE USAR LOS VALORES DE LOS JTEXTFIELD DE SUBWINDOWCONNECTION

        } catch (SQLException e) {

            //CAPTURAR ERROR, CAMBIAR ETIQUETA DE ESTADO EN SUBVENTANA
        }

    }
    public static void Desconexion() {

        try {
            //ESTABLECEMOS CONEXIÓN
           conexión1.close(); 

        } catch (SQLException e) {

            //CAPTURAR ERROR, CAMBIAR ETIQUETA DE ESTADO EN SUBVENTANA
        }

    }
    
    
    //HABRÍA QUE HACER MÉTODOS ESTÁTICOS PARA DESCONEXIÓN...

}
