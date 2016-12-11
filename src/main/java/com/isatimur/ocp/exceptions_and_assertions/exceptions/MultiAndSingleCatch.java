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
class MultiAndSingleCatch {
    public static void main(String[] args) {
        new MultiAndSingleCatch().myMethod(null, "test1.sql");
    }

    void myMethod(Connection con, String fileName) {
        try {
            File file = new File(fileName);
            FileInputStream inputStream = new FileInputStream(file);
            Statement statement = con.createStatement();
        }
//        catch (FileNotFoundException e) {
//            System.out.println("single catch " + e.toString());
//        }
        catch (FileNotFoundException | SQLException e) {
            System.out.println("multiple catch " + e.toString());
        }

    }
}