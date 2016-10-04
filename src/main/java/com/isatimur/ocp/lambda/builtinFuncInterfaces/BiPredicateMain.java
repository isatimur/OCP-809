package com.isatimur.ocp.lambda.builtinFuncInterfaces;

import java.util.function.BiPredicate;

/**
 * Created by abyakimenko on 03.10.2016.
 */
public class BiPredicateMain {
    public static void main(String[] args) {

        BiPredicate<String, String> b1 = String::startsWith;
        BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);

        System.out.println(b1.test("chicken", "chick"));
        System.out.println(b2.test("chicken", "chick"));
    }
}
