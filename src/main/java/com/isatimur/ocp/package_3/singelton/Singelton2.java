package com.isatimur.ocp.package_3.singelton;

/**
 * Created by tisachenko on 01.03.16.
 */
public class Singelton2 {
    private static final Singelton2 instance = new Singelton2();

    private Singelton2() {
        System.out.println("private singelton2");
    }

    public static Singelton2 getINSTANCE() {
        return instance;
    }
}
