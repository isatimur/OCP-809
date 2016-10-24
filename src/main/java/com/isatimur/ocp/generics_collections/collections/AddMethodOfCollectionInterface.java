package com.isatimur.ocp.generics_collections.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Isa Timur on 8/6/16.
 */
public class AddMethodOfCollectionInterface {
    public static void main(String[] args) {

        System.out.println("===========ArrayList==========");
        List<String> list = new ArrayList<>();
        System.out.println(list.add("Sparrow"));
        System.out.println(list.add("Sparrow"));
        System.out.println(list);
        System.out.println("===========HashSet==========");
        Set<String> set = new HashSet<>();
        System.out.println(set.add("Sparrow"));
        System.out.println(set.add("Sparrow"));
        System.out.println(set);
        System.out.println("===========ArrayDeque==========");
        Deque<String> queue = new ArrayDeque<>();
        queue.push("hello");
        queue.push("hi");
        queue.push("ola");

        System.out.println(queue.add("Sparrow"));
        System.out.println(queue.add("Sparrow"));
        System.out.println(queue);
        System.out.println("===========LinkedList==========");
        List<String> linkedList = new LinkedList<>();
        System.out.println(linkedList.add("Sparrow"));
        System.out.println(linkedList.add("Sparrow"));
        System.out.println(linkedList);



    }
}
