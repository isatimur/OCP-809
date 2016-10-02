package com.isatimur.ocp.sybex;


import java.io.FileNotFoundException;

/**
 * Created by abyakimenko on 02.10.2016.
 */
public class generics {

    // !! method

    public static <T> T identity(T t) {
        return t;
    }

    public static <U extends Exception> void printException(U u) {
        System.out.println(u.getMessage());
    }

    public static void main(String[] args) {
        generics.printException(new FileNotFoundException("AAA"));
        generics.<NullPointerException>printException(new NullPointerException("AAA"));
    }
}
