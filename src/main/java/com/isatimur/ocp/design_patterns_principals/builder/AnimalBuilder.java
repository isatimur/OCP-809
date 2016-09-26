package com.isatimur.ocp.design_patterns_principals.builder;

import com.isatimur.ocp.design_patterns_principals.immutible.ImmutableAnimal;

import java.util.List;

/**
 * Created by abyakimenko on 26.09.2016.
 */
public class AnimalBuilder {

    private String species;
    private int age;
    private List<String> favoriteFoods;

    public AnimalBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public AnimalBuilder setSpecies(String species) {
        this.species = species;
        return this;
    }

    public AnimalBuilder setFavoriteFoods(List<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
        return this;
    }

    public ImmutableAnimal build() {

        return new ImmutableAnimal(species,age,favoriteFoods);
    }
}
