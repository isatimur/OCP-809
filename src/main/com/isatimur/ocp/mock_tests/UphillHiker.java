package com.isatimur.ocp.mock_tests;

/**
 * Created by developer on 9/18/16.
 */

public class UphillHiker extends Walker {
    public double elevation;

    public static void getWalkerInfo(Walker w) {
        System.out.println(w.distance + "-" + w.elevation);
    }

    public int move(int data) {
        elevation += .5;
        return distance += data;
    }
}