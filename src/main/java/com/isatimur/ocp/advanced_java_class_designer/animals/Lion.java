package com.isatimur.ocp.advanced_java_class_designer.animals;

/**
 * Created by abyakimenko on 10.12.2016.
 * виртуальный метод
 */
public class Lion extends Cat {

    @Override
    public void feed() {
        addMeats();
    }

    private void addMeats() {
        System.out.println("Lion eats  VIRTUAL meat");
    }

    public void addMeat() {
        System.out.println("Lion eats meat");
    }
}
