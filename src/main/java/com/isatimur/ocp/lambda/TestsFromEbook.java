package com.isatimur.ocp.lambda;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Isa Timur on 8/13/16.
 */
public class TestsFromEbook {
    public static void main(String[] args) {
//        DoubleStream s = DoubleStream.of(1.2, 2.4);
//        s.peek(System.out::println).filter(x -> x > 2).count();

        Stream<Integer> str = Stream.of(1);
        IntStream intStream = str.mapToInt(x -> x);
        DoubleStream doubleStream = intStream.mapToDouble(x -> x);
        Stream<Integer> str2 = doubleStream.mapToObj(x -> (int)x);
        str2.forEach(System.out::println);
    }
}
