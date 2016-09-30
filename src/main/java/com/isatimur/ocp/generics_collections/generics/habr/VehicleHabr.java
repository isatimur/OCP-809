package com.isatimur.ocp.generics_collections.generics.habr;

/**
 * Created by abyakimenko on 30.09.2016.
 */
public class VehicleHabr {

    private String name;
    private int age;
    private String color;
    private String model;

    public VehicleHabr() {
    }

    public VehicleHabr(String name, String model, int age) {
        this.name = name;
        this.model = model;
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
