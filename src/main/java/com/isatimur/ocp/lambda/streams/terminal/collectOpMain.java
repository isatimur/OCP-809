package com.isatimur.ocp.lambda.streams.terminal;

import com.isatimur.ocp.lambda.streams.prologistic.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.isatimur.ocp.lambda.streams.prologistic.PersonStore.persons;

/**
 * Created by abyakimenko on 04.10.2016.
 */
public class collectOpMain {
    public static void main(String[] args) {

        // Collecting Using Basic Collectors
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        String result = ohMy.collect(Collectors.joining(", ", "[", "]"));

        StringJoiner stringJoiner = new StringJoiner(" --- ", "[", "]");
        stringJoiner.add("lions").add("tigers").add("bears");

        System.out.println(stringJoiner);
        System.out.println(result); // lions, tigers, bears

        Stream<String> ohMy1 = Stream.of("tlions", "tigers", "tigers", "tigers", "bears", "bears", "bears");
        TreeSet<String> result1 = ohMy1
                .filter(s -> s.startsWith("t"))
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println(result1); // [tigers]


        System.out.println("=============== COLLECT ====================");
        // <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)
        // <R,A> R collect(Collector<? super T, A,R> collector)

        // The collect()method is a special type of reduction called a mutable reduction
        // The first parameter is a Supplierthat creates the object that will store the results as we
        // collect data. Remember that a Supplierdoesn’t take any parameters and returns a value.
        // In this case, it constructs a new StringBuilder.

        Stream<String> stream12 = Stream.of("w", "o", "l", "f");
        StringBuilder word12 = stream12.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);


        // Now let’s look at an example where the logic is different in the accumulator and combiner:
        // The collector has three parts as before. The supplier creates an empty TreeSet. The
        // accumulator adds a single Stringfrom the Streamto the TreeSet. The combiner adds all
        // of the elements of one TreeSetto another in case the operations were done in parallel and
        // need to be merged.
        // We started with the long signature because that’s how you implement your own
        // collector. It is important to know how to do this for the exam and to understand how
        // collectors work. In practice, there are many common collectors that come up over and
        // over. Rather than making developers keep reimplementing the same ones, Java provides
        // an interface with common collectors. This approach also makes the code easier to read
        // because it is more expressive.

        Stream<String> stream13 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set = stream13.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(set); // [f, l, o, w]


        Stream<String> stream14 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set14 = stream14.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set14); // [f, l, o, w]

//        If we didn’t need the set to be sorted, we could make the code even shorter:
        Stream<String> stream15 = Stream.of("w", "o", "l", "f");
        Set<String> set15 = stream15.collect(Collectors.toSet());
        System.out.println(set15); // [f, w, l, o]

        List<Person> filtered =
                persons
                        .stream()
                        .filter(p -> p.getName().startsWith("I"))
                        .collect(Collectors.toList());// [Igor, Ira]

        System.out.println(filtered);

        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.getAge()));

        personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
        // age 20: [Andrew]
        // age 23: [Igor, Ira]
        // age 12: [Vitia]

        System.out.println(persons.stream().collect(Collectors.maxBy((p1, p2) -> p1.getAge() - p2.getAge())));


        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map = ohMy2.collect(Collectors.toMap(
                String::length, k -> k, (s1, s2) -> s1 + "," + s2));
        System.out.println(map); // {5=lions,bears, 6=tigers}
        System.out.println(map.getClass());

//        It so happens that the Mapreturned is a HashMap. This behavior is not guaranteed.
//                Suppose that we want to mandate that the code return a TreeMapinstead. No problem. We
//        would just add a constructor reference as a parameter:
        Stream<String> ohMy3 = Stream.of("lions", "tigers", "bears", "b", "be", "brs", "brss");
        Map<Integer, String> map1 = ohMy3.collect(Collectors.toMap(
                String::length, k -> k, (s1, s2) -> s1 + "," + s2, TreeMap::new));
        System.out.println(map1); // // {5=lions,bears, 6=tigers}
        System.out.println(map1.getClass()); // class. java.util.TreeMap
    }
}
