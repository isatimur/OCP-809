package com.isatimur.ocp.generics_collections.collections.maps;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestMap {

    public static void main(String[] args) {

        class MyKey {
            Integer i;

            public MyKey(Integer i) {
                this.i = i;
            }

            @Override
            public int hashCode() {
                // On my core i5-2500k @ 3.6Ghz it takes more than 45 minutes with java 8u40 (I stopped the process after 45 minutes).
//                return 1;
                return i;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                MyKey myKey = (MyKey) o;

                return i != null ? i.equals(myKey.i) : myKey.i == null;
            }
        }

        Date begin = new Date();
        Map<MyKey, String> myMap = new HashMap<>(2_500_000, 1);
        for (int i = 0; i < 2_000_000; i++) {
            myMap.put(new MyKey(i), "test " + i);
//            System.out.println(i + " is putted to map");
        }

        Date end = new Date();
        System.out.println("Duration (ms) " + (end.getTime() - begin.getTime()));
    }
}