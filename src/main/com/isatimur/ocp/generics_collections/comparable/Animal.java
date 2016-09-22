package main.com.isatimur.ocp.generics_collections.comparable;

/**
 * Created by Isa Timur on 8/8/16.
 */
public class Animal implements java.lang.Comparable<Animal> {
    private int id;

    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Animal();
        a1.id = 5;
        a2.id = 7;
        System.out.println(a1.compareTo(a2));
        System.out.println(a1.compareTo(a1));
        System.out.println(a2.compareTo(a1));

    }

    @Override public int compareTo(Animal o) {
        return id - o.id;
    }
}
