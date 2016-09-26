package com.isatimur.ocp.advanced_java_class_designer.nested_classes;

public class localOuterInnerClass {
    private int length = 5;

    public void calculate() {
        final int width = 20;
        class Inner {
            public void multiply() {
                int length = localOuterInnerClass.this.length;
                System.out.println(localOuterInnerClass.this.length * width);
            }
        }
        Inner inner = new Inner();
        inner.multiply();
    }
}