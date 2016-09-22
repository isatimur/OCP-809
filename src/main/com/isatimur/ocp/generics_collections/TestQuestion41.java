package main.com.isatimur.ocp.generics_collections;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Isa Timur on 7/19/16.
 */
public class TestQuestion41 {
    public static void main(String args[]) {
        TreeSet<StringBuilder> treeSetNames = new TreeSet<StringBuilder>();
        treeSetNames.add(new StringBuilder("Shreya"));
        treeSetNames.add(new StringBuilder("Harry"));
        treeSetNames.add(new StringBuilder("Paul"));
        treeSetNames.add(new StringBuilder("Shreya"));
        Iterator it = treeSetNames.descendingIterator();
        while (it.hasNext())
            System.out.print(it.next() + ":");
    }
}
