package com.isatimur.ocp.threads;

public class TestClass1 extends Thread {
    int x = 0, y = 0;

    public void run() {
        while (true) {
            synchronized (this) {
                x++;
                y++;
                System.out.println(" x = " + x + " , y = " + y);
            }
        }
    }

    public static void main(String[] args) {
        TestClass tc = new TestClass();
        new Thread(tc).run();
        new Thread(tc).start();
    }
}