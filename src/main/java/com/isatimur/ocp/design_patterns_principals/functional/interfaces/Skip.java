package com.isatimur.ocp.design_patterns_principals.functional.interfaces;

import com.isatimur.ocp.generics_collections.comparable.Kangaroo;

public interface Skip extends Sprint {
    default int getHopCount(Kangaroo kangaroo) {
        return 10;
    }

    static void skip(int speed) {
    }
}