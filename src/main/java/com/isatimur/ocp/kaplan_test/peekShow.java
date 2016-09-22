package com.isatimur.ocp.kaplan_test;

/**
 * Created by Isa Timur on 9/10/16.
 */

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class peekShow {
    public static void main(String args[]) {
        // make a stack
        Stack pile = new Stack();
        // adding elements to the stack
        pile.push("first");
        pile.push("second");
        pile.push("third");
        // viewing the top most object
        System.out.println("The object at the top of the stack is " + pile.peek());

        Queue queue = new ArrayDeque();
        queue.add("third");
        queue.offer("first");
        queue.offer("second");
        queue.offer("fourth");

        System.out.println("The object at the top is " + queue.poll());
    }
}