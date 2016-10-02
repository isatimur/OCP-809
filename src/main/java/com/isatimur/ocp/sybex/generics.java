package com.isatimur.ocp.sybex;


import java.io.FileNotFoundException;

/**
 * Created by abyakimenko on 02.10.2016.
 */
public class generics {

    // !! method
    // при наличии иерархии и ограничении в методе типа, если создаём объект и не указываем тип для женерика -
    // подразумеваем, что там тип, которым ограничен метод

    public static <T> T identity(T t) {
        return t;
    }

    public static <T extends Exception> void printException(T t) {
        System.out.println(t.getMessage());
    }

    public static void main(String[] args) {
        generics.printException(new FileNotFoundException("AAA"));
        generics.<NullPointerException>printException(new NullPointerException("AAA"));
    }
}
