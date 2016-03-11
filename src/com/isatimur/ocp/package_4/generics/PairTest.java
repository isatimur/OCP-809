package com.isatimur.ocp.package_4.generics;

/**
 * Created by tisachenko on 07.03.16.
 */
public class PairTest {

    public static void main(String[] args) {
        Pair<Integer, String> worldCup = new Pair<>(2018, "Russia");
        System.out.println("World cup: " + worldCup.getFirst() + " in " + worldCup.getSecond());
    }
}

class Pair<T1, T2> {
    T1 val1;
    T2 val2;

    public Pair(T1 val1, T2 val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public T1 getFirst() {
        return val1;
    }

    public T2 getSecond() {
        return val2;
    }
}
