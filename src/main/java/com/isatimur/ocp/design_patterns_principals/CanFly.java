package com.isatimur.ocp.design_patterns_principals;

public interface CanFly {
    void fly();
}

interface HasWings {
    public abstract Object getWingSpan();
}

abstract class Falcon implements CanFly, HasWings {

//    @Override
//    public void fly() {
//        System.out.println("ddd");
//    }
}