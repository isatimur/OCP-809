package com.isatimur.ocp.lambda.optional;

import java.util.Optional;

/**
 * Created by developer on 8/10/16.
 */
public class JavaClassScores {
    public static void main(String[] args) throws Throwable {
        Optional<Double> aDouble = average(90, 100);
        Optional<Double> aDoubleNull = average();

        aDouble.ifPresent(System.out::println);
//        System.out.println(Optional.ofNullable(aDoubleNull.get()));
        System.out.println("====================");

        Optional<Double> o = average();
        System.out.println(o.orElse(Double.NaN));
        System.out.println(o.orElseGet(() -> Math.random()));
//        System.out.println(o.orElseThrow(() -> new IllegalStateException()));

        System.out.println("====================");
        Optional<Double> oAv = average(90, 100);
        System.out.println(oAv.orElse(Double.NaN));
        System.out.println(oAv.orElseGet(() -> Math.random()));
        System.out.println(oAv.orElseThrow(() -> new IllegalStateException()));

    }

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0)
            return Optional.empty();
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return Optional.of((double)sum / scores.length);
    }
}
