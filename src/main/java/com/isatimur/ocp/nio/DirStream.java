package com.isatimur.ocp.nio;

/**
 * Created by tisachenko on 25.04.16.
 */
import java.io.*;
import java.nio.file.*;
import java.util.Iterator;

public class DirStream{
    public static void main(String args[]) throws IOException {
        Path dir = Paths.get("/home/tisachenko/ROSTRUD/8");
        try (DirectoryStream<Path> stream=Files.newDirectoryStream(dir,"*.{txt~}")) {
//            for (Path value : stream) {
//                System.out.println(value + ":" + Files.isDirectory(value));
                Iterator iterator =  stream.iterator();
                while (iterator.hasNext()){
                    Files.delete((Path)iterator.next());
//                    System.out.println(iterator.next());

                }
//            }
        }
    }
}