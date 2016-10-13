package com.isatimur.ocp.advanced_java_class_designer;

public class Main {
    public static void main(String[] args) {
        // what will this program produce?
        B b = new B();
        b.m();
        b.callM();
        b.callSuperM();

        System.out.println("============");

        A a = new B();
        a.m();
        a.callM();
    }
}

class A implements I1 {
    public void callM() {
        m();
    }
}

class B extends A implements I2 {
    public void callSuperM() {
        super.m();
    }
}

interface I1 {
    default void m() {
        System.out.println("I1");
    }
}

interface I2 extends I1 {
    default void m() {
        System.out.println("I2");
    }
}