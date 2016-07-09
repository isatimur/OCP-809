package com.isatimur.ocp.package_4.collections.queue;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by tisachenko on 11.03.16.
 */
public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.offer("JavA");
        list.push("e");
        list.add(1, "Guru");

        System.out.println(list);
        System.out.println(list.remove("e"));

        Iterator<String> it = list.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}
