package com.isatimur.ocp.design_patterns_principals.functional.interfaces;

import com.isatimur.ocp.generics_collections.comparable.Animal;

public interface SprintFaster extends Sprint {
    @Override
    void sprint(Animal animal);
}