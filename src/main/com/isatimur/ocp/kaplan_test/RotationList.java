package com.isatimur.ocp.kaplan_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Isa Timur on 9/10/16.
 */
public class RotationList {
    public static void main(String[] args) {

        List<String> grades = new ArrayList<>();
        grades.addAll(Arrays.asList(new String[] {"C", "A", "B", "A", "D"}));
        Collections.rotate(grades, 2);
        System.out.println(grades.get(0));
        System.out.println(grades.get(1));
        System.out.println(grades.get(2));
//        System.out.println(grades.remove(2));
        System.out.println(grades.remove(3));
//        System.out.println(grades.remove(4));

    }
}
