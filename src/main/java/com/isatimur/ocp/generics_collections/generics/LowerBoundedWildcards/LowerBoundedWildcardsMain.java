package com.isatimur.ocp.generics_collections.generics.LowerBoundedWildcards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by abyakimenko on 30.09.2016.
 */
public class LowerBoundedWildcardsMain {

//    No (upperbounded generics        are immutable)
//    public static void addSound(List<? extends Object> list) {
//        list.add("quack");
//    }

//    public static void addSound(List<?> list) {
//        list.add("quack");
//    }
//    No (unbounded generics are immutable)

    public static void addSound(List<? super String> list) {
        list.add("quack");
    }

    public static void main(String[] args) throws IOException{

        List<String> strings = new ArrayList<>();
        strings.add("tweet");
        List<Object> objects = new ArrayList<>(strings);

        addSound(strings);
        addSound(objects);
        addSound(Arrays.asList(1, 2, 3, 4, 5));

//        List<? super Exception> exceptions = new ArrayList<>();
        List<? super IOException> exceptions = new ArrayList<>();

        // при операциях добавления работает как extends - от IOException и до его потомков
        // exceptions.add(new Exception()); // DOES NOT COMPILE ?!
        // exceptions.add(new Object());

        // при операциях можем юзать только super IOException и наследников этого типа
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());
    }
}
