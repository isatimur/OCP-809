package com.isatimur.ocp.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Created by Isa Timur on 7/9/16.
 */
public class ReductionExamples {
    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> ints1 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> ints2 = Arrays.asList(5, 6, 7, 8, 9);

//        BinaryOperator<Integer> op = (i1, i2) -> i1 + i2;
//        BinaryOperator<Integer> op = (i1, i2) -> Integer.max(i1, i2);
        BinaryOperator<Integer> op = (i1, i2) -> (i1 + i2) * (i1 + i2);

        int reduction1 = reduce(ints1, 0, op);
        int reduction2 = reduce(ints2, 0, op);

        int reduction = reduce(Arrays.asList(reduction1, reduction2), 0, op);
//        int reduction = reduce(ints, 0, op);
        System.out.println("Reduction: " + reduction);

    }

    private static int reduce(List<Integer> integerList, int valueEmpty, BinaryOperator<Integer> reduction) {

        int result = valueEmpty;
        for (Integer item : integerList) {
            result = reduction.apply(result, item);
        }

        return result;
    }

    public boolean allMatch(List<String> names) {
        for (String name : names) {
            if (name.length() < 20) {
                return false;
            }
        }
        return true;
    }
}
