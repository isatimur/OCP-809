package com.isatimur.ocp.generics_collections.generics.unbound_wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isa Timur on 8/6/16.
 */
//Unbounded wildcard represents any data type! Use ? symbol to expose your intension to compiler.
public class UnbounedExample {
    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number : list) {
            count++;
        }
        return count;
    }

    public static void printList(List<?> list) {
        for (Object x : list) {
            System.out.println(x);

        }
    }

    public static void main(String[] args) {
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        keywords.add("javafx");
        printList(keywords);

    }
}
