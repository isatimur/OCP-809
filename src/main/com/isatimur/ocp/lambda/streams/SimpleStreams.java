package com.isatimur.ocp.lambda.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by developer on 8/10/16.
 */
public class SimpleStreams {
    public static void main(String[] args) {
        Stream<String> empty = Stream.empty();
        Stream<Integer> singleElement = Stream.of(1);
        Stream<Integer> fromArray = Stream.of(1, 2, 3);

        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> fromList = list.stream();
        Stream<String> fromListParallel = list.parallelStream();

        Stream<Double> randoms = Stream.generate(() -> Math.random());
        Stream<Double> randomsResference = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(0, i -> i + 2);

    }
}
