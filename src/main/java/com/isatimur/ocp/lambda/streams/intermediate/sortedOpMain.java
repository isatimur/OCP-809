package com.isatimur.ocp.lambda.streams.intermediate;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Created by abyakimenko on 04.10.2016.
 */
public class sortedOpMain {
    public static void main(String[] args) {

        System.out.println("===========SORTED==============");
        // Stream<T> sorted()
        // Stream<T> sorted(Comparator<? super T> comparator)
        // Calling the first signature uses the default sort order:
        Stream<String> s13 = Stream.of("brown-", "bear-");
        s13.sorted().forEach(System.out::print); // bear-brown-

        // Remember that we can pass a lambda expression as the comparator. For example, we can pass a Comparatorimplementation
        Stream<String> s14 = Stream.of("brown bear-", "grizzly-");
        s14.sorted(Comparator.reverseOrder()).forEach(System.out::print); // grizzly-brown bear

        // s.sorted(Comparator::reverseOrder); // DOES NOT COMPILE
        // Take a look at the method signatures again. Comparatoris a functional interface. This means that we can use
        // method references or lambdas to implement it. The
        // Comparatorinterface implements one method that takes two Stringparameters and
        // returns an int. However, Comparator::reverseOrderdoesn’t do that. It is a reference
        // to a function that takes zero parameters and returns a Comparator. This is not compatible with the interface.
        // This means that we have to use a method and not a method
        // reference. We bring this up to remind you that you really do need to know method references well.
    }
}
