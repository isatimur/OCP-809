package com.isatimur.ocp.concurrency;

import com.isatimur.ocp.lambda.functional_interfaces.Supplier;
import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * Created by Isa Timur on 8/24/16.
 */
public class AmbiguousLambdaSample {
    public static void useSupplier(Supplier<Integer> expression) {
    }

    public static void useCallable(Callable<Integer> expression) {
    }

    public static void use(Supplier<Integer> expression) {
    }

    public static void use(Callable<Integer> expression) {
    }

    public static void main(String[] args) {
        useCallable(() -> {
            throw new IOException();
        });
//        useSupplier(()->{throw new IOException();}); DOES NOT COMPILE
//        use(()->{throw new IOException();}); //DOES NOT COMPILE
        use((Callable<Integer>)() -> {
            throw new IOException();
        });

    }
}
