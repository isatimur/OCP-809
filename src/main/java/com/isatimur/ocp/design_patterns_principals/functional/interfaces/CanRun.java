package com.isatimur.ocp.design_patterns_principals.functional.interfaces;

public interface CanRun {
    public default void walk() {
        System.out.println("Walking");
    }

    public abstract void run();
}