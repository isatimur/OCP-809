package com.isatimur.ocp.generics_collections.collections.sets;

import com.isatimur.ocp.generics_collections.generics.habr.CarHabr;

import java.util.*;

/**
 * Created by Isa Timur on 8/6/16.
 * The main benefit is that adding elements and checking if an element is in the set both
 * have constant time
 */
public class SetsExample {
    public static void main(String[] args) {
        System.out.println("============HashSet==========");

        Set<CarHabr> carHabrs = new HashSet<>();

//        HashSet<Number> numbers = new HashSet<Integer>();
        List<String> list = new Vector<>();

        carHabrs.add(new CarHabr("11", "11", 11));
        // carHabrs.add(new CarHabr("11", "11", 11));


        Set<Integer> set = new HashSet<>();

        boolean b1 = set.add(66);

        boolean b2 = set.add(10);

        boolean b3 = set.add(66);

        boolean b4 = set.add(8);

//        set.forEach(s -> System.out.println(s));
//        set.forEach((s) -> System.out.println(s));
//        set.forEach(System.out::println);

        for (Integer integer : set)
            System.out.print(integer + ",");

        System.out.println("\n============TreeSet==========");
        Set<Integer> treeSet = new HashSet<>();

        boolean bo1 = treeSet.add(66);

        boolean bo2 = treeSet.add(10);

        boolean bo3 = treeSet.add(66);

        boolean bo4 = treeSet.add(8);

        for (Integer integer : treeSet)
            System.out.print(integer + ",");

        System.out.println("\n=============NavigableSet=============");
        NavigableSet<Integer> navigableSet = new TreeSet<>();
        navigableSet.add(22);
        for (int i = 0; i <= 20; i++) {
            navigableSet.add(i);
        }
        System.out.println("navigableSet: " + navigableSet);

        System.out.println("navigableSet.lower(10): " + navigableSet.lower(10));
        System.out.println("navigableSet.floor(12): " + navigableSet.floor(12));
        System.out.println("navigableSet.ceiling(18): " + navigableSet.ceiling(18));
        System.out.println("navigableSet.higher(19): " + navigableSet.higher(19));
        System.out.println("navigableSet.higher(22): " + navigableSet.higher(22));

    }
}
