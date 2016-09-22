package main.com.isatimur.ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Created by Isa Timur on 9/9/16.
 */
public class FileWalkingOrFind {
    public static void main(String[] args) {
        long dateFilter = Instant.now().minus(2, ChronoUnit.DAYS).toEpochMilli();

        Path path = Paths.get("../");
        try {
            Files.find(path, 10, (p, a) -> p.toString().endsWith(".java") && a.lastModifiedTime().toMillis() > dateFilter).map(a -> a.toAbsolutePath()).forEach(System.out::println);
            System.out.println();
            Files.list(path).map(a -> a.toAbsolutePath().normalize()).forEach(System.out::println);

        }
        catch (IOException e) {

        }
    }
}
