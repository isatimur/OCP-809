package com.isatimur.ocp.package_4.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tisachenko on 11.03.16.
 */
public class TestHashMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "Hello");
        map.put("1", "Hello1");
        map.put(null, "Null1");
        map.put(null, "Null2");
        System.out.println(map);
        System.out.println(map.get("1"));
    }
}
