package com.isatimur.ocp.package_3.lambda;

interface CheckTrait {
    public boolean test(Animal a);
}

/**
 * Created by Isa Timur on 7/23/16.
 */
public class FindMatchingAnimals {
    public static void main(String[] args) {
        print(new Animal("fish", false
            , true), a -> a.canHop());
        print(new Animal("kangaroo", true,
            false), a -> a.canHop());
    }

    private static void print(Animal animal, CheckTrait checkTrait) {
        if (checkTrait.test(animal))
            System.out.println(animal);
    }
}

class Animal {
    private String species;
    private boolean canHop;
    private boolean canSwim;

    public Animal(String species, boolean canHop, boolean canSwim) {

        this.species = species;
        this.canHop = canHop;
        this.canSwim = canSwim;
    }

    public boolean canHop() {
        return canHop;
    }

    public boolean canSwim() {
        return canSwim;

    }

    public String toString() {
        return species;
    }

}
