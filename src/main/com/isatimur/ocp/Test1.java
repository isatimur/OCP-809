package com.isatimur.ocp;

/**
 * Created by Isachenko Timur on 07.08.2016.
 */
public class Test1 {
    public static void main(String[] args) {
        Book b1 = new Book(101, "Programming");
        Book b2 = new Book(102, "Programming");
        System.out.println(b1.equals(b2));
    }
}

class Book {
    int id;
    String name;

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        boolean output = false;
        Book b = (Book) obj;
        if (this.name.equals(b.name)) {
            output = true;
        }
        return output;
    }

}