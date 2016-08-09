package com.isatimur.ocp.generics_collections.advance_java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by developer on 8/8/16.
 */
public class RemovingConditionalAndReplacing {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Magician");
        list.add("Assistant");
        System.out.println(list);
        list.removeIf(l -> l.startsWith("A"));
        System.out.println(list);

        List<Integer> integers = Arrays.asList(1, 2, 3);
        integers.replaceAll(x -> x * 2);
        System.out.println(integers);
    }
}
