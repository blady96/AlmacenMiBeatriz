package com.belili.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCSession {

    private static final String DATA_BASE = "MBR_WAREHOUSE";
    private static final String USER = "root";
    private static final String PASSWORD = "Lucifer666";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATA_BASE;
    private Connection connection = null;

    public Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);

        } catch (SQLException sqle) {
            System.err.println(sqle);
        } catch (ClassNotFoundException cnfe) {
            System.err.println(cnfe);
        } catch (Exception e) {
            System.err.println(e);
        }
        return connection;
    }
}
