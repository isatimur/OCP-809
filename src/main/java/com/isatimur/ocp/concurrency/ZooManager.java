package com.isatimur.ocp.concurrency;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Isa Timur on 8/26/16.
 */
public class ZooManager {
    private Map<String, Object> foodData = new HashMap<>();

    public static void main(String[] args) {

    }

    public synchronized void put(String key, Object value) {
        foodData.put(key, value);
    }

    public synchronized Object get(String key) {
        return foodData.get(key);
    }
}
