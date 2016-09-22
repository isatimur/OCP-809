package com.isatimur.ocp.lambda.functional_interfaces;

import java.time.LocalDate;

/**
 * Created by Isa Timur on 8/9/16.
 */
@FunctionalInterface
public interface Supplier<T> {
    public static void main(String[] args) {
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();

        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();

        System.out.println(d1);
        System.out.println(d2);

        Supplier<StringBuilder> sb1 = StringBuilder::new;
        Supplier<StringBuilder> sb2 = () -> new StringBuilder();

        System.out.println(sb1.get());
        System.out.println(sb2.get());
    }

    T get();
}
