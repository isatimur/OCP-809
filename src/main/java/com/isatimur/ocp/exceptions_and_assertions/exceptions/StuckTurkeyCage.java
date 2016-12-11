package com.isatimur.ocp.exceptions_and_assertions.exceptions;

import java.io.Closeable;
import java.sql.SQLException;

public class StuckTurkeyCage implements Closeable {

//    public void close() throws Exception {
//        throw new Exception("Cage door does not close");
//    }


    @Override
    public void close() {
//        throw new IOException();
        throw new RuntimeException("");
    }

    public static void main(String[] args) {
        try (StuckTurkeyCage t = new StuckTurkeyCage()) { // DOES NOT COMPILE
            System.out.println("put turkeys in");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void read() throws SQLException {
        try {
            readFromDatabase();
        } catch (SQLException | RuntimeException e) {
            throw e;
        }
    }

    private void readFromDatabase() throws SQLException {
    }
}