package com.isatimur.ocp.stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by developer on 7/11/16.
 */
public class MainUsingOptional {
    public static void main(String[] args) {
        List<Double> result = new ArrayList<>();
//        ThreadLocalRandom.current().doubles(10_000).boxed().parallel()
//            .forEach(d -> NewMath.inv(d).ifPresent(
//            inv -> NewMath.sqrt(inv).ifPresent(
//                sqrt -> result.add(sqrt)
//            )
//        ));
//

        Function<Double, Stream<Double>> flatMapper =
            d -> NewMath.inv(d)
                .flatMap(inv -> NewMath.sqrt(inv))
                .map(sqrt -> Stream.of(sqrt))
                .orElseGet(() -> Stream.empty());
        List<Double> coll = ThreadLocalRandom.current()
            .doubles(10_000)
            .map(d -> d * 20 - 10)
            .boxed()
//            .parallel()
            .flatMap(flatMapper)
            .collect(toList());

        System.out.println("! result= " + coll.size());
    }
}
