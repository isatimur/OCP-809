package com.isatimur.ocp.enthuware;


// Which fields of the above class will be preserved(сохранились) when the object referred to by the variable 'd' is serialized
// and deserialized in another JVM?

import java.io.Serializable;

/**
 * Remember that static fields are never serialized irrespective of whether they are marked transient or not.
 * In fact, making static fields as transient is redundant. Thus, f1, f2 and f4 will not be serialized at all.
 * However, since f4 is being initialized as a part of class initialization, it will be initialized to the same
 * value in another JVM. Thus, its value will be same as the one initialized by the code.
 */
public class Data implements Serializable {

    public static String f1;
    public static transient int f2;
    public transient boolean f3;
    public final static String f4 = "4";
    public String f5 = "5";

    public static void main(String[] args) {

        Data d = new Data();
        d.f1 = "f1";
        d.f2 = 2;
        d.f3 = true;
    }
}