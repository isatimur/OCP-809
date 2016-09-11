package com.isatimur.ocp.generics_collections.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Isa Timur on 8/8/16.
 */
public class Squirrel {
    private int weight;
    private String species;

    public Squirrel(String theSpecies) {
        if (theSpecies == null)
            throw new IllegalArgumentException();
        species = theSpecies;
    }

    public static void main(String[] args) {
        List<Squirrel> squirrels = new ArrayList<>();
        squirrels.add(new Squirrel("Asquirrels1").setWeight(10));
        squirrels.add(new Squirrel("Bsquirrels2").setWeight(34));
        squirrels.add(new Squirrel("Asquirrels1").setWeight(15));
        Collections.sort(squirrels, new ChainingComparator());
        System.out.println(squirrels);
        Collections.sort(squirrels, new MultiFieldComparator());
        System.out.println(squirrels);

    }

    public int getWeight() {
        return weight;
    }

    public Squirrel setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public String getSpecies() {
        return species;
    }

    @Override public String toString() {
        return species + " : " + weight;
    }
}

class MultiFieldComparator implements Comparator<Squirrel> {
    public int compare(Squirrel s1, Squirrel s2) {
        int result = s1.getSpecies().compareTo(s2.getSpecies());
        if (result != 0)
            return result;
        return s1.getWeight() - s2.getWeight();
    }
}

class ChainingComparator implements Comparator<Squirrel> {
    public int compare(Squirrel s1, Squirrel s2) {
        Comparator<Squirrel> c = Comparator.comparing(s -> s.getSpecies());
        c = c.thenComparingInt(s -> s.getWeight());
        return c.compare(s1, s2);
    }
}