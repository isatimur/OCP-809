package com.isatimur.ocp.package_4.collections.list;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by tisachenko on 11.03.16.
 */
public class ManipulateArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Ivan");
        arrayList.add("Max");
        arrayList.add("Ivan");

        arrayList.add(0, "Sergey");
        arrayList.remove("Ivan");

        String oldValue = arrayList.set(0, "Alex");

//        runtime exception indexoutofboundarray
// System.out.println(arrayList.get(7));
        System.out.println("list contains Ivan:" + arrayList.contains("Ivan"));
        ListIterator<String> iterator = arrayList.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
