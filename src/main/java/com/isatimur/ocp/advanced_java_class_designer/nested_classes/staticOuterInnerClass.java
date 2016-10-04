package com.isatimur.ocp.advanced_java_class_designer.nested_classes;

public class staticOuterInnerClass {

    String ss;
    public static class Nested {
        private int price = 6;
        int priceDef = 6;
    }

    public static void main(String[] args) {

        Nested nested = new Nested();
        int price = new Nested().price;
    }
}