package com.isatimur.ocp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tisachenko on 07.06.16.
 */
public class LockInteruptedlyDemo implements Task {

    final ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        final int threadCount = 5;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);
        final Task task = new LockInteruptedlyDemo();

        for (int i = 0; i < threadCount; i++) {
            service.execute(new Worker(task));
        }

        service.shutdown();
    }

    @Override
    public void performTask() {
        try {
            reentrantLock.lockInterruptibly();
            try {
                System.out.println(Thread.currentThread().getName() + ": Lock acquired.");
                System.out.println("Work on progress...");
                Thread.sleep(2000);
//                anyMethodIsHeld();

            } finally {
                System.out.println(Thread.currentThread().getName() + ": Lock released.");
                reentrantLock.unlock();
            }


        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " : Interrupted!");
            Thread.currentThread().interrupt();
        }
    }

    public void anyMethodIsHeld() {
        assert !reentrantLock.isHeldByCurrentThread();
        reentrantLock.lock();
        try {
            System.out.println("anymethod started");
        } finally {
            reentrantLock.unlock();
        }
    }


    public void anyMethodHold() {
        assert reentrantLock.getHoldCount() == 0;
        reentrantLock.lock();
        try {
            //perform task
        } finally {
            reentrantLock.unlock();
        }
    }
}
