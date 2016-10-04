package com.isatimur.ocp.threads;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicVariableTest {

    private static AtomicInteger counter = new AtomicInteger(0);

    static class Decrementer extends Thread {
        public void run() {
            counter.decrementAndGet(); // #1
        }
    }

    static class Incrementer extends Thread {
        public void run() {
            counter.incrementAndGet(); // #2
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Incrementer().start();
            new Decrementer().start();
        }
        System.out.println(counter);
    }
}