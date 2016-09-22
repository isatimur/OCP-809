package main.com.isatimur.ocp.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by Isa Timur on 7/11/16.
 */
public class NewMath {
    public static void main(String[] args) {
        List<Double> doubles = DoubleStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 25, 64, 49, 36, 125, 121)
            .boxed()
            .collect(toList());
        List<Double> result = new ArrayList<>();

        Function<Double, Stream<Double>> invSqrt = d -> NewMath
            .inv(d)
            .flatMap(dq -> NewMath.sqrt(dq))
            .map(dd -> Stream.of(d))
            .orElseGet(() -> Stream.empty());

        List<Double> invSqrtDouble = doubles.stream().parallel()
            .flatMap(invSqrt)
            .peek(System.out::println)
            .collect(Collectors.toList());

        System.out.println(invSqrtDouble.size());
    }

    public static Optional<Double> sqrt(Double d) {

        return d > 0 ? Optional.of(Math.sqrt(d)) : Optional.empty();
    }

    public static Optional<Double> inv(Double d) {
        return d != 0 ? Optional.of(1d / d) : Optional.empty();
    }

}
