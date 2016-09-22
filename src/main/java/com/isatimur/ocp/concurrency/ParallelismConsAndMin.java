package com.isatimur.ocp.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Isa Timur on 8/28/16.
 */
public class ParallelismConsAndMin {
    public static void main(String[] args) {
        List<Integer> data = Collections.synchronizedList(new ArrayList<>());
        Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().map(i -> {
            data.add(i);
            return i;
        })
            .forEachOrdered((s) -> System.out.print(s + " "));
        System.out.println();
        for (Integer item : data) {
            System.out.print(item + " ");
        }

        System.out.println();
        System.out.print(Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().findAny().get());

        System.out.println();
        System.out.println(Arrays.asList('w', 'o', 'l', 'f').stream().reduce("", (s, character) -> s + character, (s, s2) -> s + s2));

        System.out.println();
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().reduce(0, (a, b) -> a - b));

        System.out.println();
        System.out.println(Arrays.asList("w", "o", "l", "f")
            .parallelStream()
            .reduce("X", (a, b) -> a + b));

        System.out.println();

        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
        SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
        System.out.println(set);

        System.out.println();
        Stream<String> streamW = Stream.of("w", "o", "l", "f").parallel();
        Set<String> setW = streamW.collect(Collectors.toSet());
        System.out.println(setW);

        System.out.println();
        Stream<String> ohMY = Stream.of("liones", "tigers", "bears").parallel();
        ConcurrentMap<Integer, String> maps = ohMY.collect(Collectors
            .toConcurrentMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2));
        System.out.println(maps);
        System.out.println(maps.getClass());

        System.out.println();
        Stream<String> ohM = Stream.of("liones", "tigers", "bears").parallel();
        ConcurrentMap<Integer, List<String>> map = ohM.collect(
            Collectors.groupingByConcurrent(String::length));
        System.out.println(map);
    }
}
