package com.isatimur.ocp.design_patterns_principals;

import com.isatimur.ocp.design_patterns_principals.builder.AnimalBuilder;
import com.isatimur.ocp.design_patterns_principals.immutible.ImmutableAnimal;

import java.util.Arrays;

/**
 * Created by abyakimenko on 26.09.2016.
 */
public class mainPatterns {

    ImmutableAnimal duck = new AnimalBuilder()
            .setAge(14)
            .setSpecies("nam nam")
            .setFavoriteFoods(Arrays.asList("grass", "fish"))
            .build();

    ImmutableAnimal flamingo = new AnimalBuilder()
            .setFavoriteFoods(Arrays.asList("algae", "insects"))
            .setSpecies("flamingo").build();
}
