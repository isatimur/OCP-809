package com.isatimur.ocp.enthuware;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {

    static ConcurrentHashMap<String, Object> chm = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        chm.put("a", "aaa");
        chm.put("b", "bbb");
        chm.put("c", "ccc");
        new Thread(() -> {
            Iterator<Entry<String, Object>> it = Cache.chm.entrySet().iterator();
            while (it.hasNext()) {
                Entry<String, Object> en = it.next();
                if (en.getKey().equals("a") || en.getKey().equals("b")) {
                    it.remove();
                }
            }
        }).start();


        new Thread(() -> {
            Iterator<Entry<String, Object>> it = Cache.chm.entrySet().iterator();
            while (it.hasNext()) {
                Entry<String, Object> en = it.next();
                System.out.print(en.getKey() + ", ");
            }
        }).start();
    }
}