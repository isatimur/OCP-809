package com.isatimur.ocp.generics_collections.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by developer on 8/8/16.
 */
public class Duck implements Comparable<Duck> {
    private String name;

    public Duck(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("Quack"));
        ducks.add(new Duck("Puddle"));
        Collections.sort(ducks);
        System.out.println(ducks);

    }

    public String getName() {
        return name;
    }

    public int compareTo(Duck o) {
        return this.name.compareTo(o.getName());
    }

    @Override public String toString() {
        return name;
    }
}
