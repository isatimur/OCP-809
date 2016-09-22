package main.com.isatimur.ocp.package_4.streams;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by abyakimenko on 19.03.2016.
 */
public class Streams {
    public static void main(String[] args) {

        new Random().ints().limit(15).forEach(System.out::println);

        List<Integer> intList = new LinkedList<>();
        List<Double> dblList = new LinkedList<>();
        System.out.println("First type: " + intList.getClass());
        System.out.println("Second type:" + dblList.getClass());

        String[] brics = {"Brazil", "Russia", "India", "China"};
        Arrays.sort(brics, null); // LINE A
        for (String country : brics) {
            System.out.print(country + " ");
        }

        "abracadabra".chars().distinct().peek(ch -> System.out.printf("%c ", ch)).sorted();
    }
}
