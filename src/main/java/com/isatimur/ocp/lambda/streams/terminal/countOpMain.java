package com.isatimur.ocp.lambda.streams.terminal;

import java.util.stream.Stream;

/**
 * Created by abyakimenko on 04.10.2016.
 */
public class countOpMain {
    public static void main(String[] args) {

        System.out.println("====================COUNT================");
        Stream<String> s = Stream.of("a", "b", "c");
        System.out.println(s.count());
    }
}
