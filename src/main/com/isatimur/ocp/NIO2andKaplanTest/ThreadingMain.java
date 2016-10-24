package com.isatimur.ocp.NIO2andKaplanTest;

import java.util.concurrent.Executors;

/**
 * Created by Isachenko Timur on 15.09.2016.
 */
public class ThreadingMain extends Thread {
    public static int counter;

    public static void main(String[] args) {
        counter = 0;
        ThreadingMain main1 = new ThreadingMain();
        ThreadingMain main2 = new ThreadingMain();
        main1.start();
        main2.start();

    }

    @Override
    public void run() {

        while (counter < 4) {
            synchronized (this) {
                counter++;
                System.out.println("get counter value: " + counter);
            }
        }
    }
}
