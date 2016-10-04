package com.isatimur.ocp.lambda.builtinFuncInterfaces;

import com.isatimur.ocp.lambda.Predicate;

/**
 * Created by abyakimenko on 03.10.2016.
 */
public class PredicateMain {
    public static void main(String[] args) {

        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = x -> x.isEmpty();

        System.out.println(p1.test(""));
        System.out.println(p2.test(""));
    }
}
