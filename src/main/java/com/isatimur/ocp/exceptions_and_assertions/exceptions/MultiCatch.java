package com.isatimur.ocp.exceptions_and_assertions.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by tisachenko on 26.03.16.
 */
public class MultiCatch {
    public static void main(String[] args) {
        new MultiCatch().myMethod(null, "test.sql");

    }

    void myMethod(Connection connection, String fileName) {
        try {
            File file = new File(fileName);
            FileInputStream inputStream = new FileInputStream(file);
            Statement statement = connection.createStatement();
        }
        catch (FileNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }
        finally {
            System.out.println("finally");
        }
    }
}
