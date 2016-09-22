package main.com.isatimur.ocp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by tisachenko on 27.03.16.
 */
public class LoginRest {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:/home/tisachenko/ocp", "admin", "adminadmin");
        Statement statement = conn.createStatement();
        statement.execute("select t.* FROM PUBLIC.USERS t");
        ResultSet set = statement.getResultSet();
        while (set.next()) {
//            String zero = set.getString();
            String username = set.getString(1);
            String password = set.getString(2);
            System.out.println("User:" + username + ", pswd:" + password);
        }
    }
}
