package com.isatimur.ocp.kaplan_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Isa Timur on 9/10/16.
 */
public class SortedMapExample {
    public static void main(String[] args) {
        SortedMap<String, Double> grades = new TreeMap<>();
        grades.put("B", 2.67);
        grades.put("A", 4.0);
        grades.put("F", 0.0);
        grades.put("C", 2.0);
        grades.put("C-", 2.0);
        grades.put("B", 3.33);
        System.out.println(grades.get("C"));
        System.out.println(grades.get("C-"));
        System.out.println(grades.get(grades.lastKey()));

        System.out.println();
        System.out.println("End");
        System.out.println();

        System.out.println(new ArrayList<>(Arrays.asList(new String[] {"1", "2"})).remove(1));
    }
}
