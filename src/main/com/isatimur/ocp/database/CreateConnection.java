package main.com.isatimur.ocp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by tisachenko on 02.05.16.
 */
public class CreateConnection {

    public static void main(String[] args) {
        String username = "postgres";
        String password = "admin";
        String url = "jdbc:postgresql://localhost:5432/blog-db";

        try (Connection conn = DriverManager.getConnection(url, username, password);) {

            Statement statement = conn.createStatement();
            statement.execute("SELECT login,password FROM Users");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("login"));
                System.out.println(resultSet.getString("password"));
            }

        }
        catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println();
    }

}
