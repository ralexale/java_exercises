package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    static Connection objConnection = null;


    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://uaksaf0vmwlmezbl:Ilx6DtbgQEEFINlztfkR@bszlbfsyggiyahmnfgnv-mysql.services.clever-cloud.com:3306/bszlbfsyggiyahmnfgnv";
            String user = "uaksaf0vmwlmezbl";
            String password = "Ilx6DtbgQEEFINlztfkR";

            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Me conecté perfectamente!!!!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error >> Driver no Instalado");
        } catch (SQLException e) {
            System.out.println("Error >> No se pudo establecer una conexión con la DB \n" + e.getMessage());
        }

        return objConnection;
    }

    public static void closeConnection() {
        try {
            if (objConnection != null) objConnection.close();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
