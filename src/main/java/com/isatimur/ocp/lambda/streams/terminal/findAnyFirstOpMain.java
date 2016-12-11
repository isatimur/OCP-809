package com.isatimur.ocp.lambda.streams.terminal;

import java.util.stream.Stream;

/**
 * Created by abyakimenko on 04.10.2016.
 */
public class findAnyFirstOpMain {
    public static void main(String[] args) {

        System.out.println("==findAny()/findFirst()==return Optional<T>====");

        Stream<String> animals = Stream.of("monkey", "gorilla", "bobondo");
        Stream<String> infinite = Stream.generate(() -> "chimp");
        System.out.println(infinite.anyMatch(String::isEmpty));
        System.out.println(infinite.noneMatch(String::isEmpty));
        System.out.println(infinite.allMatch(String::isEmpty));

        animals.findAny().ifPresent(System.out::println);
        infinite.findFirst().ifPresent(System.out::println);


    }
}
