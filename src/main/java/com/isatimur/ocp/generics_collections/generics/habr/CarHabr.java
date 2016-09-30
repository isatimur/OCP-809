package com.isatimur.ocp.generics_collections.generics.habr;

public class CarHabr extends VehicleHabr {

    public CarHabr() {
    }

    public CarHabr(String name, int age) {
        super.setName(name);
        super.setAge(age);
    }

    public CarHabr(String name, String model, int age) {
        super(name, model, age);
    }

}