package com.isatimur.ocp.advanced_java_class_designer.animals;

/**
 * Created by abyakimenko on 10.12.2016.
 */
public class Bird extends Animal {

    @Override
    public void feed() {
        addSeeds();
    }

    private void addSeeds() {
    }
    public void addSeed() {

        System.out.println("Bird eats seed");
    }
}
