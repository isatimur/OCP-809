package com.isatimur.ocp.generics_collections.collections.maps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Isa Timur on 8/7/16.
 */
public class MapsExample {

    public static void main(String[] args) {


        LinkedList linkedList = new LinkedList();
        linkedList.add("String 1");
        linkedList.add("String 2");
        linkedList.add("String 3");
        linkedList.add("String 4");
        linkedList.add("String 5");


        Point p1 = new Point(1,2,3);
        Point p2 = new Point(4,5,6);
        Point p3 = new Point(7,8,9);
        Point p4 = new Point(10,11,12);


        System.out.println("======HashMap======");
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("koala", "bamboo");
        hashMap.put("lion", "meat");
        hashMap.put("giraffe", "leaf");

        String food = hashMap.get("koala");
        for (String key : hashMap.keySet())
            System.out.println(key + ",");

        System.out.println("======TreeMap======");
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("koala", "bamboo");
        treeMap.put("lion", "meat");
        treeMap.put("giraffe", "leaf");

        String foodTree = treeMap.get("koala");
        for (String key : treeMap.keySet())
            System.out.println(key + ",");

        System.out.println(hashMap.containsKey("lion"));
        System.out.println(hashMap.containsValue("lion"));
        System.out.println(hashMap.size());
    }
}
