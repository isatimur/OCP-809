package com.isatimur.ocp.localization;

import java.util.Locale;

/**
 * Created by Isa Timur on 8/16/16.
 */
public class PickingALocale {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println(locale);

        System.out.println(Locale.GERMAN);
        System.out.println(Locale.GERMANY);

        System.out.println(new Locale("fr"));
        System.out.println(new Locale("hi", "IN"));

        System.out.println();

        Locale l1 = new Locale.Builder().setLanguage("en").setRegion("US").build();
        Locale l2 = new Locale.Builder().setRegion("US").setLanguage("en").build();

        System.out.println(l1);
        System.out.println();
        System.out.println(l2);

        System.out.println();
        Locale badSampleButNotWrongForCompile = new Locale.Builder().setRegion("ru").setLanguage("RU").build();
        System.out.println(badSampleButNotWrongForCompile);

        System.out.println();
        System.out.println(Locale.getDefault());
        Locale loc = new Locale("fr");
        Locale.setDefault(loc);
        System.out.println(Locale.getDefault());

        System.out.println("================Zooo expansion================");
        Locale us = new Locale("en", "US");
        Locale france = new Locale("fr", "FR");
        Locale englishCanada = new Locale("en", "CA");
        Locale frenchCanada = new Locale("fr", "CA");

    }
}
