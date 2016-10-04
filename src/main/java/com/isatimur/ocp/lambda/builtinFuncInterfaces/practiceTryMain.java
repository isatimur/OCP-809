package com.isatimur.ocp.lambda.builtinFuncInterfaces;

import com.isatimur.ocp.lambda.Predicate;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 * Created by abyakimenko on 03.10.2016.
 */
public class practiceTryMain {
    public static void main(String[] args) {

        // Line 6 passes one
        // Stringparameter to the lambda and returns a boolean. This tells us that it is a
        // Predicateor Function. Since the generic declaration has only one parameter, it is a Predicate.
        Predicate<List> ex1 = x -> "".equals(x.get(0));

        // Line 7 passes one Longparameter to the lambda and doesn’t return anything. This tells
        // us that it is a Consumer.
        Consumer<Long> ex2 = System.out::println;

        // Line 8 takes two parameters and returns a boolean. When you see
        // a booleanreturned, think Predicateunless the generics specify a Booleanreturn type. In
        // this case, there are two parameters, so it is a BiPredicate.
        BiPredicate<String, String> ex3 = (s1, s2) -> false;


        //Function<List<String>> ex11 = x -> x.get(0); // DOES NOT COMPILE мало аргументов + неверный возвращаемый тип
        // UnaryOperator<Long> ex2 = (Long l) -> 3.14; // DOES NOT COMIPLE неверный возвращаемый тип
        // Predicate ex4 = String::isEmpty; // DOES NOT COMPILE не указан тип женерика для предиката
    }
}
