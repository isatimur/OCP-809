package com.isatimur.ocp.sybex;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abyakimenko on 02.10.2016.
 */
public class map {

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, null);

        map.merge(1, 3, (a, b) -> a + b);

        // Objects.requireNonNull(value);
        // map.merge(1, null, (a, b) -> a + b);// NPE
        map.merge(3, 3, (a, b) -> a + b);

        System.out.println(map);
    }
}
