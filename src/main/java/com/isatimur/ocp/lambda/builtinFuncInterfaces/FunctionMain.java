package com.isatimur.ocp.lambda.builtinFuncInterfaces;

import java.util.function.Function;

/**
 * Created by abyakimenko on 03.10.2016.
 *
 * @FunctionalInterface public class Function<T, R> {
 * R apply(T t);
 * }
 *
 * @FunctionalInterface public class BiFunction<T, U, R> {
 * R apply(T t, U u);
 * }
 *
 */
public class FunctionMain {
    public static void main(String[] args) {

        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = x -> x.length();

        System.out.println(f1.apply("cluck")); // 5
        System.out.println(f2.apply("cluckssss")); //
    }
}
