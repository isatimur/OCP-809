package com.isatimur.ocp.enthuware;

public class TestClass {
    public static void main(String args[]) throws Exception {
        A a = new A();
        a.start();
        Thread.sleep(1000);
        a.interrupt();
    }
}