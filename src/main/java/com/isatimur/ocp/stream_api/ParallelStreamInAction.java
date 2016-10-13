package com.isatimur.ocp.stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Isachenko Timur on 11.07.2016.
 */
public class ParallelStreamInAction {
    public static void main(String[] args) {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");

        List<String> stringList = new CopyOnWriteArrayList<>();

        List<String> collect = Stream.iterate("+", s -> s + "+")
                .parallel()
                .limit(1000)
//            .peek(s -> System.out.println(s + "processed in the thread " + Thread.currentThread().getName()))
                .collect(Collectors.toList());
        System.out.println("! " + collect.size());

        Stream<Integer> parallelStream2 = Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream();
        Stream<Integer> parallelStream3 = Arrays.asList(1, 2, 3, 4, 5, 6).stream();//.parallelStream();

        Stream<Integer> parallelStream4 = Stream.concat(parallelStream2, parallelStream3);

        System.out.println(parallelStream2.mapToInt(x -> x).sum());
        System.out.println(parallelStream2.mapToInt(x -> x).average());


        Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().forEach(s -> System.out.print(s + " "));

        Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().forEachOrdered(s -> System.out.print(s + " "));

    }
}
