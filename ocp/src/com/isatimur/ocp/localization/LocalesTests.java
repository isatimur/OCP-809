package com.isatimur.ocp.localization;

import java.util.Locale;

/**
 * Created by developer on 6/24/16.
 */
public class LocalesTests {
    public static void main(String[] args) {
        Locale locale = Locale.KOREA;
        msg("lang: " + locale.getLanguage());
        msg("country: " + locale.getCountry());
        msg("variant: " + locale.getVariant());

        msg("Local.Builder Java 7");

        Locale.Builder builder = new Locale.Builder();
        builder.setLanguage("fr");
        builder.setRegion("CA");
        Locale locale1 = builder.build();

        msg("Code Country:" + locale1.getCountry());
        msg("Code Language:" + locale1.getLanguage());
        msg("Display Country:" + locale1.getDisplayCountry());
        msg("Display Language:" + locale1.getDisplayLanguage());
        msg("Display Name:" + locale1.getDisplayName());

        Locale[] all = Locale.getAvailableLocales();
        for (Locale loc : all) {
            msg("Code Country:" + loc.getCountry());
            msg("Code Language:" + loc.getLanguage());
            msg("Display Country:" + loc.getDisplayCountry());
            msg("Display Language:" + loc.getDisplayLanguage());
            msg("Display Name:" + loc.getDisplayName());
        }

    }

    static void msg(String str) {
        System.out.println(str);
    }
}
