package main.com.isatimur.ocp.stream_api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by Isachenko Timur on 10.07.2016.
 */
public class FlatMapSamples {
    public static void main(String[] args) {
        Path path1 = Paths.get("InteractWithUserUsingConsole.java");
        Path path2 = Paths.get("ReadChars.java");
        Path path3 = Paths.get("BufferedReaderWriter.java");

        try (Stream<String> s1 = Files.lines(path1);
             Stream<String> s2 = Files.lines(path2);
             Stream<String> s3 = Files.lines(path3);
        ) {
//            Stream<String> s10 = Stream.concat(s1, s2);

//            s10.forEach(System.out::println);
            Function<String, Stream<String>> splitIntoWords =
//                    line -> Stream.of(line.split(" "));
                line -> Pattern.compile(" ").splitAsStream(line);
            Stream<Stream<String>> s = Stream.of(s1, s2, s3);
            Stream<String> streamOfWords = s.flatMap(Function.identity())
                .flatMap(splitIntoWords)
                .map(w -> w.toLowerCase())
                .distinct()
                .filter(w -> w.length() == 4)
//                    .peek(System.out::println)
//                    .collect(Collectors.toSet())
                ;
            System.out.println(streamOfWords.count());

        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
