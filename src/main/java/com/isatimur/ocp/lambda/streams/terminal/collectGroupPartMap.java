package com.isatimur.ocp.lambda.streams.terminal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by abyakimenko on 13.10.2016.
 */
public class collectGroupPartMap {

    public static void main(String[] args) {

//        The groupingBy()collector tells collect()that it should group all of the elements of
//        the stream into lists, organizing them by the function provided. This makes the keys in the
//        map the function value and the values the function results.

        Stream<String> ohMy = Stream.of("lions", "tigers", "bears", "bears", "bears", "bears");
        Map<Integer, List<String>> map = ohMy.collect(
                Collectors.groupingBy(String::length));
        System.out.println(map); // {5=[lions, bears], 6=[tigers]}

        Stream<String> ohMySet = Stream.of("lions", "tigers", "bears", "bears", "bears", "bears");

        /*Suppose that we don’t want a Listas the value in the map and prefer a Setinstead. No
        problem. There’s another method signature that lets us pass a downstream collector. This is
        a second collector that does something special with the values:*/

        Map<Integer, Set<String>> map1 = ohMySet.collect(
                Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(map1); // {5=[lions, bears], 6=[tigers]}


//        We can even change the type of Mapreturned through yet another parameter:
        Stream<String> ohMyTreemap = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, Set<String>> map3 = ohMyTreemap.collect(
                Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println(map3); // {5=[lions, bears], 6=[tigers]}

    }
}
