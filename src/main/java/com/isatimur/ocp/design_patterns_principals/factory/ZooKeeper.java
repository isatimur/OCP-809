package com.isatimur.ocp.design_patterns_principals.factory;

/**
 * Created by Isa Timur on 7/30/16.
 */
public class ZooKeeper {
    public static void main(String[] args) {
        final Food food = FoodFactory.getFood("polar bear");
        food.consumed();
    }
}
