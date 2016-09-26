package com.isatimur.ocp.advanced_java_class_designer.enums;

public enum OnlyOne {
    ONCE(true);

    OnlyOne(boolean b) {
        System.out.println("constructing");
    }
}