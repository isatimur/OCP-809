package com.isatimur.ocp.design_patterns_principals.functional.interfaces;

import com.isatimur.ocp.generics_collections.comparable.Animal;

public class Tiger implements Sprint {
    public void sprint(Animal animal) {
        System.out.println("Animal is sprinting fast! " + animal.toString());
    }
}