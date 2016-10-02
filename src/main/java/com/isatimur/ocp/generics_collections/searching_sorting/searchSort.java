package com.isatimur.ocp.generics_collections.searching_sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by abyakimenko on 02.10.2016.
 */
public class searchSort {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Fluffy", "Hoppy");
        Comparator<String> c = Comparator.reverseOrder();
        // Collections.sort(names, c);
        int index = Collections.binarySearch(names, "Hoppy", c);
        System.out.println(index);
    }
}
