package com.isatimur.ocp.generics_collections.collections.queues;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * Created by Isa Timur on 8/7/16.
 */
public class QueueAndStack {
    public static void main(String[] args) {
        System.out.println("=========Queue=========");
        ArrayDeque<Integer> queue = new ArrayDeque<>();
         // FIFO (single-ended queue), people say offer/poll/peek
        System.out.println(queue.offer(10));// Adds an element to the back of the queue and returns whether successful
        System.out.println(queue.offer(4)); // в конец
        System.out.println(queue.offer(17));// в конец
//        System.out.println(queue.add(12));// в конец
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.poll());// Removes and returns next element or returns nullif empty queue
        System.out.println(queue.poll());// Removes and returns next element or returns nullif empty queue
        // System.out.println(queue.peek());
        //System.out.println(queue.remove());// Removes and returns next element or throws an exception if empty queue

        System.out.println("=========Stack=========");
        //  LIFO (stack), people say push/poll/peek
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(10);// Adds an element to the front of the queue
        stack.push(4);
        System.out.println(stack.peek());// Returns next element or returns nullif empty queue
        System.out.println(stack.poll());// Removes and returns next element or returns nullif empty queue
        System.out.println(stack.poll());// Removes and returns next element or returns nullif empty queue
        System.out.println(stack.peek());
//        System.out.println(stack.pop());// Removes and returns next element or throws an exception if empty queue

        System.out.println("=========LinkedList Stack=========");
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.push(10);
        linkedList1.push(4);
        System.out.println(linkedList1.peek());
        System.out.println(linkedList1.poll());
        System.out.println(linkedList1.poll());
        System.out.println(linkedList1.peek());

        System.out.println("=========LinkedList Queue=========");
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.offer(10);
        linkedList2.offer(4);
        linkedList2.add(null);

        System.out.println(linkedList2.peek());
        System.out.println(linkedList2.poll());
        System.out.println(linkedList2.poll());
        System.out.println(linkedList2.peek());
    }
}
