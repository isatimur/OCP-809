package com.isatimur.ocp.design_patterns_principals.functional;

import com.isatimur.ocp.generics_collections.comparable.Animal;

@FunctionalInterface
public interface CheckTrait {
    boolean test(Animal a);
}