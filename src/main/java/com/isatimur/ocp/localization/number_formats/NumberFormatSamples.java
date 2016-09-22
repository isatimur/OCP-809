package com.isatimur.ocp.localization.number_formats;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Isa Timur on 8/16/16.
 */
public class NumberFormatSamples {
    public static void main(String[] args) throws ParseException {
        int attendeesPerYear = 3_200_000;
        int attendeesPerMonth = attendeesPerYear / 12;
        NumberFormat us = NumberFormat.getInstance(Locale.US);
        System.out.println(us.format(attendeesPerMonth));
        NumberFormat ge = NumberFormat.getInstance(Locale.GERMAN);
        System.out.println(ge.format(attendeesPerMonth));
        NumberFormat fr = NumberFormat.getInstance(Locale.CANADA_FRENCH);
        System.out.println(fr.format(attendeesPerMonth));

        System.out.println();

        NumberFormat usCur = NumberFormat.getCurrencyInstance();
        System.out.println(usCur.format(48.00));

        System.out.println();
        NumberFormat en = NumberFormat.getInstance(Locale.US);
        NumberFormat frnew = NumberFormat.getInstance(Locale.FRANCE);

        String s = "40.45";
        System.out.println(en.parse(s)); // 40.45
        System.out.println(frnew.parse(s)); // 40

        System.out.println();
        NumberFormat nf = NumberFormat.getInstance();
        String one = "456abc";
        String two = "-2.5165x10";
        String three = "x85.3";
        System.out.println(nf.parse(one)); // 456
        System.out.println(nf.parse(two)); // -2.5165
//        System.out.println(nf.parse(three));// throws ParseException

        System.out.println();
        String amt = "$92,807.99";
        NumberFormat cf = NumberFormat.getCurrencyInstance();
        double value = (Double)cf.parse(amt);
        System.out.println(value); // 92807.99
    }
}
