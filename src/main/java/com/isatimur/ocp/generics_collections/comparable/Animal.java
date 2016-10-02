package com.isatimur.ocp.generics_collections.comparable;

/**
 * Created by Isa Timur on 8/8/16.
 */
public class Animal implements java.lang.Comparable<Animal> {

    private int id;
    private String species;
    private boolean canHop;
    private boolean canSwim;

    public Animal(){}

    public Animal(String speciesName, boolean hopper, boolean swimmer) {
        species = speciesName;
        canHop = hopper;
        canSwim = swimmer;
    }
    public boolean canHop() { return canHop; }
    public boolean canSwim() { return canSwim; }
    public String toString() { return species; }

    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Animal();
        Animal a3 = new Animal();
        a1.id = 5;
        a2.id = 7;
        a3.id = 7;
        System.out.println(a1.compareTo(a2));
        System.out.println(a1.compareTo(a1));
        System.out.println(a2.compareTo(a3));

    }

    @Override
    public int compareTo(Animal o) {
        return id - o.id;
    }
}
