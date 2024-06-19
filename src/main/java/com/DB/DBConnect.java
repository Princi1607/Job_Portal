package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    private static Connection conn;

    public static Connection getConn() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver found");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/job_portal", "root", "root");
                System.out.println("Connection Success");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void closeConn() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection Closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
