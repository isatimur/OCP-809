package com.isatimur.ocp.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by developer on 8/24/16.
 */
public class ScheduledESTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = () -> System.out.println("Hello Zoo");
        Callable<String> task2 = () -> "Monkey";
        Future<?> result1 = service.schedule(task1, 10, TimeUnit.SECONDS);
        Future<String> result2 = service.schedule(task2, 1, TimeUnit.MINUTES);
        System.out.println(result2.get());
        service.scheduleAtFixedRate(() -> System.out.println("fucking shit"), 0, 60, TimeUnit.SECONDS);
        Future<String> result3 = service.schedule(task2, 1, TimeUnit.MINUTES);
        result3.get();
        service.scheduleWithFixedDelay(() -> System.out.println("imposible"), 0, 2, TimeUnit.SECONDS);
        service.shutdown();
    }
}
