package com.isatimur.ocp.lambda.streams;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Isa Timur on 8/10/16.
 */
public class TerminalOperationSample {
    public static void main(String[] args) {
        System.out.println("==count==");
        Stream<String> s = Stream.of("a", "b", "c");
        System.out.println(s.count());

        System.out.println("==min/max==");
        Stream<String> s1 = Stream.of("123", "Aa", "AAb", "c");
        System.out.println(s1.min(String::compareTo));
//        max() can not be called after finishing previous terminal operation
//        because stream is closed
//        System.out.println(s1.max(String::compareTo));

        Stream<String> s2 = Stream.of("123", "Aa", "AAb", "c");
        System.out.println(s2.max(String::compareTo));

        Stream<String> s3 = Stream.of("monley", "ape", "bonobo");
        Optional<String> minString = s3.min((a1, a2) -> a1.length() - a2.length());
        minString.ifPresent(System.out::println);

        Optional<?> minEmpty = Stream.empty().min((a1, a2) -> 0);
        System.out.println(minEmpty.isPresent());

        System.out.println("==findAny()/findFirst()==return Optional<T>====");

        Stream<String> animals = Stream.of("monkey", "gorilla", "bobondo");
        Stream<String> infinite = Stream.generate(() -> "chimp");
        animals.findAny().ifPresent(System.out::println);
        infinite.findFirst().ifPresent(System.out::println);

    }
}
