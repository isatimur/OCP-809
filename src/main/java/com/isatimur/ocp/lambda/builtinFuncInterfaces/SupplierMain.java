package com.isatimur.ocp.lambda.builtinFuncInterfaces;

import java.time.LocalDate;
import java.util.function.Supplier;

/**
 * Created by abyakimenko on 03.10.2016.
 */
public class SupplierMain {

    public static void main(String[] args) {

        // A Supplieris used when you want to generate or supply values without taking any input.
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();

        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();

        System.out.println(d1);
        System.out.println(d2);

    }
}
