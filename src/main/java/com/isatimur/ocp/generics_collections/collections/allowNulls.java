package com.isatimur.ocp.generics_collections.collections;

import java.util.*;

/**
 * Created by abyakimenko on 02.10.2016.
 * THE DATA STRUCTURES THAT INVOLVE SORTING DO NOT ALLOW NULLS !!!
 */
public class allowNulls {
    // THE DATA STRUCTURES THAT INVOLVE SORTING DO NOT ALLOW NULLS !!!
    public static void main(String[] args) {

        /*
        IN HANDY LIST FORM, ALL DATA STRUCTURES ALLOW NULLS EXCEPT THESE:

        TreeMap—NO NULLKEYS

        Hashtable—NO NULLKEYS OR VALUES

        TreeSet—NO NULLELEMENTS

        ArrayDeque—NO NULLELEMENTS
        */

        System.out.println("====================== Map NULLs example ======================");
        Map<String, String> map = new HashMap<>();
        map.put(null, "1");
        map.put("null", "2");
        map.put("null11", null);


        TreeMap<String, String> treeMap = new TreeMap<>();
//        treeMap.put(null, "");// NPE
        treeMap.put("null", null);

        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("3");
        set.add(null);

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("1");
        treeSet.add("null");
//        treeSet.add(null);// NPE

//        Next comes ArrayDeque. You can’t put nullin an ArrayDequebecause methods
//        like poll()use nullas a special return value to indicate that the collection is empty.
//        Since null has that meaning, Java forbids putting a null in there. That would just be confusing.
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(1);
        arrayDeque.offer(12);
//        arrayDeque.offer(null);// NPE

//        Finally, Hashtabledoesn’t allow nullkeys or values
    }
}
