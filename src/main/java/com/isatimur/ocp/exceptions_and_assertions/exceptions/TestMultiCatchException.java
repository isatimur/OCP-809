package com.isatimur.ocp.exceptions_and_assertions.exceptions;

/**
 * Created by tisachenko on 26.03.16.
 */
public class TestMultiCatchException {
    public static void main(String[] args) {
        try {
            int a = 10;
            if (a <= 10)
                throw new Exception1();
            else
                throw new Exception2();
        }
        catch (Exception1 | Exception2 ex) {
            System.out.println(ex);
        }
    }
}
