package com.isatimur.ocp.design_patterns_principals.functional.interfaces;

import com.isatimur.ocp.generics_collections.comparable.Animal;

//@FunctionalInterface
// It's not an Functional Interface
public interface Dance extends Sprint {
    void dance(Animal animal);
}