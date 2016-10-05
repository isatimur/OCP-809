package com.isatimur.ocp.lambda.streams.terminal;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * Created by abyakimenko on 04.10.2016.
 */
public class reduceOpMain {
    public static void main(String[] args) {

        System.out.println("=============== REDUCE ====================");
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        String word = stream.reduce("", String::concat);
        System.out.println(word); // wolf


        Stream<Integer> integerStream = Stream.of(3, 5, 6);
//        integerStream.map(x -> x * x).forEach(System.out::println);
        System.out.println(integerStream.reduce(1, (a, b) -> a * b));

        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);

        empty.reduce(op).ifPresent(System.out::println); // no output
        oneElement.reduce(op).ifPresent(System.out::println); // 3
        threeElements.reduce(op).ifPresent(System.out::println); // 90

        Stream<Integer> stream1 = Stream.of(3, 5, 6);
        System.out.println(stream1.reduce(1, op, op)); // 90
    }
}
