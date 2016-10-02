package com.isatimur.ocp.generics_collections.collections.lists;

import java.util.LinkedList;
import java.util.Vector;

/**
 * Created by abyakimenko on 01.10.2016.
 * <p>
 * The main benefits of a LinkedListare that you can access, add, and remove from the
 * beginning and end of the list in constant time. The tradeoff is that dealing with an arbitrary index takes linear time.
 * This makes a LinkedList a good choice when you’ll be using it as Queue.
 */
public class LinkedListMain {

    public static void main(String[] args) {

        // synchronized, threa-safe collection !!!!
        Vector vector = new Vector();

        LinkedList<String> strings = new LinkedList<>();

        strings.add("ONE");
        strings.add("TWO");
        strings.add("THREE");
        strings.add("FOUR");
        strings.add("FIVE");
        strings.add("SIX");
//        strings.add("THREE");
//        strings.remove("THREE");

        System.out.println(strings);

        System.out.println(strings.getFirst());
        System.out.println(strings.getLast());

//        strings.stream().forEach(System.out::println);
//        System.out.println("iterator variant");
//        Iterator iterator = strings.iterator();
//        while (strings.iterator().hasNext()) {
//
//            String s = (String) iterator.next();
//            System.out.println(s);
//        }
    }
}
