package main.com.isatimur.ocp.package_4.collections.list;

/**
 * Created by tisachenko on 17.03.16.
 */

import java.util.Arrays;

public class SearchArray2 {
    public static void main(String[] args) {
        Object[] myArray = new Object[3];
        myArray[0] = "Java";
        myArray[1] = "10";
        myArray[2] = "z";

        Arrays.sort(myArray);
        int position = Arrays.binarySearch(myArray, "Java");
        System.out.println(position);
    }
}