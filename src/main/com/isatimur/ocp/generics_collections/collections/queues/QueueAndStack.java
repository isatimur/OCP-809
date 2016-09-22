package main.com.isatimur.ocp.generics_collections.collections.queues;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * Created by Isa Timur on 8/7/16.
 */
public class QueueAndStack {
    public static void main(String[] args) {
        System.out.println("=========Queue=========");
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        System.out.println(queue.offer(10));
        System.out.println(queue.offer(4));
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());

        System.out.println("=========Stack=========");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(4);
        System.out.println(stack.peek());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.peek());

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
        System.out.println(linkedList2.peek());
        System.out.println(linkedList2.poll());
        System.out.println(linkedList2.poll());
        System.out.println(linkedList2.peek());
    }
}
