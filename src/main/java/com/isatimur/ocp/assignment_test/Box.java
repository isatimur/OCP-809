package com.isatimur.ocp.assignment_test;

public class Box<T> {
    T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static void main(String[] args) {
        Box<String> one = new Box<String>("a string");
        Box<Integer> two = new Box<>(123);
        System.out.print(one.getValue());
        System.out.print(two.getValue());
    }
}

//A.  Compiler error on line 1.
//B.  Compiler error on line 2.
//C.  Compiler error on line 11.
//D.  Compiler error on line 12.

//E.  ======== a string123 ========

//F.  An exception is thrown.