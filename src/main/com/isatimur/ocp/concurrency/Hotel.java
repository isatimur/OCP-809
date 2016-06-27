package com.isatimur.ocp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by developer on 6/11/16.
 */
public class Hotel {
    ExecutorService service = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {

    }

    public void orderFood(Order order) {
        service.submit(order);
    }

    public void hotelClosedForDay() {
        service.shutdown();
    }

    public void hotelClosedForever() {
        service.shutdown();
        try {
            if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
                service.shutdownNow();
                if (!service.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ie) {
            service.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

}
