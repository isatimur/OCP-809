package com.isatimur.ocp.stream_api;

import com.isatimur.ocp.stream_api.model.Actor;
import com.isatimur.ocp.stream_api.model.Movie;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by developer on 7/12/16.
 */
public class MainMoviesActors {
    public static void main(String[] args) throws IOException {
        Set<Movie> movies = new HashSet<>();
        Stream<String> lines = Files.lines(
            Paths.get("movies-mpaa.txt")
        );

        lines.forEach(
            (String line) -> {
                String[] elements = line.split("/");
                String title = elements[0].substring(0, elements[0].lastIndexOf("(")).trim();
                String releaseYear = elements[0].substring(elements[0].lastIndexOf("(") + 1, elements[0].lastIndexOf(")"));

                if (releaseYear.contains(",")) {
                    return;
                }

                Movie movie = new Movie(title, Integer.parseInt(releaseYear));
                for (int i = 1; i < elements.length; i++) {
                    String[] name = elements[i].split(", ");
                    String lastName = name[0].trim();
                    String firstName = "";
                    if (name.length > 1) {
                        firstName = name[1].trim();
                    }
                    Actor actor = new Actor(lastName, firstName);
                    movie.addActor(actor);

                }
                movies.add(movie);
            }
        );

        System.out.println("# movie = " + movies.size());
        long count = movies.stream()
            .flatMap(movie -> movie.actors().stream())
            .distinct()
            .count();
        System.out.println("Size of all actors: " + count);

        Map.Entry<Actor, Long> mostViewedActor = movies.stream()
            .flatMap(movie -> movie.actors().stream())
            .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
            ))
            .entrySet().stream()
            .max(
                Map.Entry.comparingByValue()
            )
            .get();
        System.out.println("Most viewed actor: " + mostViewedActor);

        Map.Entry<Integer, Map.Entry<Actor, AtomicLong>> bestActor = movies.stream()
            .parallel().collect(
                Collectors.groupingBy(
                    Movie::getReleaseYear,
                    Collector.of(
                        () -> new HashMap<Actor, AtomicLong>(),//supplier
                        (Map<Actor, AtomicLong> map, Movie movie) -> {
                            movie.actors().forEach(
                                actor -> map.computeIfAbsent(actor, a -> new AtomicLong()).incrementAndGet()
                            );
                        }, // accumulator
                        (map1, map2) -> {
                            map2.entrySet().forEach(
                                entry2 -> map1.merge(
                                    entry2.getKey(), entry2.getValue(),
                                    (al1, al2) -> {
                                        al1.addAndGet(al2.get());
                                        return al1;
                                    }
                                )
                            );
                            return map1;
                        },//combiner
                        Collector.Characteristics.IDENTITY_FINISH
                    )
                )
            ) //Map<Integer,Map<Actor,AtomicLong>>
            .entrySet()
            .stream()
            .parallel()
            .collect(
                Collectors.toMap(
                    entry -> entry.getKey(),
                    entry -> entry.getValue().entrySet()
                        .stream()
                        .max(
                            Map.Entry.comparingByValue(
                                Comparator.comparing(
                                    (AtomicLong l) -> l.get()
                                )
                            )

                        )
                        .get()
                )
            ).entrySet()
            .stream()
            .max(
                Map.Entry.comparingByValue(
                    Comparator.comparing(
                        entry -> entry.getValue().get()
                    )
                )
            )
            .get();
        System.out.println("Best Actor: " + bestActor);
    }
}
