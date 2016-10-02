package com.isatimur.ocp.generics_collections.searching_sorting;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by abyakimenko on 02.10.2016.
 */
public class java8Additions {

    public static void main(String[] args) {

        // Static methods
        Consumer<List<Integer>> lambda1 = l -> Collections.sort(l);
        Consumer<List<Integer>> methodRef1 = Collections::sort;

        // Next up is calling an instance method on a specifi c instance:
        String str = "abc";
        Predicate<String> methodRef2 = str::startsWith;
        Predicate<String> lambda2 = s -> str.startsWith(s);

        // call an instance method without knowing the instance in advance
        Predicate<String> methodRef3 = String::isEmpty;
        Predicate<String> lambda3 = s -> s.isEmpty();

        // Finally, we have a constructor reference:
        // A constructor referenceis a special type of method reference that uses newinstead of a
        // method, and it creates a new object. It expands like the method references you have seen
        // so far. You’ll see method references again in the next chapter when we cover more types of
        // functional interfaces.
        Supplier<ArrayList> methodRef4 = ArrayList::new;
        Supplier<ArrayList> lambda4 = () -> new ArrayList();


        // Removing Conditionally
        List<String> list = new ArrayList<>();
        list.add("Magician");
        list.add("Assistant");
        System.out.println(list); // [Magician, Assistant]
        list.removeIf(s -> s.startsWith("A"));
        System.out.println(list); // [Magician]

        // Updating All Elements
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        list1.replaceAll(x -> x * 2);
        System.out.println(list1); // [2, 4, 6]

        // Looping through a Collection
        List<String> cats = Arrays.asList("Annie", "Ripley");
        cats.forEach(System.out::println);

        // Using New Java 8 MapAPIs
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Jenny", "Tram");
        System.out.println(favorites); // {Jenny=Tram} - перезапишет как обычно делает мапа

        favorites.putIfAbsent("Jenny", "Tram");
        favorites.putIfAbsent("Sam", "Tram");
        favorites.putIfAbsent("Tom", "Tram");
        System.out.println(favorites); // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}

        // MERGE
        // The merge() method allows adding logic to the problem of what to choose. Suppose that
        // our guests are indecisive and can’t pick a favorite. They agree that the ride that has the longest name must
        // be the most fun. We can write code to express this by passing a mapping
        // function to the merge()method:
        BiFunction<String, String, String> mapper = (v1, v2)-> v1.length() > v2.length() ? v1: v2;
        Map<String, String> fvorites = new HashMap<>();
        fvorites.put("Jenny", "Bus Tour");
        fvorites.put("Tom", "Tram");
        String jenny = fvorites.merge("Jenny", "Skyride", mapper);
        String tom = fvorites.merge("Tom", "Skyride", mapper);

        System.out.println(fvorites); // {Tom=Skyride, Jenny=Bus Tour}
        System.out.println(jenny); // Bus Tour
        System.out.println(tom); // Skyride

        // The final thing to know about merge()is what happens when the mapping function is
        // called and returns null. The key is removed from the map when this happens:

        BiFunction<String, String, String> mapper1 = (v1, v2) -> null;
        Map<String, String> favorite = new HashMap<>();
        favorite.put("Jenny", "Bus Tour");
        favorite.put("Tom", "Bus Tour");
        favorite.merge("Jenny", "Skyride", mapper1);
        favorite.merge("Sam", "Skyride", mapper1);
        System.out.println(favorite); // {Tom=Bus Tour, Sam=Skyride}


    }
}
