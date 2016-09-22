package com.isatimur.ocp.mock_tests.collections;

import java.util.Hashtable;

/**
 * Created by developer on 9/18/16.
 */
public class CheckHashTables {
    public static void main(String[] args) {
        Hashtable hash = new Hashtable();
        hash.put(new AnswerToUltimateQuestion(), "a");
        hash.put(new AnswerToUltimateQuestion(), "b");
        hash.put(new AnswerToUltimateQuestion(), "c");
        System.out.println(hash);
        System.out.println(hash.get(new AnswerToUltimateQuestion()));

    }
}

class AnswerToUltimateQuestion {
    private int score = 0;

    @Override public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override public int hashCode() {
        return 42;
    }

    @Override public String toString() {
        return super.toString();
    }
}