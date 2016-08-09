package com.isatimur.ocp.generics_collections.advance_java8;

import com.isatimur.ocp.generics_collections.comparator.Duck;
import com.isatimur.ocp.lambda.Predicate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by developer on 8/8/16.
 */
public class TestHelper {
    public static void main(String[] args) {
        Comparator<Duck> duckComparator = (d1, d2) -> DuckHelper.compareByWeight(d1, d2);
        Comparator<Duck> anotherDuckComparator = DuckHelper::compareByWeight;

        //static method
        Consumer<List<Integer>> methodRef1 = Collections::sort;
        BiConsumer<List<Integer>, Comparator<Integer>> biConsumer = Collections::sort;

        //instance specific method
        String str = "abc";
        Predicate<String> methodRef2 = str::startsWith;
        Predicate<String> lambda2 = s -> str.startsWith(s);

        //instance that doesn't take any parameter
        Predicate<String> methodRef3 = String::isEmpty;
        Predicate<String> lambda3 = (s) -> s.isEmpty();

        //constructor reference
        Supplier<ArrayList> methodRef4 = ArrayList::new;
        Supplier<ArrayList> lambda4 = () -> new ArrayList();

    }
}
