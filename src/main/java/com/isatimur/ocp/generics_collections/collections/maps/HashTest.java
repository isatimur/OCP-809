package com.isatimur.ocp.generics_collections.collections.maps;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Immutable class with one field
 */
class Key {
    private final String s;

    public Key(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    /**
     * equals method with correct behavior
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Key)) return false;
        String s = ((Key) obj).getS();
        return this.s == null ? s == null : this.s.equals(s);
    }

    /**
     * Bad hash function
     */
    @Override
    public int hashCode() {
//        return s.hashCode();
        return 5; // перехеширование будет происходить раньше - новая реализация хранения Entry в мапе
    }
}

public class HashTest {
    public static void main(String[] args) throws Exception {
        HashMap<Key, String> map = new HashMap<>(16);
        // fill the map
        int size = 500;
        for (int i = 0; i < size; i++) {

            System.out.println((i + 1) + " will be put");
            String s = "a" + i;

            Key key = new Key(s);
            map.put(key, s);
            printTableLength(map);
        }
        // after all map.table.length == 64 !!! если будет константный хешкод

        System.out.println("size before iteration " + map.size());
        Iterator<Key> itr = map.keySet().iterator();
        while (itr.hasNext()) {
            System.out.println(map.get(itr.next()));
        }
        System.out.println("size after iteration " + map.size());
    }

    /**
     * Helper method just to line out map condition
     */
    private static void printTableLength(HashMap map) throws Exception {

        Field field = HashMap.class.getDeclaredField("table");
        Field entrySetF = HashMap.class.getDeclaredField("entrySet");
        Field loadFactorF = HashMap.class.getDeclaredField("loadFactor");
        field.setAccessible(true);
        loadFactorF.setAccessible(true);
        entrySetF.setAccessible(true);
        Object[] table = (Object[]) field.get(map);
//        Object entrySet = entrySetF.get(map);
//        float loadFactor = (float) loadFactorF.get(map);
        int tableLength = table.length;
        int mapSize = map.size();
        double load = (double) mapSize / tableLength;
        System.out.println("size: " + mapSize +
                ", length: " + tableLength +
                ", load: " + load);
    }
}