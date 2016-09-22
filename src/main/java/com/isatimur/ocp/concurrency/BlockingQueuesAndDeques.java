package com.isatimur.ocp.concurrency;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Isa Timur on 8/27/16.
 */
public class BlockingQueuesAndDeques {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("===================Queue=================");
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue.offer(39);
        blockingQueue.offer(4, 5, TimeUnit.SECONDS);

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(10, TimeUnit.SECONDS));

        System.out.println("===================Deque=================");

        BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
        blockingDeque.offer(91);
        blockingDeque.offerFirst(5, 2, TimeUnit.SECONDS);
        blockingDeque.offerLast(47, 100, TimeUnit.MILLISECONDS);
        blockingDeque.offer(3, 4, TimeUnit.SECONDS);

        System.out.println(blockingDeque);

        System.out.println();

        System.out.println(blockingDeque.poll());
        System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS));
        System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));
        System.out.println(blockingDeque.pollFirst(200, TimeUnit.NANOSECONDS));
        System.out.println(blockingDeque.pollFirst(2, TimeUnit.SECONDS));

    }
}
