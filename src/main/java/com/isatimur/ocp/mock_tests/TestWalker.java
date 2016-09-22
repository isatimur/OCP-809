package com.isatimur.ocp.mock_tests;

/**
 * Created by developer on 9/18/16.
 */
public class TestWalker {
    public static void main(String[] args) {
//        UphillHiker w = new UphillHiker();
//        w.move(10);
//        w.getWalkerInfo(w);
        System.out.println();
//        Walker w = new UphillHiker();
//        w.move(10);
//        w.getWalkerInfo(w);
        System.out.println();
//        Walker w = new Walker();
//        w.move(10);
//        w.getWalkerInfo(w);
        System.out.println();
        Walker w = new Walker();
        w.move(10);
        UphillHiker.getWalkerInfo(w);
    }
}
