package com.isatimur.ocp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by tisachenko on 02.05.16.
 */
public class InsertConnection {
    public static void main(String[] args) {

        try (Connection conn = getConnection();
             Statement statement = conn.createStatement();
        ) {

            statement.executeUpdate("INSERT INTO users (login,password,email) VALUES ('test','test','test@gmail.com')");
//            ResultSet resultSet = statement.getResultSet();
//            while(resultSet.next()){
//                System.out.println(resultSet.getString("login"));
//                System.out.println(resultSet.getString("password"));
//            }


        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println();
    }

    public static Connection getConnection() throws SQLException {
        String username = "postgres";
        String password = "admin";
        String url = "jdbc:postgresql://localhost:5432/blog-db";
        return DriverManager.getConnection(url, username, password);
    }
}
