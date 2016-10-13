package com.isatimur.ocp.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by Isa Timur on 8/30/16.
 */
public class CyclicBarrierTest {
    public static void await(CyclicBarrier cb) {
        try {
            cb.await();
        }
        catch (InterruptedException | BrokenBarrierException e) {

        }
    }

    public static void main(String[] args) {

        System.out.println("AvailableProcessors: " + Runtime.getRuntime().availableProcessors());

        ExecutorService service = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
//        service.
        CyclicBarrier barrier = new CyclicBarrier(Runtime.getRuntime().availableProcessors(), () -> System.out.println("Stock Room Full!"));
        IntStream.iterate(1, i -> 1).limit(4).parallel().forEach(i -> {
            await(barrier);
        });

    }
}
