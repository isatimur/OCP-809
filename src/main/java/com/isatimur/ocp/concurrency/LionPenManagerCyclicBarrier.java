package com.isatimur.ocp.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

/**
 * Created by Isa Timur on 8/29/16.
 */
public class LionPenManagerCyclicBarrier {
    public static void main(String[] args) throws InterruptedException {
        try (ExecutorServiceCloseable service = new ExecutorServiceCloseable(Executors.newFixedThreadPool(4))) {
            LionPenManagerCyclicBarrier manager = new LionPenManagerCyclicBarrier();
            CyclicBarrier c1 = new CyclicBarrier(4);
            CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("Pen is cleaned!"));
            for (int i = 0; i < 4; i++) {
                service.submit(() -> manager.performTask(c1, c2));
            }
        }
    }

    private void removeAnimals() {
        System.out.println("Removing animals");
    }

    private void cleanPen() {
        System.out.println("Cleaning the pen");
    }

    private void addAnimals() {
        System.out.println("Addign animals");
    }

    public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            removeAnimals();
            c1.await();
            cleanPen();
            c2.await();
            addAnimals();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
