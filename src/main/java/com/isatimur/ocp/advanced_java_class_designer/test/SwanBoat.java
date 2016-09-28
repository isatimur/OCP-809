package com.isatimur.ocp.advanced_java_class_designer.test;

/**
 * Created by abyakimenko on 28.09.2016.
 */

import java.util.stream.IntStream;

public class SwanBoat {

//    static SwanBoat boat;
    // public static SwanBoat boat;
    public static SwanBoat boat;

    public void row() {
    }

    public void paddle() {
        IntStream.range(1, 10).forEach(i -> boat.row());// => от 1 до 9
        // IntStream.rangeClosed(1,10);// => от 1 до 10
    }

    public static void main(String[] args) {
        boat = new SwanBoat();
    }
}
