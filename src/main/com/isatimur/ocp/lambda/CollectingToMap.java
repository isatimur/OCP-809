package com.isatimur.ocp.lambda;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Created by developer on 8/12/16.
 */
public class CollectingToMap {

    public static void main(String[] args) {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map = ohMy.collect(
            Collectors.toMap(String::length, s -> s, (s1, s2) -> s1 + "," + s2, TreeMap::new));
        System.out.println(map); // {lions=5, bears=5, tigers=6}
        System.out.println(map.getClass()); // {lions=5, bears=5, tigers=6}

        ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> groupingMap = ohMy.collect(groupingBy(String::length));
        System.out.println(groupingMap);

        ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Set<String>> groupingMapValueasSet = ohMy.collect(groupingBy(String::length, toSet()));
        System.out.println(groupingMapValueasSet);

        ohMy = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, Set<String>> groupingTreeMapValueasSet = ohMy.collect(groupingBy(String::length, TreeMap::new, toSet()));
        System.out.println(groupingTreeMapValueasSet);

        ohMy = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, List<String>> groupingTreeMapValueasList = ohMy.collect(groupingBy(String::length, TreeMap::new, toList()));
        System.out.println(groupingTreeMapValueasSet);

        //partioning
        ohMy = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> partioningMap = ohMy.collect(
            Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(partioningMap); // {false=[tigers], true=[lions, bears]}

        ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Long> mapC = ohMy.collect(groupingBy(String::length, counting()));
        System.out.println(mapC); // {5=2, 6=1}

        ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Optional<Character>> mapChar = ohMy.collect(groupingBy(String::length, mapping((String s) -> s.charAt(0), minBy(naturalOrder()))));
        System.out.println(mapChar); // {5=2, 6=1}

        Optional.of(1).ifPresent(System.out::println);
    }

}
