package main.com.isatimur.ocp.generics_collections.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Isa Timur on 8/8/16.
 */
public class Duck implements Comparable<Duck> {
    private String name;
    private int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public static void main(String[] args) {
//        Comparator<Duck> byWeight = new Comparator<Duck>() {
//            @Override public int compare(Duck o1, Duck o2) {
//                return o1.getWeight() - o2.getWeight();
//            }
//        };
// other samples of comparator implimentation
//        Comparator<Duck> byWeight = (a,b)->a.getWeight()-b.getWeight();
//        Comparator<Duck> byWeight = (Duck a, Duck b) -> a.getWeight() - b.getWeight();
//        Comparator<Duck> byWeight = (Duck a, Duck b) -> {return a.getWeight() - b.getWeight()};
        Comparator<Duck> byWeight = (a, b) -> {
            return a.getWeight() - b.getWeight();
        };

        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("Quack", 7));
        ducks.add(new Duck("Puddle", 10));
        Collections.sort(ducks);
        System.out.println(ducks);
        Collections.sort(ducks, byWeight);
        System.out.println(ducks);

    }

    public int getWeight() {
        return weight;
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
