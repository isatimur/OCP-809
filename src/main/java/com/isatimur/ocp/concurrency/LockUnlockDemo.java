package com.isatimur.ocp.concurrency;

/**
 * Created by tisachenko on 07.06.16.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

interface Task {
    void performTask();
}

public class LockUnlockDemo implements Task {

    final ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        final int threadCount = 5;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);
        final Task task = new LockUnlockDemo();

        for (int i = 0; i < threadCount; i++) {
            service.execute(new Worker(task));
        }

        service.shutdown();
    }

    @Override
    public void performTask() {
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": Lock acquired.");
            System.out.println("Processing...");
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        finally {
            System.out.println(Thread.currentThread().getName() + ": Lock released.");
            reentrantLock.unlock();
        }
    }
}

class Worker implements Runnable {
    private Task task;

    public Worker(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.performTask();
    }
}