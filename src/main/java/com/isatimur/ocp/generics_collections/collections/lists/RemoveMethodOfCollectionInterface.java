package com.isatimur.ocp.generics_collections.collections.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Isa Timur on 8/6/16.
 */
public class RemoveMethodOfCollectionInterface {
    public static void main(String[] args) {

        System.out.println("===========ArrayList==========");
        List<String> birds = new ArrayList<>();
        birds.add("hawk");
        birds.add("hawk");
        birds.add("hawk");
        birds.add("hawk");
        birds.add("hawk");
        birds.remove(1);

        List<String> subBirds = birds.subList(0, 4);
        System.out.println(birds.remove("cardinal"));
        System.out.println(birds.remove("hawk"));
        System.out.println(birds);
        System.out.println(birds.isEmpty());
        System.out.println(birds.size());
        System.out.println(birds.contains("hawk"));
        System.out.println(birds.contains("robin"));

        birds.clear();
        System.out.println(birds.isEmpty());
        System.out.println(birds.size());


        String[] array = {"gerbil", "mouse"}; // [gerbil, mouse]
        List<String> list = Arrays.asList(array); // returns fixed size list
        List<String> list1 = Arrays.asList("1", "2", "3", "4", "5");
        list.set(1, "test"); // [gerbil, test]
        array[0] = "new"; // [new, test]
        String[] array2 = (String[]) list.toArray(); // [new, test]

//        list1.remove(1);// throws UnsupportedOperationException
//        list.remove(1);// throws UnsupportedOperationException
        List<String> list3 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        list3.remove(1);
        System.out.println(list3);
        list3.remove(2);
        System.out.println(list3);
        list3.remove(1);
        System.out.println(list3);
        // System.out.println(birds.remove(100));// throws IndexOutOfBoundException
    }
}
