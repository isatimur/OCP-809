package com.isatimur.ocp.generics_collections.generics;

/**
 * Created by developer on 8/5/16.
 */
public class Crate<T> {
    private T contents;

    public T emptyCrate() {
        return contents;
    }

    public void packCrate(T contents) {
        this.contents = contents;
    }
}
