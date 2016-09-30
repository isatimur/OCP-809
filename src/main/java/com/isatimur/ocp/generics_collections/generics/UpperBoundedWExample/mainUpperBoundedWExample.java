package com.isatimur.ocp.generics_collections.generics.UpperBoundedWExample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abyakimenko on 30.09.2016.
 */
public class mainUpperBoundedWExample {

    private static void anyFlyer(List<Flyer> flyer) {
        flyer.forEach(x -> System.out.println(x));
    }

    private static void groupOfFlyers(List<? extends Flyer> flyer) {
        flyer.forEach(x -> System.out.println(x));
    }

    public static void main(String[] args) {

        List<Flyer> flyer = new ArrayList<>();
        flyer.add(new Goose());
        flyer.add(new HangGlider());
        anyFlyer(flyer);
        groupOfFlyers(flyer);

        List<Goose> geese = new ArrayList<>();
        geese.add(new Goose());
        geese.add(new Goose());
        geese.add(new Goose());
        geese.add(new Goose());
//        anyFlyer(geese);
        groupOfFlyers(geese);

        List<HangGlider> gliders = new ArrayList<>();
        gliders.add(new HangGlider());
        gliders.add(new HangGlider());
        gliders.add(new HangGlider());
        gliders.add(new HangGlider());
        gliders.add(new HangGlider());

        // anyFlyer(gliders);
        groupOfFlyers(gliders);
    }
}
