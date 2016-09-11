package com.isatimur.ocp.lambda.functional_interfaces;

interface Gorrila {
    String move();
}

/**
 * Created by Isa Timur on 8/9/16.
 */
public class GorillaFamily {
    String walk = "walk";

    public static void main(String[] args) {
        new GorillaFamily().everyonePlay(true);
    }

    void everyonePlay(boolean baby) {

        String approach = "amble";
//        approach = "reassemble";

        play(() -> walk);
        play(() -> baby ? "hitch a ride" : "run");
        play(() -> approach);
    }

    void play(Gorrila g) {
        System.out.println(g.move());
    }

}
