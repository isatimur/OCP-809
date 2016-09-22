package com.isatimur.ocp.mock_tests;

/**
 * Created by developer on 9/18/16.
 */
public class Walker {
    protected double elevation;
    protected int distance;

    protected static void getWalkerInfo(Walker w) {
        System.out.println(w.distance);
    }

    int move(int data) {
        return distance += data;
    }
}
