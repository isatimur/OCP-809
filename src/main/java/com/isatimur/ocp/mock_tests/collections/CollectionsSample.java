package com.isatimur.ocp.mock_tests.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by developer on 9/12/16.
 */
public class CollectionsSample {
    public static void main(String[] args) {
        List<Integer> list1 = new CopyOnWriteArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> list2 = Collections.synchronizedList(new CopyOnWriteArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        for (Integer item : list1)
            list1.add(5);
//        synchronized (list2) {
//                  Iterator i = list2.iterator(); // Must be in synchronized block
//                  while (i.hasNext())
//                      list2.remove(i.next());
//              }
        for (Integer item : list2)
            list2.remove(0);
        System.out.println(list1.size() + " " + list2.size());
    }
}
