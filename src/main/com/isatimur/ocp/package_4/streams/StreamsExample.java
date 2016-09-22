package main.com.isatimur.ocp.package_4.streams;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by tisachenko on 19.03.16.
 */
public class StreamsExample {
    public static void main(String[] args) {
        Pattern.compile(" ").splitAsStream("java 8 stream").flatMapToInt(i -> i.chars()).distinct().forEach(s -> System.out.print((char)s));

        System.out.println();

        new Random().ints().limit(5).forEach(System.out::println);
    }
}
