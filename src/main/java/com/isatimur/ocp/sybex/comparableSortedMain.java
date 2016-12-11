package com.isatimur.ocp.sybex;


import com.isatimur.ocp.generics_collections.comparator.Duck;

import java.util.*;

/**
 * Created by abyakimenko on 02.10.2016.
 */
public class comparableSortedMain implements Comparable<comparableSortedMain>, Comparator<comparableSortedMain> {

    private int num;
    private String text;

    public comparableSortedMain(int num, String text) {
        this.num = num;
        this.text = text;
    }

    public static void main(String[] args) {

//        List ints = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
//        List<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(12);
        queue.remove(12);
        queue.remove(new Integer(12));
//      queue.remove(12); // метод листа. Если тип ссылки LinkedList - будет искать по индексу при указании примитива
//      инта, иначе по объекту - new Integer(12)
//      queue.remove(12); // метод листа. Если тип ссылки Queue - будет искать по значению

        System.out.println(queue);

        comparableSortedMain s1 = new comparableSortedMain(88, "a");
        comparableSortedMain s2 = new comparableSortedMain(55, "b");

        TreeSet<comparableSortedMain> t1 = new TreeSet<>();
        t1.add(s1);
        t1.add(s2);

        TreeSet<comparableSortedMain> t2 = new TreeSet<>(s1);// будет использоваться компаратор, так как передан
        // в конструктор трисета
        t2.add(s1);
        t2.add(s2);

        Comparator<Duck> byWeight1 = (d1, d2) -> d1.getWeight() - d2.getWeight();
        Comparator<Duck> byWeight2 = (Duck d1, Duck d2) -> d1.getWeight() - d2.getWeight();

        Comparator<Duck> byWeight3 = (d1, d2) -> {
            return d1.getWeight() - d2.getWeight();
        };
        Comparator<Duck> byWeight4 = (Duck d1, Duck d2) -> {
            return d1.getWeight() - d2.getWeight();
        };

        System.out.println(t1 + " " + t2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        comparableSortedMain that = (comparableSortedMain) o;

        if (num != that.num) return false;
        return text != null ? text.equals(that.text) : that.text == null;

    }

    @Override
    public int hashCode() {
        int result = num;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "" + num;
    }

    @Override
    public int compareTo(comparableSortedMain o) {
        return text.compareTo(o.text);
    }

    @Override
    public int compare(comparableSortedMain o1, comparableSortedMain o2) {
        return o1.num - o2.num;
    }
}
