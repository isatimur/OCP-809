package com.isatimur.ocp.design_patterns_principals.functional;

import com.isatimur.ocp.generics_collections.comparable.Animal;

public class FindMatchingAnimals {

    private static void print(Animal animal, CheckTrait trait) {
        if (trait.test(animal))
            System.out.println(animal);
    }

    public static void main(String[] args) {
        print(new Animal("fish", false, true), a -> a.canHop());
        print(new Animal("kangaroo", true, false), a -> a.canHop());
    }
}