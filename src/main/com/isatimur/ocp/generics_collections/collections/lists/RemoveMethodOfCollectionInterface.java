package com.isatimur.ocp.generics_collections.collections.lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by developer on 8/6/16.
 */
public class RemoveMethodOfCollectionInterface {
    public static void main(String[] args) {

        System.out.println("===========ArrayList==========");
        List<String> birds = new ArrayList<>();
        birds.add("hawk");
        birds.add("hawk");
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

//        System.out.println(birds.remove(100)); throws IndexOutOfBoundException
    }
}
