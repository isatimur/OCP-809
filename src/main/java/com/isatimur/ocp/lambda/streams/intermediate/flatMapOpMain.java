package com.isatimur.ocp.lambda.streams.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by abyakimenko on 04.10.2016.
 */
public class flatMapOpMain {
    public static void main(String[] args) {

        System.out.println("===========FLATMAP=================");
        // The flatMap()method takes each element in the stream and makes any elements it contains top-level elements
        // in a single stream. This is helpful when you want to remove empty
        // elements from a stream or you want to combine a stream of lists. We are showing you the
        // method signature for consistency with the other methods, just so you don’t think we are
        // hiding anything. You aren’t expected to be able to read this:
        // <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
        // This gibberish basically says that it returns a Streamof the type that the function contains at a lower level.
        // Don’t worry about the signature. It’s a headache.
        // What you should understand is the example. This gets all of the animals into the same
        // level along with getting rid of the empty list
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);

        animals.flatMap(l -> l.stream()).forEach(System.out::println);
    }
}
