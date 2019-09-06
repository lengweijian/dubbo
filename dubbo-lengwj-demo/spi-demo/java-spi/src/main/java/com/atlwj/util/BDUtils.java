package com.atlwj.util;

import java.sql.*;

/**
 * 应用
 */
public class BDUtils {

    public static final String URL = "jdbc:mysql://localhost:3306/devDB";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    public static Connection conn() throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        //Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        return DriverManager.getConnection(URL, USER, PASSWORD);

    }

    public static void main(String[] args) throws Exception{
        //3.操作数据库，实现增删改查
        Statement stmt = conn().createStatement();

        ResultSet rs = stmt.executeQuery("SELECT title FROM books");
        //如果有数据，rs.next()返回true
        while(rs.next()) {
            System.out.println(rs.getString("title"));
        }
    }
}
