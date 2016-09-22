package com.isatimur.ocp.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Isa Timur on 8/27/16.
 */
public class ConcurrentCollections {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4, 3, 52));
        for (Integer i : list) {
            System.out.println(i + " ");
            list.add(9);
        }
        System.out.println();
        System.out.println("Size: " + list.size());
        System.out.println(list);
        System.out.println(

        );
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>(Arrays.asList(4, 32, 53)));
        synchronized (synchronizedList) {
            for (int data : synchronizedList) {
                System.out.print(data + " ");
            }
        }

        System.out.println(

        );

        Map<String, Object> foodData = new HashMap<String, Object>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        Map<String, Object> synchronizedFoodData = Collections.synchronizedMap(foodData);
        for (String key : synchronizedFoodData.keySet()) {
            synchronizedFoodData.get(key);
        }
//            synchronizedFoodData.remove(key); ConcurrentModificationException
    }
}
