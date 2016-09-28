package com.isatimur.ocp.advanced_java_class_designer.test;

import java.util.stream.IntStream;

/**
 * Created by abyakimenko on 28.09.2016.
 */
public class DragonBoat {

//    private static DragonBoat boat;
    public static DragonBoat boat;

    public static void row() {
    }

    public static void race() {
        boat = new DragonBoat();
        IntStream.range(1, 100).forEach(i -> boat.row());
    }
}
