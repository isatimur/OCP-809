package com.isatimur.ocp.advanced_java_class_designer.animals;

/**
 * Created by abyakimenko on 10.12.2016.
 */
public class Cow extends Animal {

    @Override
    public void feed() {

        addHays();
    }

    private void addHays() {
    }

    public void addHay() {
        System.out.println("Cow eats hay");
    }
}
