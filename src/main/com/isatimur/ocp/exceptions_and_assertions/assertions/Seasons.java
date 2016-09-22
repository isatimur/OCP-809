package main.com.isatimur.ocp.exceptions_and_assertions.assertions;

import static main.com.isatimur.ocp.exceptions_and_assertions.assertions.TestSeasons.test;

/**
 * Created by Isa Timur on 8/22/16.
 */
public enum Seasons {
    WINTER, SPRING, SUMMER, FALL;

    public static void main(String[] args) {

        test(WINTER);
    }
}

class TestSeasons {
    public static void test(Seasons s) {
        switch (s) {
            case SPRING:
            case FALL:
                System.out.println("Shorter hours");
                break;
            case SUMMER:
                System.out.println("Longer hours");
                break;
            default:
                assert false : "Invalid season";

        }
    }

}
