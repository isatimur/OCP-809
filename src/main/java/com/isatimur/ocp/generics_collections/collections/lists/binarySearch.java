package com.isatimur.ocp.generics_collections.collections.lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by abyakimenko on 29.09.2016.
 */
public class binarySearch {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(9, 7, 5, 3);
        System.out.println(Collections.binarySearch(list, 4)); // 0

        List<String> stringList = Arrays.asList("aab", "Xx", "d", "ff", "xx", "AAb", "AAAb", "AAAAb");

        System.out.println(".....going to sort.....");
        Collections.sort(list); // [3, 5, 7, 9]
        System.out.println(Collections.binarySearch(list, 3)); // 0
        System.out.println(Collections.binarySearch(list, 2)); // -1
        // вернёт индекс на 1 меньше, чем бы занимало искомое значение, будучи вставленным в отсортированный список


        Collections.sort(stringList);
        System.out.println(stringList);
    }
}
