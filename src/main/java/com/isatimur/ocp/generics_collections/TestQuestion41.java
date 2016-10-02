package com.isatimur.ocp.generics_collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by Isa Timur on 7/19/16.
 */
public class TestQuestion41 {
    public static void main(String args[]) {

        TreeSet<String> treeStrings = new TreeSet<>();
        treeStrings.add("one");
        treeStrings.add("One");
        treeStrings.add("Onne");
        treeStrings.add("On");
        treeStrings.add("ONE");

        System.out.println(treeStrings.ceiling("On"));

        Map<String, Double> stringDoubleMap = new HashMap<>();

        Map<Integer, Integer> integerMap = new HashMap<>(10);
        for (int i = 1; i <= 10; i++) {
            integerMap.put(i, i * i);
        }

        System.out.println(integerMap.get(4));


        TreeSet<StringBuilder> treeSetNames = new TreeSet<StringBuilder>();
        treeSetNames.add(new StringBuilder("Shreya"));
        treeSetNames.add(new StringBuilder("Harry"));
        treeSetNames.add(new StringBuilder("Paul"));
        treeSetNames.add(new StringBuilder("Shreya"));
        Iterator it = treeSetNames.descendingIterator();
        while (it.hasNext())
            System.out.print(it.next() + ":");
    }
}
