package com.isatimur.ocp.concurrency;

import java.util.Deque;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Isa Timur on 8/26/16.
 */
public class ZooManagerAlternative {
    private Map<String, Object> foodData = new ConcurrentHashMap<>();

    public static void main(String[] args) {
//        Map<String, Object> foodData = new HashMap<String, Object>();
//        foodData.put("penguin", 1);
//        foodData.put("flamingo", 2);
//        for (String key : foodData.keySet()) {
//            synchronized (foodData) {
//                foodData.remove(key);
//            }
//        }
        System.out.println("==========fixed==========");

//        Map<String, Object> foodData = new ConcurrentHashMap<>();
//        foodData.put("penguin", 1);
//        foodData.put("flamingo", 2);
//        for (String key : foodData.keySet())
//            foodData.remove(key);

        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("zebra", 52);
        map.put("Elephant", 10);
        System.out.println(map.get("Elephant"));

        Deque<Integer> deque = new ConcurrentLinkedDeque<>();

        deque.offer(12);
        deque.push(52);
        System.out.println(deque.peek());
        System.out.println(deque.pop());

        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(32);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }

    public synchronized void put(String key, Object value) {
        foodData.put(key, value);
    }

    public synchronized Object get(String key) {
        return foodData.get(key);
    }
}
