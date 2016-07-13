package com.isatimur.ocp.stream_api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by developer on 7/12/16.
 */
public class MainUsingCollectors {

    public static void main(String[] args) {
        Path shakespearePath = Paths.get("./words.shakespeare.txt");
        Path ospdPath = Paths.get("./ospd.txt");

        try (Stream<String> ospd = Files.lines(ospdPath);
             Stream<String> shakespeare = Files.lines(shakespearePath);) {

            Set<String> scrableWords = ospd.collect(Collectors.toSet());
            Set<String> shakespeareWords = shakespeare.collect(Collectors.toSet());

            System.out.println("Size of scrable words: " + scrableWords.size());
            System.out.println("Size of shakespeare words: " + shakespeareWords.size());

            final int[] scrabbleEnScore = {
//              a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p,  q, r, s, t, u, v, w, x, y,  z
                1, 3, 3, 2, 1, 5, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10
            };

            Function<String, Integer> score =
                word -> word.toLowerCase()
                    .chars()
//                    .filter(value -> scrableWords.contains(value))
                    .map(letter -> scrabbleEnScore[letter - 'a'])
                    .sum();

            Map<Integer, List<String>> histogramWordByScore = shakespeareWords.stream()
                .filter(value -> scrableWords.contains(value))
                .collect(
                    groupingBy(
                        score
                    )
                );

            System.out.println(" # histogramWordByScore:" + histogramWordByScore.size());

            histogramWordByScore.entrySet()
                .stream()
                .sorted(Comparator.comparing(e -> -e.getKey())
                ).limit(3)
                .forEach(entry -> System.out.println("key: " + entry.getKey() + " , value: " + entry.getValue()));
            final int[] scrabbleEnDistribution = {
//              a, b, c, d,  e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
                9, 2, 2, 1, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1
            };

            Function<String, Map<Integer, Long>> histoWord =
                word -> word.chars()
                    .boxed()
                    .collect(groupingBy(
                        letter -> letter,
                        Collectors.counting()
                    ));
            Function<String, Long> nBlanks =
                word -> histoWord.apply(word) //Map<Integer,Long> Map<letter, #of letters>
                    .entrySet()
                    .stream()
                    .mapToLong(
                        entry ->
                            Long.max(entry.getValue() - scrabbleEnDistribution[entry.getKey() - 'a'], 0L)
                    ).sum();

            System.out.println("# of blank for whizzing: " + nBlanks.apply("whizzing"));

            Function<String, Integer> score2 =
                word -> histoWord.apply(word)
                    .entrySet().stream()
                    .mapToInt(
                        entry -> scrabbleEnScore[entry.getKey() - 'a']
                            *
                            Integer.min(
                                entry.getValue().intValue(),
                                scrabbleEnDistribution[entry.getKey() - 'a'])
                    )
                    .sum();

            System.out.println("# score of blank for whizzing: " + score.apply("whizzing"));
            System.out.println("# score2 of blank for whizzing: " + score2.apply("whizzing"));

//            Map<Integer, List<String>> histogramWordByScore2 =
            shakespeareWords.stream()
                .filter(value -> scrableWords.contains(value))
                .filter(word -> nBlanks.apply(word) <= 2)
                .collect(
                    groupingBy(
                        score2
                    )
                ).entrySet()
                .stream()
                .sorted(Comparator.comparing(e -> -e.getKey())
                ).limit(3)
                .forEach(entry -> System.out.println("key: " + entry.getKey() + " , value: " + entry.getValue()));

        }
        catch (IOException ioException) {

        }

    }

}
