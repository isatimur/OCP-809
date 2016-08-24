package com.isatimur.ocp.concurrency;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by developer on 8/24/16.
 */
public class AddData {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try (ExecutorServiceCloseable service = new ExecutorServiceCloseable(Executors.newFixedThreadPool(20))) {
            for (int i = 0; i < 10000; i++) {
                Future<Double> result = service.submit(() -> 30 + 11 * Math.random());
                System.out.println(result.get());
            }

        }
    }

}

class ExecutorServiceCloseable implements AutoCloseable, ExecutorService {
    private ExecutorService service;

    public ExecutorServiceCloseable(ExecutorService service) {
        this.service = service;
    }

    @Override
    public void close() throws InterruptedException {
        if (service != null) {
            service.shutdown();
        }
        if (service != null) {
            service.awaitTermination(1, TimeUnit.MINUTES);
            if (service.isTerminated())
                System.out.println("All tasks finished");
            else
                System.out.println("At least one task is still running");
        }

    }

    @Override public void shutdown() {
        service.shutdown();
    }

    @Override public List<Runnable> shutdownNow() {
        return service.shutdownNow();
    }

    @Override public boolean isShutdown() {
        return service.isShutdown();
    }

    @Override public boolean isTerminated() {
        return service.isTerminated();
    }

    @Override public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return service.awaitTermination(timeout, unit);
    }

    @Override public <T> Future<T> submit(Callable<T> task) {
        return service.submit(task);
    }

    @Override public <T> Future<T> submit(Runnable task, T result) {
        return service.submit(task, result);
    }

    @Override public Future<?> submit(Runnable task) {
        return service.submit(task);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return service.invokeAll(tasks);
    }

    @Override public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout,
        TimeUnit unit) throws InterruptedException {
        return service.invokeAll(tasks, timeout, unit);
    }

    @Override
    public <T> T invokeAny(
        Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return service.invokeAny(tasks);
    }

    @Override public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout,
        TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return service.invokeAny(tasks, timeout, unit);
    }

    @Override public void execute(Runnable command) {
        service.execute(command);
    }
}

