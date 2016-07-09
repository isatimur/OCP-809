package com.isatimur.ocp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by tisachenko on 04.05.16.
 */
public class TransactionTransferFunds {
    public static void main(String[] args) {
        Connection con = null;
        Statement statement = null;
        try {
            con = getConnection();
            con.setAutoCommit(false);

            statement = con.createStatement();

            int result = statement.executeUpdate("" +
                "INSERT INTO transaction VALUES " +
                "(1,'5555','db',55.0, '2000-01-21')");

            result = statement.executeUpdate("" +
                "INSERT INTO transaction VALUES " +
                "(2,'7777','cr',55.0, '2000-01-21')");

            result = statement.executeUpdate("" +
                "UPDATE bank_acct " +
                "SET balance = 944.00" +
                "WHERE acct_no='5555'");
            result = statement.executeUpdate("" +
                "UPDATE bank_acct " +
                "SET balance = 155.00" +
                "WHERE acct_no='7777'");
            con.commit();

        }
        catch (SQLException e) {
            System.out.println(e);
            try {
                con.rollback();
            }
            catch (SQLException e1) {
                System.out.println(e1);
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        String username = "postgres";
        String password = "admin";
        String url = "jdbc:postgresql://localhost:5432/blog-db";
        return DriverManager.getConnection(url, username, password);
    }
}
