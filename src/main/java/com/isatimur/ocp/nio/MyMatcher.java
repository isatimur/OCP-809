package com.isatimur.ocp.nio;

/**
 * Created by tisachenko on 25.04.16.
 */

import java.io.IOException;
import java.nio.file.*;

public class MyMatcher {
    public static void main(String args[]) throws IOException {
        Path dir = Paths.get("/home/tisachenko/ROSTRUD/8");
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("regex:[1-9]*[0-9]?-[1-9]?.txt");


        Path file = Paths.get("12-1.txt");
        if(pathMatcher.matches(file)){
            System.out.println(file);
        }
    }
}