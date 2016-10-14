package com.isatimur.ocp.lambda.streams.terminal;

import java.util.*;
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

        /*Suppose that we don’t want a List as the value in the map and prefer a Setinstead. No
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


        /*Partitioning is a special case of grouping. With partitioning, there are only two possible
        groups—true and false. Partitioning is like splitting a list into two parts.
        Suppose that we are making a sign to put outside each animal’s exhibit. We have two
        sizes of signs. One can accommodate names with five or fewer characters. The other is
        needed for longer names. We can partition the list according to which sign we need:*/

        Stream<String> ohMyPartition = Stream.of("lions", "tigers", "bears", "bears", "brs", "rs");
        Map<Boolean, List<String>> mapPart = ohMyPartition.collect(
                Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(mapPart); // {false=[tigers], true=[lions, bears]}

        Stream<String> ohMyStringStream = Stream.of("lions", "tigers", "bears");
        Map<Boolean, Set<String>> map2 = ohMyStringStream.collect(
                Collectors.partitioningBy(s -> s.length() <= 7, Collectors.toSet()));
        System.out.println(map2);// {false=[], true=[lions, tigers, bears]}

        /*For example, we can group by the length of the animal
        name to see how many of each length we have:*/
        Stream<String> ohMyStringStreamStringStream = Stream.of("lions", "tigers", "bears", "111bears");
        Map<Integer, Long> map4 = ohMyStringStreamStringStream.collect(Collectors.groupingBy(
                String::length, Collectors.counting()));
        System.out.println(map4); // {5=2, 6=1}

        /*Finally, there is a mapping()collector that lets us go down a level and add another
        collector. Suppose that we wanted to get the first letter of the first animal alphabetically of
        each length. Why? Perhaps for random sampling. The examples on this part of the exam
        are fairly contrived as well. We’d write the following*/

        Stream<String> ohMyStringStream1 = Stream.of("lions", "tigers", "bears", "fears", "rearseeee", "hearees");
        Map<Integer, Optional<Character>> map5 = ohMyStringStream1.collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(s -> s.charAt(0),
                                Collectors.minBy(Comparator.naturalOrder()))));
        System.out.println(map5); // {5=Optional[b], 6=Optional[t]}


    }
}
