package com.isatimur.ocp.lambda.streams.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by abyakimenko on 04.10.2016.
 */
public class matchingOpMain {
    public static void main(String[] args) {

        System.out.println("=============== MATCHING ====================");
        List<String> list = Arrays.asList("monkey", "2", "chimp");
        Stream<String> infinite1 = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println("anyMatch: " + list.stream().anyMatch(pred)); // true
        System.out.println("allMatch: " + list.stream().allMatch(pred)); // false
        System.out.println("noneMatch: " + list.stream().noneMatch(pred)); // false
        System.out.println("anyMatch: " + infinite1.anyMatch(pred)); // true

        BooleanSupplier booleanSupplier = () -> true;
    }
}
