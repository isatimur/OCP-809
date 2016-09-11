package com.isatimur.ocp.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Isa Timur on 7/9/16.
 */
public class StreamAPIClass {
    public static void main(String[] args) {

        Stream.empty();

        Stream.of("one");

        Stream.of("one", "two", "three");

        // a const Stream
        Stream.generate(() -> "one");

        //a growing Stream
        Stream.iterate("+", s -> "+").limit(1000).forEach(s -> System.out.println(s));

//        ThreadLocalRandom.current().ints().forEach(s -> System.out.println(s));
        try (Stream<String> lines = Files.lines(Paths.get("C:/ssss/dd.txt"))) {
        }
        catch (IOException e) {
            System.out.println(e.toString());
        }

        Stream.Builder<String> builder = Stream.builder();
        builder.add("one").add("two")
            .accept("three");

        Stream<String> stream = builder.build();

        IntStream intStream = ThreadLocalRandom.current().ints();
        intStream.limit(5).forEach(s -> System.out.println(s));

        IntStream intsStream = ThreadLocalRandom.current().ints();
        intsStream.limit(5).forEach(s -> System.out.println(s));
    }
}
