package com.isatimur.ocp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Isachenko Timur on 07.08.2016.
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get(".gitignore");
        Stream<String> fc =Files.lines(file);
        fc.forEach(s-> System.out.println(s));
    }
}
