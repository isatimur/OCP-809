package com.isatimur.ocp.generics_collections.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Isa Timur on 8/8/16.
 */
public class SortRabbits {
    public static void main(String[] args) {
        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit());
        Comparator<Rabbit> rabbitComparator = (r1, r2) -> r1.id - r2.id;
        Collections.sort(rabbits, rabbitComparator);
        System.out.println(rabbits);

    }

    static class Rabbit {
        int id;

        @Override public String toString() {
            return String.valueOf(id);
        }
    }
}
