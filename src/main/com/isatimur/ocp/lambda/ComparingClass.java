package com.isatimur.ocp.lambda;

import java.util.function.Function;

interface Comparator<T> {
    public static <A> Comparator<A> comparing(Function<A, Comparable> func) {
        return (t1, t2) -> func.apply(t1).compareTo(func.apply(t2));
    }

    int compare(T t1, T t2);

    public default Comparator<T> thenComparing(Comparator<T> cmp) {
        return (p1, p2) -> (compare(p1, p2) == 0 ? cmp.compare(p1, p2) : compare(p1, p2));
    }

    public default Comparator<T> thenComparing(Function<T, Comparable> func) {
        return thenComparing(comparing(func));
    }
}

/**
 * Created by dns2 on 05.07.2016.
 */
public class ComparingClass {
    public static void main(String[] args) {
        Comparator<Person> cmpAge = (c1, c2) -> {
            return c1.getAge() - c2.getAge();
        };
        Comparator<Person> cmpFirstName = (c1, c2) -> {
            return c1.getFirstName().compareTo(c2.getFirstName());
        };
        Comparator<Person> cmpLastName = (c1, c2) -> {
            return c1.getLastName().compareTo(c2.getLastName());
        };
        Function<Person, Integer> function = p -> p.getAge();
        Function<Person, String> functionFirstName = p -> p.getFirstName();
        Function<Person, String> functionLastName = p -> p.getLastName();

        Comparator<Person> cmpPerson = Comparator.comparing(Person::getAge);
        Comparator<Person> cmpPersonFirstName = Comparator.comparing(Person::getFirstName);

        Comparator<Person> cmp = cmpPerson.thenComparing(cmpPersonFirstName);
    }

}

class Person {
    private int age;
    private String firstName;
    private String lastName;

    public Person(int age, String firstName, String lastName) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
            "age=" + age +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
    }
}