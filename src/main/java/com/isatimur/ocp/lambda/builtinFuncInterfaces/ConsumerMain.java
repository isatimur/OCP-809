package com.isatimur.ocp.lambda.builtinFuncInterfaces;

import java.util.function.Consumer;

/**
 * Created by abyakimenko on 03.10.2016.
 *
 * @FunctionalInterface public class Consumer<T> {
 * void accept(T t);
 * }
 * @FunctionalInterface public class BiConsumer<T, U> {
 * void accept(T t, U u);
 * }
 */
public class ConsumerMain {
    public static void main(String[] args) {

        // You use a Consumer when you want to do something with a parameter but not return anything.
        // BiConsumer does the same thing except that it takes two parameters
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);

        c1.accept("Annie");
        c2.accept("Annie");
    }
}
