package com.isatimur.ocp.io;

import com.isatimur.ocp.generics_collections.comparable.Animal;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Isa Timur on 9/6/16.
 */
public class PrintWriterExample {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("print()");

        try (PrintWriter out = new PrintWriter("zoo.log")) {
            out.print(5);
            out.write(String.valueOf(5));

            out.print(2.0);
            out.write(String.valueOf(2.0));

            Animal animal = new Animal();
            out.print(animal);
            out.write(animal == null ? "null" : animal.toString());
        }
    }

}
