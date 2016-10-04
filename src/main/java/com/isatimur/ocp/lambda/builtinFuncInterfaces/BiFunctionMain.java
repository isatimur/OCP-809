package com.isatimur.ocp.lambda.builtinFuncInterfaces;

import java.util.function.BiFunction;

/**
 * Created by abyakimenko on 03.10.2016.
 */
public class BiFunctionMain {
    public static void main(String[] args) {

        BiFunction<String, String, String> b1 = String::concat;
        BiFunction<String, String, String> b2 = (string, toAdd) -> string.concat(toAdd);

        System.out.println(b1.apply("baby ", "chick")); // baby chick
        System.out.println(b2.apply("baby ", "chick")); // baby chick
    }
}
