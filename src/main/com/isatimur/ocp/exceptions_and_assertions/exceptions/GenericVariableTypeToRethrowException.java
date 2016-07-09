package com.isatimur.ocp.exceptions_and_assertions.exceptions;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by tisachenko on 25.03.16.
 */
public class GenericVariableTypeToRethrowException {
    public static void main(String[] args) throws IOException, SQLException {
        String source = "DBMS";

        try {
            if (source.equals("DBMS")) {
                throw new SQLException();
            }
            else {
                throw new IOException();
            }
        }
        catch (Exception e) {
//            throw new Exception();
            throw e;
        }
    }
}
