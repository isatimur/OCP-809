package com.isatimur.ocp.package_4.streams;

import com.isatimur.ocp.enthuware.Book;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by tisachenko on 19.03.16.
 */
public class StreamsExample {
    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone with the wind", 5.0),
                new Book("Midnight Cowboy", 15.0)
        );

//        double sum = books.stream().flatMapToDouble(b -> b.getPrice()).filter(b -> b > 5.0).sum();
        double sum = books.stream().mapToDouble(b -> b.getPrice()).filter(b -> b > 5.0).sum();

        books.stream()
                .filter(b -> b.getTitle().startsWith("F"))
                .forEach(b -> b.setPrice(10.0));
        books.stream().filter(s -> s.getTitle().endsWith("night"))
                .forEach(b -> System.out.println(b.getTitle() + ":" + b.getPrice()));

        Map<String, Double> bookMap = books.stream().collect(Collectors.toMap((b -> b.getTitle()), b -> b.getPrice()));

        Consumer<Map.Entry<String, Double>> func = (e) -> {
            if (e.getKey().startsWith("A")) {
                System.out.println(e.getValue());
            }
        };
        // в Map foreach требует BiConsumer!!!
//        bookMap.forEach(func);


        IntStream is1 = IntStream.range(1, 3);
        IntStream is2 = IntStream.rangeClosed(1, 3);
        IntStream is3 = IntStream.concat(is1, is2);
        Object val = is3.boxed().collect(Collectors.groupingBy(k -> k)).get(3);
        System.out.println(val);


        List<String> values = Arrays.asList("Alpha A", "Alpha B", "Alpha C"); //INSERT CODE HERE System.out.println(flag);
        boolean flag1 = values.stream().allMatch(str -> str.equals("Alpha"));
        boolean flag2 = values.stream().findFirst().get().equals("Alpha");
        boolean flag3 = values.stream().findAny().get().equals("Alpha");
        boolean flag4 = values.stream().anyMatch(str -> str.equals("Alpha"));

        List<String> vals = Arrays.asList("a", "b");
        String join = vals.parallelStream().reduce("_", (a, b) -> a.concat(b));
        System.out.println(join);

        List<String> names = Arrays.asList("Peter", "Paul", "Pascal");
//        Optional<String> ops = names.stream().parallel().allMatch(name -> name != null).filter(name -> name.length() > 6).findAny();
//        System.out.println(ops);
        Pattern.compile(" ").splitAsStream("java 8 stream").flatMapToInt(i -> i.chars()).distinct().forEach(s -> System.out.print((char) s));

        System.out.println();

        new Random().ints().limit(5).forEach(System.out::println);
    }
}
