package com.isatimur.ocp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by tisachenko on 09.05.16.
 */
public class SingleConnection {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("");
    }

    public static void main(String[] args) {

    }
}
