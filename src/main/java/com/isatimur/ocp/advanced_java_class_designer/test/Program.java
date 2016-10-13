package com.isatimur.ocp.advanced_java_class_designer.test;

import java.io.Console;

/**
 * Created by abyakimenko on 13.10.2016.
 */
public class Program {

    final private String name;

    Program(String name) {

        this.name = name;
        getName();
    }

    public String getName1() {
        return name;
    }

    private String getName() {
        return name + "a";
    }

    public static void main(String[] args) {

        Console console = System.console();
//        int i = (int)console.readLine("Enter value");
        String i = console.readLine("Enter value");
    }
}
