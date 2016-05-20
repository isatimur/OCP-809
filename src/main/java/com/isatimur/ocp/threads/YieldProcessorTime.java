package com.isatimur.ocp.threads;

/**
 * Created by tisachenko on 20.05.16.
 */
public class YieldProcessorTime {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                yield();
                System.out.println("Singing");
            }
        };
        thread.start();
        Thread.yield();

    }
}
