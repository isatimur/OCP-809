package com.isatimur.ocp.generics_collections.collections.sets;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by developer on 8/6/16.
 */
public class SetsExample {
    public static void main(String[] args) {
        System.out.println("============HashSet==========");
        Set<Integer> set = new HashSet<>();

        boolean b1 = set.add(66);

        boolean b2 = set.add(10);

        boolean b3 = set.add(66);

        boolean b4 = set.add(8);

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
        for (int i = 0; i <= 20; i++) {
            navigableSet.add(i);
        }
        System.out.println(navigableSet.lower(10));
        System.out.println(navigableSet.floor(10));
        System.out.println(navigableSet.ceiling(20));
        System.out.println(navigableSet.higher(20));

    }
}
