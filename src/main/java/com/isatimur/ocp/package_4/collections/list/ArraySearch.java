package com.isatimur.ocp.package_4.collections.list;

import java.util.Arrays;

/**
 * Created by tisachenko on 17.03.16.
 */
public class ArraySearch {
    public static void main(String[] args) {
        Object[] myArray = new Object[3];
        myArray[0] = "Java";
        myArray[1] = "EJava";
        myArray[2] = "Guru";
        Arrays.sort(myArray);
        int position = Arrays.binarySearch(myArray, "Java");
        System.out.println(position);
    }
}