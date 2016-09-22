package com.isatimur.ocp.stream_api;

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
//                .peek(s -> System.out.println(s + "processed in the thread " + Thread.currentThread().getName()))
            .collect(Collectors.toList());
        System.out.println("! " + collect.size());
    }
}
