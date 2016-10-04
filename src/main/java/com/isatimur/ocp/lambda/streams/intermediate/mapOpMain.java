package com.isatimur.ocp.lambda.streams.intermediate;

import java.util.stream.Stream;

/**
 * Created by abyakimenko on 04.10.2016.
 */
public class mapOpMain {
    public static void main(String[] args) {

        System.out.println("===============MAP============");
        // The map()method creates a one-to-one mapping from the elements in the stream to the elements of the next step in the stream
        // As an example, this code converts a list of Stringobjects to a list of Integers representing their lengths
        Stream<String> s12 = Stream.of("monkey", "gorilla", "bonobo");
        s12.map(String::length).forEach(System.out::print); // 676
    }
}
