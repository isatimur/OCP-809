package com.isatimur.ocp.lambda.streams.intermediate;

import java.util.stream.Stream;

/**
 * Created by abyakimenko on 04.10.2016.
 */
public class limitSkipOpMain {
    public static void main(String[] args) {

        System.out.println("=============LIMIT SKIP=============");
        Stream<Integer> s1 = Stream.iterate(1, n -> n + 1);
        s1.skip(5).limit(2).forEach(System.out::print); // 67
    }
}
