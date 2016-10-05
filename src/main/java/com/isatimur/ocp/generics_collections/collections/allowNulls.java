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


//        * Rotates the elements in the specified list by the specified distance.
//        * After calling this method, the element at index <tt>i</tt> will be
//        * the element previously at index (i - distance) mod list.size(),
//          for all values of <tt>i</tt> between <tt>0</tt>
//        * and <tt>list.size()-1</tt>, inclusive.  (This method has no effect on
//        * the size of the list.)
//          [t, a, n, k, s] => Collections.rotate(list, -4) => [s, t, a, n, k]

        // Сдвигает на length - distance
        List<Integer> gradesIntegers = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8)); // LENGTH=9
        Collections.rotate(gradesIntegers, 7);
        Collections.rotate(gradesIntegers, 7);

        List<String> grades = new ArrayList<>();
        grades.addAll(Arrays.asList(new String[]{"C", "A", "B", "A", "D"})); // LENGTH=5
        Collections.rotate(grades, 1);// CABAD
//        Collections.rotate(grades, 0);// CABAD
//        Collections.rotate(grades, -1);// ABADC
//        Collections.rotate(grades, 1);// CABAD
//        Collections.rotate(grades, 2);//ADCAB



    }
}
