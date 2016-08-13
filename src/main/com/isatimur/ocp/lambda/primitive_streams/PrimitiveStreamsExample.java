package com.isatimur.ocp.lambda.primitive_streams;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by developer on 8/11/16.
 */
public class PrimitiveStreamsExample {
    public static void main(String[] args) {
        IntStream stream = IntStream.of(1, 2, 3);
        OptionalDouble aDouble = stream.average();
        System.out.println(aDouble.getAsDouble());

        System.out.println();
        DoubleStream doubleStreamEmpty = DoubleStream.empty();
        DoubleStream oneValue = DoubleStream.of(3.14);
        DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);
        oneValue.forEach(System.out::println);
        System.out.println();
        varargs.forEach(System.out::println);

        DoubleStream random = DoubleStream.generate(Math::random);
        DoubleStream fraction = DoubleStream.iterate(.5, d -> d / 2);

        random.limit(3).forEach(System.out::println);
        System.out.println();
        fraction.limit(3).forEach(System.out::println);

        System.out.println();

        IntStream count = IntStream.iterate(1, n -> n + 1).limit(5);
        count.forEach(System.out::println);

        System.out.println();

        IntStream countRange = IntStream.range(1, 6);
        countRange.forEach(System.out::println);

        System.out.println();

        IntStream countRangeClosed = IntStream.rangeClosed(1, 6);
        countRangeClosed.forEach(System.out::println);

        System.out.println();

        Stream<String> objStream = Stream.of("penguin", "fish");
        IntStream intStream = objStream.mapToInt(s -> s.length());

        IntStream streams = IntStream.rangeClosed(1, 10);
        OptionalDouble optional = streams.average();
        System.out.println(
            optional
        );

        LongStream longs = LongStream.of(5, 10);
        long sum = longs.sum();
        System.out.println(sum); // 15

        DoubleStream doubles = DoubleStream.generate(() -> Math.PI);
        OptionalDouble optionalDouble = doubles.min();

    }

}
