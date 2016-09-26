package com.isatimur.ocp.design_patterns_principals.LivesInOcean;

/**
 * Created by abyakimenko on 26.09.2016.
 */
public class Oceanographer {

    public void checkSound(LivesInOcean animal) {
        animal.makeSound();
    }

    public static void main(String[] args) {

        Oceanographer oceanographer = new Oceanographer();
        oceanographer.checkSound(new Dolphin());
        oceanographer.checkSound(new Whale());
    }
}
