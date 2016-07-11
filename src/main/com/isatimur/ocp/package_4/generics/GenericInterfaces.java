package com.isatimur.ocp.package_4.generics;

interface MyMap<K, V> {
    void put(K key, V value);

    V get(K key);

}

/**
 * Created by tisachenko on 09.03.16.
 */
public class GenericInterfaces {

    public static void main(String[] args) {
        MyMap map = new MapLegendNonGeneric();
        map.put("String", 1);
        System.out.println(map.get("String"));

        MyMap<String, Double> map2 = new MapLegendNonGeneric2<>();
        map2.put("String", 1d);
        System.out.println(map2.get("String"));

        MyMap<String, String> map3 = new MapLegendNonGeneric3<>();
        map3.put("String", "as");
        System.out.println(map3.get("String"));

    }
}

class MapLegendNonGeneric implements MyMap<String, Integer> {

    @Override
    public void put(String key, Integer value) {

    }

    @Override
    public Integer get(String key) {
        return 0;
    }

}

class MapLegendNonGeneric2<V> implements MyMap<String, V> {

    @Override
    public void put(String key, V value) {

    }

    @Override
    public V get(String key) {
        return null;
    }
}

class MapLegendNonGeneric3<K, V> implements MyMap<K, V> {

    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }
}
