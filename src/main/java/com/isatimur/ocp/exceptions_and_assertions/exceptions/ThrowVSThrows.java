package com.isatimur.ocp.exceptions_and_assertions.exceptions;

import java.sql.SQLException;
import java.time.format.DateTimeParseException;

/**
 * Created by Isa Timur on 8/21/16.
 */
public class ThrowVSThrows {
    public static void main(String[] args) {

        ThrowVSThrows instance = new ThrowVSThrows();
        instance.test_1();
    }

    public void test_1() throws DateTimeParseException{



    }

    public String getDataFromDatabase() throws SQLException {
        throw new UnsupportedOperationException();
    }

}
