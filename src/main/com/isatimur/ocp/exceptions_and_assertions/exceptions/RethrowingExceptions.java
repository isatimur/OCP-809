package com.isatimur.ocp.exceptions_and_assertions.exceptions;

import java.io.IOException;
import java.time.format.DateTimeParseException;

/**
 * Created by Isa Timur on 8/22/16.
 */
public class RethrowingExceptions {

    public static void main(String[] args) throws IOException {
        RethrowingExceptions rethrowingExceptions = new RethrowingExceptions();
        rethrowingExceptions.rethrowig();
    }

    public void parseData() throws IOException, DateTimeParseException {
        throw new IOException("sql exception");
    }

    public void multicatch() throws IOException, DateTimeParseException {
        try {
            parseData();
        }
        catch (IOException | DateTimeParseException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void rethrowig() throws IOException, DateTimeParseException {
        try {
            parseData();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

    }
}
