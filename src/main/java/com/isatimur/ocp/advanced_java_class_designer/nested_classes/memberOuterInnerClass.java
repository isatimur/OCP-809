package com.isatimur.ocp.advanced_java_class_designer.nested_classes;

public class memberOuterInnerClass {

    private String greeting = "Hi";
    private int x = 10;
    private final int XX;
    private final static int YY = 0;

    public memberOuterInnerClass() {
        XX = 0;
    }

    public void callInner() {
        Inner inner = new Inner();
        inner.go();
    }

    protected class Inner {
        public int repeat = 3;
        public int x = 33;

        public void go() {

            System.out.println(x);
            System.out.println(memberOuterInnerClass.this.x);

            for (int i = 0; i < repeat; i++)
                System.out.println(greeting);
        }
    }
}