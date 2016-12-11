package com.isatimur.ocp.threads.sybex;

import java.util.concurrent.*;
import java.util.stream.*;

public class StockRoomTracker {
    public static void await(CyclicBarrier cb) { // j1
        try {
            cb.await();
        } catch (InterruptedException |
                BrokenBarrierException e) {
// Handle exception
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(10,
                () -> System.out.println("Stock Room Full!")); // j2
        IntStream.iterate(1, i -> 1).limit(9)
                .parallel().forEach(i -> await(cb)); // j3
    }
}