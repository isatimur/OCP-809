package com.isatimur.ocp.enthuware.concurrency;

public class TestClass extends Thread {
    String name = "";

    public TestClass(String str) {
        name = str;
    }

    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 10000));
            System.out.println(name);
        } catch (Exception e) {
        }
    }

    public static void main(String[] str) throws Exception {
        Thread t1 = new TestClass("tom");
        Thread t2 = new TestClass("dick");
        t1.start();
        t2.start();
        t1.join();
        t2.join();


        System.out.println("harry");
    }
}