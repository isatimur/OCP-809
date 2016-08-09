package com.isatimur.ocp.generics_collections.advance_java8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by developer on 8/9/16.
 */
public class SamplesWithComputeMethods {
    public static void main(String[] args) {
        //Compute if presents
        System.out.println("//////////////Compute if presents");

        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 1);

        BiFunction<String, Integer, Integer> mapper = (k, v) -> v + 1;
        Integer jenny = counts.computeIfPresent("Jenny", mapper);
        Integer sam = counts.computeIfPresent("Sam", mapper);
        System.out.println(counts);
        System.out.println(jenny);
        System.out.println(sam);

        //Compute if absents
        System.out.println("//////////////Compute if absents");
        Map<String, Integer> countsN = new HashMap<>();
        countsN.put("Jenny", 15);
        countsN.put("Tom", null);

        Function<String, Integer> function = (k) -> 1;
        Integer jennyN = countsN.computeIfAbsent("Jenny", function);
//        Integer samN = countsN.computeIfAbsent("Sam", function);
        Integer tomN = countsN.computeIfAbsent("Tom", function);
        System.out.println(countsN);

        //if function return null
        System.out.println("//if function return null");

        counts.computeIfPresent("Jenny", (k, v) -> null);
        counts.computeIfAbsent("Sam", (k) -> null);
        System.out.println(counts);

        new Double(0.0);
    }
}
