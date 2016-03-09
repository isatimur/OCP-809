package com.isatimur.ocp.package_4.wildcard;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Тимакс on 09.03.2016.
 */
public class Courier {
    public static void main(String[] args) {
        List<MyBook> list = new ArrayList<MyBook>();
        list.add(new MyBook("Oracle"));
        list.add(new MyBook("Java"));
        wrapList(list);

        List<String> stringList = new ArrayList<>();
        stringList.add("Paul");
        stringList.add("Shreya");
        wrapList(stringList);

    }

    public static <T> void wrapList(List<T> list){
        for (T o: list){
            System.out.println("GiftWrap: "+o);
        }
    }
}
class Gift{}
class MyBook extends Gift{
    String title;

    public MyBook(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
