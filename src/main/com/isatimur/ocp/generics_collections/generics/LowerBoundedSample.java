package com.isatimur.ocp.generics_collections.generics.lower_bounded_wildcard;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by developer on 8/6/16.
 */
public class LowerBoundedSample {
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("tweet");
        List<Object> objects = new ArrayList<>(strings);
        addSound(strings);
        addSound(objects);

        System.out.println(strings);
        System.out.println(objects);

        List<? super IOException> exceptions = new ArrayList<Exception>();
        //trick is here        -------->  this method doesn't compile
        //exceptions.add(new Exception());
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());
        exceptions.add(new FileSystemException("no file is here"));

    }

    public static void addSound(List<? super String> l) {
        l.add("quak");
        l.add("tryn");
    }
}
