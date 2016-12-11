package com.isatimur.ocp.lambda.streams.terminal;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by abyakimenko on 04.10.2016.
 */
public class minMaxOpMain {
    public static void main(String[] args) {

        System.out.println("===============MIN/MAX======================");
        Stream<String> s1 = Stream.of("123", "Aa", "AAb", "11", "c");

        System.out.println("min compareTo" + s1.min(String::compareTo));
//        System.out.println("min Length" + s1.min((ss1, ss2) -> ss1.length() - ss2.length()));

//        max() can not be called after finishing previous terminal operation
//        because stream is closed
//        System.out.println(s1.max(String::compareTo));

        Stream<String> s2 = Stream.of("123", "AaCFFF", "AAb", "a");
        System.out.println("max compareTo: " + s2.max(String::compareTo));

        Stream<String> s3 = Stream.of("monley", "ape", "bonobo");
        Optional<String> minString = s3.min(Comparator.comparingInt(String::length));
        minString.ifPresent(System.out::println);

        Optional<?> minEmpty = Stream.empty().min((a1, a2) -> 0);
        System.out.println(minEmpty.isPresent());

    }
}
