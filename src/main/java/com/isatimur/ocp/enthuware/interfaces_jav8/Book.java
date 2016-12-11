package com.isatimur.ocp.enthuware.interfaces_jav8;

import java.util.ArrayList;
import java.util.List;

public class Book {
    String isbn;
    String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    } //accessors not shown //assume appropriate implementations of equals and hashCode based on isbn property

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();//getBooksByAuthor("Ludlum");
        books.stream().sorted().forEach(b->System.out.println(b.getIsbn())); //1
    }
}














