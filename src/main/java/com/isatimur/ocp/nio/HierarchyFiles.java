package com.isatimur.ocp.nio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by tisachenko on 23.04.16.
 */
public class HierarchyFiles {

    static LinkedHashMap<String, LinkedList<String>> flashCardsMap = new LinkedHashMap<>();

    //Here we go!
    public static void main(String[] args) {
        Path sourceDir = Paths.get("/home/tisachenko/ROSTRUD/");
        try {
            Files.walkFileTree(sourceDir, new LocalFileVisitor());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(flashCardsMap);

//        try {
//            Files.walkFileTree(sourceDir,new HierarchyFiles());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public static LocalFileVisitor getLocalFileVisitor() {
        return new LocalFileVisitor();
    }

    public static LinkedHashMap<String, LinkedList<String>> getFlashCardsMap() {
        return flashCardsMap;
    }

    private static class LocalFileVisitor implements FileVisitor<Path> {

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            String dirname = dir.getFileName().toString();
            if (dirname.startsWith("other"))
                return FileVisitResult.SKIP_SUBTREE;
            else
                return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            String filename = file.getFileName().toString();
            if (filename.endsWith(".txt")) {
                LinkedList<String> tips = new LinkedList<>();
                try (
                    BufferedReader reader = new BufferedReader(new FileReader(file.toFile()));
                )

                {
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        tips.add(line);
                    }

                }
                catch (IOException exc) {
                    System.out.println(exc);
                }
                flashCardsMap.put(filename.substring(0, filename.length() - 4), tips);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.out.println(exc);

            return FileVisitResult.SKIP_SUBTREE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }
    }
}


