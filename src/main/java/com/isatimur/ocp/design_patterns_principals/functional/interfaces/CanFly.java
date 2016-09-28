package com.isatimur.ocp.design_patterns_principals.functional.interfaces;

public interface CanFly {
    void fly();
}

interface HasWings {
    public abstract Object getWingSpan();
}

abstract class Falcon implements CanFly, HasWings {
}