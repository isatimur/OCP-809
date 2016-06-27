package com.isatimur.ocp.package_4.collections.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by tisachenko on 11.03.16.
 */
public class TestArrayDeque {

    public static void main(String[] args) {
        String strArray[] = {"A1", "B2", "C3"};
        ArrayDeque<String> arrayDeque = new ArrayDeque<>(Arrays.asList(strArray));
        arrayDeque.push("D4");
        arrayDeque.offer("E5");

        //arrayDeque.push(null);

        System.out.println(arrayDeque.pop());
        System.out.println(arrayDeque.remove());
        System.out.println(arrayDeque.poll());

        arrayDeque.add("F6");
        System.out.println(arrayDeque.peek());

        System.out.println(arrayDeque);

        //A1,B2,C3,
        //D4,A1,B2,C3,
        //D4,A1,B2,C3,E5
        //B2,C3,E5
        //B2,C3,E5,F6

        Iterator<String> descendingIterator = arrayDeque.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.println(descendingIterator.next());
        }
        Iterator<String> iterator = arrayDeque.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
