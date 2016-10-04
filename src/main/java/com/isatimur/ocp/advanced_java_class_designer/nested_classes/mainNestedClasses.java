package com.isatimur.ocp.advanced_java_class_designer.nested_classes;

/**
 * Created by abyakimenko on 22.09.2016.
 */
public class mainNestedClasses {

    public static void main(String[] args) {

        // Member Inner Classes
        memberOuterInnerClass outer = new memberOuterInnerClass();
        outer.callInner();

        memberOuterInnerClass.Inner inner = outer.new Inner();
        inner.go();
        //Member Inner Classes

        //Outer local
        localOuterInnerClass localOuterInnerClass = new localOuterInnerClass();
        localOuterInnerClass.calculate();

        //Anonymous inner class - обычно с событиями
        anonymousOuterClass anonymousOuterClass = new anonymousOuterClass();
        anonymousOuterClass.admission(45);

        // Static Nested Classes
        staticOuterInnerClass.Nested nested = new staticOuterInnerClass.Nested();
        int pric = new staticOuterInnerClass.Nested().priceDef;
//        System.out.println(nested.price);
    }
}
