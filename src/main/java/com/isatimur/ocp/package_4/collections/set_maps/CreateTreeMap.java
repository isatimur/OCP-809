package com.isatimur.ocp.package_4.collections.set_maps;

import java.util.*;

/**
 * Created by tisachenko on 15.03.16.
 */
public class CreateTreeMap {

    public static void main(String[] args) {
        Map<Flavor, String> flavorStringMap = new TreeMap<>(new MyComparator());
        flavorStringMap.put(new Flavor("Chocolate"), "Pasha");
        flavorStringMap.put(new Flavor("Vanilla"), "Sergey");
        for (Flavor flavor : flavorStringMap.keySet()) {
            System.out.println(flavor.name);

        }
        System.out.println();
        Map<Person, String> personStringMap = new TreeMap<>();
        personStringMap.put(new Person("Pasha", 25), "Pasha");
        personStringMap.put(new Person("Sasha", 24), "Sasha");
        for (Person person : personStringMap.keySet()) {
            System.out.println(person.name + ":" + person.age);
        }

        System.out.println();
        TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(new Person("Sasha", 12));
        treeSet.add(new Person("Vasya", 40));
        treeSet.add(new Person("Petya", 30));

        Iterator<Person> iterator = treeSet.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());


    }

}

class MyComparator implements Comparator<Flavor> {

    @Override
    public int compare(Flavor o1, Flavor o2) {
        return o2.name.compareTo(o1.name);
    }
}

class Flavor implements Comparable<Flavor> {

    String name;

    public Flavor(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Flavor o) {
        return this.name.compareTo(o.name);
    }
}

class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return (this.age - o.age);
    }


//    @Override
//    public int compareTo(Person o) {
//        return 0;
//    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}