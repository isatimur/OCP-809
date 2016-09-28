package com.isatimur.ocp.design_patterns_principals.functional.interfaces;

public interface CanWalk {
    default String walk() {
        System.out.println("Walking");
        return "";
    }
}