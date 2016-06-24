package com.isatimur.ocp.exceptions_and_assertions.assertions;

import java.io.FileNotFoundException;

/**
 * Created by tisachenko on 28.03.16.
 */
public class DefineCauseOfAssertionError {
    public static void main(String[] args) {
        assert (false) : new FileNotFoundException("java txt is missing");
    }
}
