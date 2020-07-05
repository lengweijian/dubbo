package com.atlwj.config;


import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String username = "root";

    private static final String password = "123456";

    private static final String URL = "jdbc:mysql://localhost:3306/devDB";


    public static Connection getConn() throws SQLException {
        Connection conn;
        try {
            //Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, username, password);
            System.out.println(conn);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args) throws SQLException {
        getConn();
    }
}
