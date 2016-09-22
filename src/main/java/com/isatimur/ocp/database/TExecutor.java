package com.isatimur.ocp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tisachenko on 09.05.16.
 */
public class TExecutor {

    public static void main(String[] args) throws SQLException {
        TExecutor executor = new TExecutor();
        try (Connection connection = getConnection()) {
            List<List<String>> end = executor.execQuery(connection, "SELECT * FROM TRANSACTION", (r) -> {
                List<List<String>> lists = new ArrayList<List<String>>();
                while (r.next()) {
                    List<String> list = new ArrayList<String>();
                    list.add(String.valueOf(r.getInt(1)));
                    list.add(String.valueOf(r.getInt(2)));
                    list.add(r.getString(3));
                    list.add(String.valueOf(r.getDouble(4)));
                    list.add(String.valueOf(r.getDate(5).toLocalDate()));
                    lists.add(list);
                }
                return lists;
            });
            System.out.println(end);
        }
    }

    public static Connection getConnection() throws SQLException {
        String username = "postgres";
        String password = "admin";
        String url = "jdbc:postgresql://localhost:5432/blog-db";
        return DriverManager.getConnection(url, username, password);
    }

    public <T> T execQuery(Connection connection, String query, TResultHandler<T> handler) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        T value = handler.handle(resultSet);
        resultSet.close();
        statement.close();
        return value;

    }
}

