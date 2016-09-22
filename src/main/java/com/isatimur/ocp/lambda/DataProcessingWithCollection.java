package com.isatimur.ocp.lambda;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * Created by Isa Timur on 7/8/16.
 */
public class DataProcessingWithCollection {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.forEach(System.out::println);
        people.removeIf(person -> person.getAge() < 20);

        List<String> names = null;
        names.replaceAll(name -> name.toUpperCase());
        names.replaceAll(String::toUpperCase);

        people.sort(
            comparing(Person::getFirstName).thenComparing(Person::getAge)
        );

    }

}
