package com.belili.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model_connect {

    private static final String DATA_BASE = "PRUEBA_ALMACEN";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATA_BASE;
    private Connection connection = null;

    public Connection getConnection() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);

        } catch (SQLException e) {
            System.err.println("Error en la connection");
            System.err.println(e);
        } catch (ClassNotFoundException cnfe) {
            Logger.getLogger(Model_connect.class.getName()).log(Level.SEVERE, null, cnfe);
        }

        return connection;
    }

}
