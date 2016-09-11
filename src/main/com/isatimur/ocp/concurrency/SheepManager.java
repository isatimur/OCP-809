package com.isatimur.ocp.concurrency;

import java.util.concurrent.Executors;

/**
 * Created by Isa Timur on 8/26/16.
 */
public class SheepManager {
    private int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        try (ExecutorServiceCloseable service = new ExecutorServiceCloseable(Executors.newFixedThreadPool(20))) {
            SheepManager manager = new SheepManager();
            for (int i = 0; i < 10; i++) {
                service.submit(() -> manager.incrementAndReport());
            }
        }
    }

    private void incrementAndReport() {
        synchronized (SheepManager.class) {
            System.out.println((++counter) + " ");
        }
    }
}
