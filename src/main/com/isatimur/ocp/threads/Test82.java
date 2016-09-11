package com.isatimur.ocp.threads;

/**
 * Created by Isa Timur on 7/19/16.
 */

//DEADLOCK

public class Test82 {
    public static void main(String args[]) {
        MyThread one = new MyThread();
        MyThread two = new MyThread();
        one.setOther(two);
        two.setOther(one);
        one.start();
        two.start();
    }
}

class MyThread extends Thread {
    Runnable other;

    void setOther(Runnable r) {
        other = r;
    }

    public void run() {
        synchronized (this) {
            System.out.print("XYZ");
            synchronized (other) {
                System.out.print("ABC");
            }
        }
    }
}
