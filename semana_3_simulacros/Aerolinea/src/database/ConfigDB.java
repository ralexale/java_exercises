package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    public static Connection objConnection = null;
    public static Connection openConnection(){
        try {
            String url = "jdbc:mysql://bszlbfsyggiyahmnfgnv-mysql.services.clever-cloud.com/bszlbfsyggiyahmnfgnv";
            String user = "uaksaf0vmwlmezbl";
            String password = "Ilx6DtbgQEEFINlztfkR";

            objConnection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado perfectamente");
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        return objConnection;
    }
    public static void closeConnection(){
        try {
            objConnection.close();
            System.out.println("Conexión cerrada correctamente");
        }catch (SQLException e){
            System.out.println("Error:" + e.getMessage());
        }
    }


}
