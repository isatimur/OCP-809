package com.isatimur.ocp.lambda.builtinFuncInterfaces;

import java.util.function.UnaryOperator;

/**
 * Created by abyakimenko on 03.10.2016.
 */
public class UnaryOperatorMain {
    public static void main(String[] args) {

        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();

        System.out.println(u1.apply("chirp"));
        System.out.println(u2.apply("chirp"));
    }
}
