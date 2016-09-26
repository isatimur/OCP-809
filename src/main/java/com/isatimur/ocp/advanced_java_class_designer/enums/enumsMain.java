package com.isatimur.ocp.advanced_java_class_designer.enums;

/**
 * Created by abyakimenko on 22.09.2016.
 */
public class enumsMain {
    public static void main(String[] args) {

        Season s = Season.SUMMER;
        System.out.println(Season.SUMMER); // SUMMER
        System.out.println(s == Season.SUMMER); // true, because enums like final static constants

        System.out.println("========================================");
        System.out.println("========================================");
        for (Season season : Season.values()) {
            System.out.println(season.name() + " " + season.ordinal());
            season.printExpectedVisitors();
        }

        Season s1 = Season.valueOf("SUMMER"); // SUMMER
        //Season s2 = Season.valueOf("summer"); // exception

        OnlyOne firstCall = OnlyOne.ONCE; // prints constructing
        OnlyOne secondCall = OnlyOne.ONCE; // doesn't print anything
    }
}
