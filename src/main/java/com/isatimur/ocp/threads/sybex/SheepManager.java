package com.isatimur.ocp.threads.sybex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomics применяются для атомарного обновления объектов, они более эффективны, так как не используют блокровку
 * при этом порядок вывода не гарантируется, как в примере ниже
 * его можно вернуть, применив ключевое слово syncronized к критичной секции кода
 */
public class SheepManager {

    private static AtomicInteger sheepCount1 = new AtomicInteger(0); // w1
    private static int sheepCount2 = 0;

    private void incrementAndReport() {
        synchronized (this) {// нужен для упорядочивания вывода
            System.out.print(sheepCount1.incrementAndGet() + " ");
        }

        //System.out.print((++sheepCount2) + " ");// выведутс не все значения
        // System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = null;
        SheepManager manager = new SheepManager();

        try {
//            service = Executors.newSingleThreadExecutor(); // w2
            service = Executors.newFixedThreadPool(10); // w2
            for (int i = 0; i < 10; i++) {

                service.submit(() -> manager.incrementAndReport());
                /*service.execute(() ->
                {
                    sheepCount1.getAndIncrement();
                    sheepCount2++;
                }); // w3*/
            }

            Thread.sleep(100);
//            System.out.println(sheepCount1 + " " + sheepCount2);
        } finally {
            if (service != null) service.shutdown();
        }
    }
}