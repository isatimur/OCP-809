package com.isatimur.ocp.exceptions_and_assertions.exceptions.additional_interface;

import java.io.IOException;

/**
 * Created by tisachenko on 26.03.16.
 */
public class TestVariableTypeInMultiCatch {
    public static void main(String[] args) {
        try {
            int a = 10;
            if (a <= 10) throw new Exception1();
            else throw new Exception2();
        } catch (Exception1 | Exception2 e) {
            System.out.println(e.info());
        }
    }
}

class Exception1 extends IOException implements iEx {

    @Override
    public String info() {
        return "I am a base exception";
    }
}

class Exception2 extends Exception implements iEx {

    @Override
    public String info() {
        return "I am Derived exception";
    }
}