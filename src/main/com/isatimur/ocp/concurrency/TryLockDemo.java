package main.com.isatimur.ocp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tisachenko on 07.06.16.
 */
public class TryLockDemo implements Task {

    final ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        final int threadCount = 5;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);
        final Task task = new TryLockDemo();

        for (int i = 0; i < threadCount; i++) {
            service.execute(new Worker(task));
        }

        service.shutdown();
    }

    @Override
    public void performTask() {
        try {
            if (reentrantLock.tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + " : performing task ... ");
                }
                finally {
//                    System.out.println();
                    System.out.println(Thread.currentThread().getName() + " : releasing...");
                    reentrantLock.unlock();
                }
            }
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }

}
