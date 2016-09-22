package main.com.isatimur.ocp.generics_collections.advance_java8;

import main.com.isatimur.ocp.generics_collections.comparator.Duck;

/**
 * Created by Isa Timur on 8/8/16.
 */
public class DuckHelper {
    public static int compareByWeight(Duck d1, Duck d2) {
        return d1.getWeight() - d2.getWeight();
    }

    public static int compareByName(Duck d1, Duck d2) {
        return d1.getName().compareTo(d2.getName());
    }
}
