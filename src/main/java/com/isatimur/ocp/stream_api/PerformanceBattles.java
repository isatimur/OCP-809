package com.isatimur.ocp.stream_api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.OptionalDouble;
import java.util.Spliterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by Isachenko Timur on 11.07.2016.
 */
public class PerformanceBattles {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long currentTime = System.currentTimeMillis();
        //first example
//        List<Long> list = new ArrayList<>(10_000_100);
//        for (int i = 0; i < 10_000_000; i++) {
//            list.add(ThreadLocalRandom.current().nextLong());
//        }

        //second example
//        Stream<Long> stream = Stream.generate(() -> ThreadLocalRandom.current().nextLong());
//        List<Long> list = stream.limit(10_000_000).collect(Collectors.toList());

        //third example
//        Stream<Long> stream = ThreadLocalRandom.current().longs(10_000_000).mapToObj(Long::new);
//        List<Long> list = stream.collect(Collectors.toList());

        System.out.println(System.currentTimeMillis() - currentTime);

        Path filePath = Paths.get("people.txt");

        try (Stream<String> lines = Files.lines(filePath);) {

            Spliterator<String> lineSliterator = lines.spliterator();
            Spliterator<Person> peopleSpliterator = new PersonSpliterator(lineSliterator);

            Stream<Person> people = StreamSupport.stream(peopleSpliterator, false);

            ForkJoinPool fjp = new ForkJoinPool(2);
            OptionalDouble optionalDouble = fjp.submit(() ->
                people.parallel().mapToInt(p -> p.getAge()).filter(age -> age > 27).average()
            ).get();
            System.out.println(optionalDouble);
//            people.forEach(System.out::println);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
