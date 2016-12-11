package com.isatimur.ocp.threads;

public class TestClass implements Runnable {

    int x = 0,
            y = 0;

    public void run() {

        while (true) {
            x++;
            y++;
            System.out.println(" x = " + x + " , y = " + y);
        }
    }

    public static void main(String[] args) {

        TestClass tc = new TestClass();
        new Thread(tc).start();
        new Thread(tc).start();

    }
}