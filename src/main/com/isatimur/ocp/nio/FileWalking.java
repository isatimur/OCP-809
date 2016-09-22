package main.com.isatimur.ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Isa Timur on 9/9/16.
 */
public class FileWalking {
    public static void main(String[] args) {
        Path path = Paths.get("/home/developer/projects/OCP-809");
        try {
            Files.walk(path).filter(p -> p.toString().endsWith(".java")).forEach(System.out::println);
        }
        catch (IOException e) {

        }
    }
}
