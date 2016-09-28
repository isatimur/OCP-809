package com.isatimur.ocp.sybex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by abyakimenko on 28.09.2016.
 */
public class StringSearch {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("ab");
        list.add("ba");
        list.add("bd");
        list.add("aa");

        Comparator<String> comparator = (a, b) -> b.compareToIgnoreCase(a);// обратный порядок сортировки
        Collections.sort(list, comparator);
        int index = Collections.binarySearch(list, "ab", comparator);
        System.out.println(index);
    }
}
