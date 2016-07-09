package com.isatimur.ocp.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;

/**
 * Created by developer on 7/9/16.
 */
public class MainApiCollection {
    public static void main(String[] args) {
        Person p1 = new Person(23, "Alice", "B");
        Person p2 = new Person(26, "Ksenia", "A");
        Person p3 = new Person(43, "Timur", "D");
        Person p4 = new Person(38, "Diana", "C");
        Person p5 = new Person(25, "MIkhail", "T");
        Person p6 = new Person(39, "Valentina", "Y");

        List<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6));

        people.removeIf(p -> p.getAge() < 30);

        people.replaceAll(person -> new Person(person.getAge(), person.getFirstName().toUpperCase(), person.getLastName()));

        people.sort(comparing(Person::getAge).reversed());

        people.forEach(System.out::println);

        City newYork = new City("New York");
        City shanghai = new City("Shanghai");
        City paris = new City("Paris");

        Map<City, List<Person>> map = new HashMap<>();

        map.putIfAbsent(paris, new ArrayList<>());
        map.get(paris).add(p1);

        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p2);
        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p3);

        System.out.println("People from Paris: " + map.getOrDefault(paris, Collections.emptyList()));
        System.out.println("People from New York: " + map.getOrDefault(newYork, Collections.emptyList()));

        Map<City, List<Person>> map1 = new HashMap<>();

        map1.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p1);
        map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p2);
        map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p3);

        System.out.println("Map 1");
        map1.forEach((city, peopl) -> System.out.println(city + " : " + peopl));

        Map<City, List<Person>> map2 = new HashMap<>();

        map2.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p4);
        map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p5);
        map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p6);

        System.out.println("Map 2");
        map2.forEach((city, peopl) -> System.out.println(city + " : " + peopl));

        map2.forEach(
            (city, persons) -> {
                map1.merge(city, persons, (peopleFromMap1, peopleFromMap2) -> {
                    peopleFromMap1.addAll(peopleFromMap2);
                    return peopleFromMap1;
                });
            }
        );

        System.out.println("Merge1");
        map1.forEach(((city, persons) -> System.out.println(city + " : " + persons)));

        System.out.println("==============================================");
        people.stream()
            .skip(2)
            .limit(3)
            .filter(person -> person.getAge() > 20)
            .forEach(System.out::println);

    }

}

class City {
    private String name;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return "City{" +
            "name='" + name + '\'' +
            '}';
    }
}