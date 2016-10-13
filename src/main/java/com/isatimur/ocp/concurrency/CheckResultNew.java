package com.isatimur.ocp.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Isa Timur on 8/24/16.
 */
public class CheckResultNew {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for (int i = 0; i < 500; i++) {
                    counter++;
                }
            });

            result.get(10, TimeUnit.SECONDS);
            System.out.println("Reached");
        }
        catch (TimeoutException e) {
            System.out.println("Not reached yet");
        }
        finally {
            if (service != null)
                service.shutdown();
        }
    }
}
