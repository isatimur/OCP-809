package com.isatimur.ocp.database;

import java.sql.*;

/**
 * Created by tisachenko on 09.05.16.
 */
public class SingleConnection {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","12345");
    }

    public static void main(String[] args) {


        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            final String sql = "SELECT * FROM country";
            ResultSet rs = stmt.executeQuery(sql);





            System.out.println(rs.absolute(0));
            rs.next();
            System.out.println(rs.getString(1));



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
