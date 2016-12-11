package com.isatimur.ocp.enthuware;

import java.util.*;
import java.util.function.DoubleSupplier;

public class Book {
    private String title;
    private Double price;
    private String genre;

    public Book(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public static void main(String[] args) {


        List<Book> books = Arrays.asList(new Book("Gone with the wind", 5.0),
                new Book("Gone with the wind", 10.0),
                new Book("Atlas Shrugged", 15.0));

        /**
         * The Collector created by Collectors.toMap throws java.lang.IllegalStateException if an attempt is made
         * to store a key that already exists in the Map. If you want to collect items in a Map and if you expect
         * duplicate entries in the source, you should use Collectors.toMap(Function, Function, BinaryOperator) method.
         * The third parameter is used to merge the duplicate entries to produce one entry. For example, in this case,
         * you can do: Collectors.toMap(b->b.getTitle(), b->b.getPrice(), (v1, v2)->v1+v2) This Collector will sum the
         * values of the entries that have the same key. Therefore, it will print : Gone with the wind 15.0 Atlas Shrugged 15.0
         */
        // не допускается дублей в ключах при такой перегрузке метода
        //books.stream().collect(Collectors.toMap((b -> b.getTitle()), b -> b.getPrice())).forEach((a, b) -> System.out.println(a + " " + b));

        Comparator<Book> c1 = (b1, b2) -> b1.getGenre().compareTo(b2.getGenre()); //1 books.stream().sorted(c1.thenComparing(Book::getTitle)); //2
        books.stream().sorted(c1.thenComparing(Book::getTitle)); //2
        books.forEach(x -> System.out.println(x.getGenre() + "::" + x.title + "-"));


        Map<String, ArrayList<String>> stateCitiesMap = new HashMap<>();

        List<String> cities = new ArrayList<>();
        cities.add("New York");
        cities.add("Albany");
        //stateCitiesMap.put("NY", cities);


        Book b1 = new Book("Java in 24 hrs", null);
        DoubleSupplier ds1 = b1::getPrice;
        System.out.println(b1.getTitle() + " " + ds1.getAsDouble());
    }
}