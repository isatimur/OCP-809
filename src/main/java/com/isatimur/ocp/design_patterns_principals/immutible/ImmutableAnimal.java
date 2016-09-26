package com.isatimur.ocp.design_patterns_principals.immutible;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isa Timur on 7/28/16.
 */
public final class ImmutableAnimal {
    private final String species;
    private final int age;
    private final List<String> favoriteFood;

    public ImmutableAnimal(String species, int age, List<String> favoriteFood) {
        this.species = species;
        this.age = age;
        if (favoriteFood == null) {
            throw new RuntimeException("favorite food is required");
        }
        this.favoriteFood = new ArrayList<>(favoriteFood);
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public int getFavorinteFoodCount() {
        return favoriteFood.size();
    }

    public String getFavoriteFood(int index) {
        return favoriteFood.get(index);
    }
}
