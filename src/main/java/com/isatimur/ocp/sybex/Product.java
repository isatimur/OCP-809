package com.isatimur.ocp.sybex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Product implements Comparable<Product> {

    private int id;
    private String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Product)) {
            return false;
        }
        Product other = (Product) obj;
        return this.id == other.id;
    }

    public int compareTo(Product obj) {
        return this.name.compareTo(obj.name);
    }

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "ff"));
        list.add(new Product(2, "ee"));
        list.add(new Product(3, "dd"));
        list.add(new Product(4, "ccc"));
        list.add(new Product(5, "ccc"));
        list.add(new Product(6, "AAA"));

        Collections.sort(list);


    }
}