package com.isatimur.ocp.generics_collections.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isa Timur on 8/6/16.
 */
public class AllTogether {
    public static void main(String[] args) {
        List<?> list1 = new ArrayList<A>();
        List<? extends A> list2 = new ArrayList<>();
        List<? super A> list3 = new ArrayList<>();
//      List<? extends B> list4 = new ArrayList<A>();
        List<? super B> list5 = new ArrayList<A>();

        // The problem is that you need to know what that type will be when instantiating the ArrayList
        // List<?> list6 = new ArrayList<? extends A>();
    }

//    <T> String method22(List<T> ts) {
    <T> String method22(List<? extends T> ts) {
        return "";
    }

    <T> void method11(List<? extends T> ts) {
//        return ts.get(0);
    }

    <T> T method1(List<? extends T> ts) {
        return ts.get(0);
    }
//    a wrong example of generic return type!
//    <T> <? extends T> method2(List<? extends T> ts){
//        return ts.get(0);
//    }

//    cannot be instanciated directly
//    <B extends A> B method3(List<? extends B> list){
//        return new B();
//    }

    //    a normal example
    <T> void method4(List<? super B> list) {

    }

//    mix of bounded wildcard type and methods type  - can not be compiled
//    <X> void method5(List<X super B> list){
//
//    }
}
