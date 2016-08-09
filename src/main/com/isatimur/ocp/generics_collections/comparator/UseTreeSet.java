package com.isatimur.ocp.generics_collections.comparator;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by developer on 8/8/16.
 */
public class UseTreeSet {
    public static void main(String[] args) {
        Set<Duck> ducks = new TreeSet<>();
        ducks.add(new Duck("Puddle", 10));
        Set<Rabbit> rabbits = new TreeSet<>(new Comparator<Rabbit>() {
            public int compare(Rabbit r1, Rabbit r2) {
                return r1.id = r2.id;
            }
        });
        rabbits.add(new Rabbit());
        System.out.println(ducks);
        System.out.println(rabbits);
    }

    static class Rabbit {
        int id;

        @Override public String toString() {
            return "Rabbit #" + id;
        }
    }

}
