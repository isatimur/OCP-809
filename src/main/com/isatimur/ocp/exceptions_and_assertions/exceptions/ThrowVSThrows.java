package com.isatimur.ocp.exceptions_and_assertions.exceptions;

import java.sql.SQLException;

/**
 * Created by developer on 8/21/16.
 */
public class ThrowVSThrows {
    public static void main(String[] args) {

    }

    public String getDataFromDatabase() throws SQLException {
        throw new UnsupportedOperationException();
    }

}
