package com.isatimur.ocp.enthuware.concurrency;

public class Test extends Thread {
    static Object obj = new Object();
    static int x, y;

    public void run() {
        synchronized (obj) {
            for (; ; ) {
                x++;
                y++;
                System.out.println(x + " " + y);
            }
        }
    }

    public static void main(String[] args) {
        new Test().start();
        new Test().start();
    }
}