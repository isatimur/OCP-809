package main.com.isatimur.ocp.kaplan_test;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Isa Timur on 9/10/16.
 */
public class TestItem74 {
    public static void main(String[] args) {
        Map<Integer, String> students = new TreeMap<>();
        students.put(5, "Joshua");
        students.put(1, "Aima");
        students.put(3, "Robin");
        students.put(5, "George");
        students.put(2, "Troy");
        System.out.print(students.values());
//        students.put(-1, "Aima");
//        students.put(-2, "Troy");
//        students.put(-3, "Robin");
//        students.put(-4, "George");
//        System.out.print(students.values());
    }
}
