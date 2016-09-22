package com.isatimur.ocp.exceptions_and_assertions.exceptions;

import java.io.IOException;

/**
 * Created by tisachenko on 26.03.16.
 */
public class Exception1 extends IOException {
    public String info() {
        return "I'm Base Exception";
    }

}
