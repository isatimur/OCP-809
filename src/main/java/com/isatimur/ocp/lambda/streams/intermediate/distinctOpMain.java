package com.isatimur.ocp.lambda.streams.intermediate;

import java.util.stream.Stream;

/**
 * Created by abyakimenko on 04.10.2016.
 */
public class distinctOpMain {
    public static void main(String[] args) {

        System.out.println("==============DISTINCT=================");
        // The distinct()method returns a stream with duplicate values removed. The duplicates do
        // not need to be adjacent to be removed. As you might imagine, Java calls equals()to determine whether the objects are the same
        // Stream<T> distinct()

        Stream<String> s = Stream.of("duck", "duck", "duck", "goose");
        s.distinct().forEach(System.out::print); // duckgoose
    }
}
