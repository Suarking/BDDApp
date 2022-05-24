package Model;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class Connect {

    static Connection conexión1;
    static Statement st;
    static ResultSet rs;
    static ResultSetMetaData rsmd;

    public Connect() {

    }

    public static void Conexion(String user, String port) throws Exception {

        //ESTABLECEMOS CONEXIÓN
        conexión1
                = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/", user, "");

    }

    public static void AbrirBdd(String bddname) throws SQLException {

        //2. Crear un objeto Statement
        st = conexión1.createStatement();

        //3. Ejecutar una sentencia SQL (se pone la BD en uso)
        st.executeUpdate("use " + bddname);

    }

    public static ArrayList<String> setComboArray() throws SQLException {
        ArrayList showTables = new ArrayList();

        rs = st.executeQuery("Show tables");

        while (rs.next()) {

            showTables.add(rs.getString(1));

        }
        return showTables;
    }

    public static void MostrarTabla(DefaultTableModel tmodelo, JTable ta, String selectedTable) throws SQLException {
        try {
            /*
 //1. Establecer una conexión
 conexión1 =
DriverManager.getConnection("jdbc:mysql://localhost:3307/infodata", "root", "");
 //2. Crear un objeto Statement
 st = conexión1.createStatement();


 //3. Ejecutar una sentencia SQL (se pone la BD en uso)
 st.executeUpdate("use infodata");*/
            //3. Ejecutar una sentencia SQL
            rs = st.executeQuery("SELECT * FROM " + selectedTable);
            rsmd = rs.getMetaData(); // se extraen los metadatos a partir
            // de los datos
            int numCol = rsmd.getColumnCount(); //se extrae el número de
//columnas

            for (int i = 0; i < numCol; i++) { // se recorren las columnas de
// la tabla añadiéndose al modelo
                tmodelo.addColumn(rsmd.getColumnLabel(i + 1));
            }

//4. Leer un objeto ResultSet
            while (rs.next()) { //se recorren una a una las tuplas o
                // filas de la tabla

                //se define un array fila con el número de columnas como tamaño
                Object[] fila = new Object[numCol]; //en lugar de Objects
                //se pueden usar Strings

                // Para cada tupla se completa cada elemento del array fila
                // con cada elemento de la tabla
                for (int j = 0; j < numCol; j++) {
                    fila[j] = rs.getObject(j + 1); // El primer índice en rs es
//el 1, no el cero, por eso se suma 1
                }
                // Se añade al modelo el array fila completo
                tmodelo.addRow(fila);

            } //mientras haya más tuplas va recorriéndolas

        } catch (SQLException e) {
            System.out.println(e.getMessage());

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
