package main.com.isatimur.ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 * Created by tisachenko on 17.04.16.
 */
public class DeleteOldFiles {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("./myNotesFromConsole.txt");
        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
        FileTime fileTime = attr.creationTime();
        long currentTime = System.currentTimeMillis();
        FileTime dayOldFileTime = FileTime.fromMillis(currentTime - (1000 * 60 * 60 * 24));
        if (fileTime.compareTo(dayOldFileTime) < 0) {
            Files.delete(file);
        }
    }
}
