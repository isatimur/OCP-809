package com.isatimur.ocp.localization;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by developer on 6/29/16.
 */
public class FormatCurrency {
    public static void main(String[] args) {
        double amt = 12345.1111;
        defaultLocale(amt);
        specificLocale(Locale.UK, amt);
        specificLocale(Locale.GERMANY, amt);
        specificLocale(Locale.FRANCE, amt);
        specificLocale(Locale.US, amt);
        specificLocale(Locale.JAPAN, amt);
    }

    public static void defaultLocale(double amt) {
        NumberFormat nfDefault = NumberFormat.getCurrencyInstance();
        msg("\n Default locale currency: " + nfDefault.getCurrency());
        msg("formatted amt: " + nfDefault.format(amt));

    }

    public static void specificLocale(Locale locale, double amt) {
        NumberFormat nfSpec = NumberFormat.getCurrencyInstance(locale);
        msg("\n Specified locale:  " + locale.getDisplayCountry() + " Currency:" + nfSpec.getCurrency());
        msg("formatted amt: " + nfSpec.format(amt));

    }

    private static void msg(String text) {
        System.out.println(text);
    }

}
