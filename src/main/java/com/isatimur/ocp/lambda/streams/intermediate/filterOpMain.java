package com.isatimur.ocp.lambda.streams.intermediate;

import java.util.stream.Stream;

/**
 * Created by abyakimenko on 04.10.2016.
 */
public class filterOpMain {
    public static void main(String[] args) {

        System.out.println("================= FILTER ================");
        // The filter()method returns a Streamwith elements that match a given expression
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.filter(x -> x.startsWith("m")).forEach(System.out::print); // monkey
    }
}
