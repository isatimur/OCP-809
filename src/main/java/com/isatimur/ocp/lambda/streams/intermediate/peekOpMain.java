package com.isatimur.ocp.lambda.streams.intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by abyakimenko on 04.10.2016.
 */
public class peekOpMain {

    public static void main(String[] args) {

        System.out.println("==========PEEK=================");
        // The most common use for peek()is to output the contents of the stream as it goes by.
        // Suppose that we made a typo and counted bears beginning with the letter ginstead of b.
        // We are puzzled why the count is 1 instead of 2. We can add a peek()to fi nd out why:
        Stream<String> stream = Stream.of("black bear", "brown bear", "grizzly");
        long count = stream.filter(s16 -> s16.startsWith("g")).peek(System.out::println).count(); // grizzly
        System.out.println(count); // 1

        // When working with a Queue, peek()looks only at the first element. In a
        // stream, peek()looks at each element that goes through that part of the
        // stream pipeline. It’s like having a worker take notes on how a particular step of the process is doing.
        // Remember that peek()is intended to perform an operation without changing the result

        List<Integer> numbers = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        numbers.add(1);
        letters.add('a');
        Stream<List<?>> bad = Stream.of(numbers, letters);
        bad.peek(l -> l.remove(0)).map(List::size).forEach(System.out::print); // 00
//        This example is bad because peek()is modifying the data structure that is used in the
//        stream, which causes the result of the stream pipeline to be different than if the peek wasn’t present.
    }
}
