package com.isatimur.ocp.generics_collections.collections.lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abyakimenko on 29.09.2016.
 */
public class DiamondOperator {

    private int XX = 20;

    public static void main(String[] args) {

//        Java has come a long way. Before Java 5 came out, you had to write code like the following
//        and hope that programmers remembered that you wanted only Stringobjects in there:
        List names = new ArrayList();

        Doggies doggies = new DiamondOperator().new Doggies();
        doggies.copyNames();
        List<String> names1 = doggies.names;
        List<String> names1w = doggies.namess;

        System.out.println(doggies.XX);
        System.out.println(doggies.YY);
    }

    class Doggies {

        List<String> names;
        private List<String> namess;
        private int XX = 10;
        private int YY = 10;

        Doggies() {
            names = new ArrayList<>(); // matches instance variable declaration
            XX = DiamondOperator.this.XX;
        }

        public void copyNames() {
            ArrayList<String> copyOfNames;
            copyOfNames = new ArrayList<>(); // matches local variable declaration
        }
    }
}
