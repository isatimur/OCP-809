package com.isatimur.ocp.generics_collections.comparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by developer on 8/9/16.
 */
public class TestQuestion10 {
    public static void main(String[] args) {
        String[] values = new String[] {"123", "AAb", "Aab", "aab"};
        Arrays.sort(values, new MyComparator());
        for (String it : values) {
            System.out.println(it);
        }
    }

    static class MyComparator implements Comparator<String> {

        @Override public int compare(String o1, String o2) {
            return o2.toLowerCase().compareTo(o1.toLowerCase());
        }
    }

}
