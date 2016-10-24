package com.isatimur.ocp.stream_api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Isachenko Timur on 10.07.2016.
 */
public class IntStreamIntro {
    public static void main(String[] args) throws IOException {
        Set<String> shakespearWords =
            Files.lines(Paths.get("words.shakespeare.txt"))
                .map(w -> w.toLowerCase())
                .collect(Collectors.toSet());

        Set<String> scrabbleWords =
            Files.lines(Paths.get("ospd.txt"))
                .map(w -> w.toLowerCase())
                .collect(Collectors.toSet());

        System.out.println("! Words of Shakespeare : " + shakespearWords.size());
        System.out.println("! Words of Screbble : " + scrabbleWords.size());
        final int[] scrabbleEnScore = {
            //a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p, q,r,s,t,u,v,w,x,y, z
            1, 3, 3, 2, 1, 5, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10
        };

        Function<String, Integer> score =
            word -> word.chars().map(letter -> scrabbleEnScore[letter - 'a']).sum();
        ToIntFunction<String> intScore =
            word -> word.chars().map(letter -> scrabbleEnScore[letter - 'a']).sum();

        System.out.println("Score of word hamburg: " + intScore.applyAsInt("hamburg"));

        String word = shakespearWords.stream().filter(w -> scrabbleWords.contains(w)).max(Comparator.comparing(score)).get();

        System.out.println("Best word: " + word);

        IntSummaryStatistics intSummaryStatistics = shakespearWords.stream().parallel().filter(scrabbleWords::contains).mapToInt(intScore).summaryStatistics();

        System.out.println("Stats: " + intSummaryStatistics);


        Predicate<? super String> predicate = s -> s.startsWith("g");
        Stream<String> stream1 = Stream.generate(() -> "growl! ");
        Stream<String> stream2 = Stream.generate(() -> "growl! ");
        boolean b1 = stream1.anyMatch(predicate);
        boolean b2 = stream2.allMatch(predicate);
        System.out.println(b1 + " " + b2);

        IntStream is = IntStream.empty();
//        is.average();

    }
}
