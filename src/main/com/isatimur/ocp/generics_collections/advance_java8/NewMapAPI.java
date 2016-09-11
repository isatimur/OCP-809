package com.isatimur.ocp.generics_collections.advance_java8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Created by Isa Timur on 8/8/16.
 */
public class NewMapAPI {
    public static void main(String[] args) {
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", null);

        favorites.putIfAbsent("Jenny", "Tram");
        favorites.putIfAbsent("Sam", "Tram");
        favorites.putIfAbsent("Tom", "Tram");
        System.out.println(favorites);

        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;

        String jenny = favorites.merge("Jenny", "Skyride", mapper);
        String tom = favorites.merge("Tom", "Skyride", mapper);

        System.out.println(favorites);
        System.out.println(jenny);
        System.out.println(tom);

        BiFunction<String, String, String> mapperNull = (v1, v2) -> null;

        Map<String, String> favoritesM = new HashMap<>();
        favoritesM.put("Jenny", "Bus Tour");
        favoritesM.put("Tom", "Bus Tour");

        favoritesM.merge("Jenny", "Skyride", mapperNull);
        favoritesM.merge("Sam", "Skyride", mapperNull);

        System.out.println(favoritesM);

    }
}
