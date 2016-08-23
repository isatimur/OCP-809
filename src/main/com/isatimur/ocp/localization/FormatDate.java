package com.isatimur.ocp.localization;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import static java.text.DateFormat.FULL;
import static java.text.DateFormat.LONG;
import static java.text.DateFormat.MEDIUM;
import static java.text.DateFormat.SHORT;

/**
 * Created by developer on 6/29/16.
 */
public class FormatDate {
    static int[] styles = new int[] {SHORT, MEDIUM, LONG, FULL};
    static String desc[] = new String[] {"FULL", "LONG", "MEDIUM", "SHORT"};
    static String df[] = new String[] {"DATE", "TIME", "DATETIME"};

    public static void main(String[] args) {

        for (String dformat : df) {
            msg("==================");
            msg("DateFormat type is " + dformat);

            msg("==================");
            Date date = new Date();
            defaultLocale(date, dformat);
            specificLocale(Locale.GERMANY, date, dformat);
            specificLocale(Locale.FRANCE, date, dformat);
            specificLocale(Locale.CHINA, date, dformat);
            specificLocale(Locale.forLanguageTag("ru"), date, dformat);

        }

    }

    static void defaultLocale(Date date, String dformat) {
        msg("\nDefault locale");
        for (int style : styles) {
            DateFormat dfDefault = factoryDateFormat(dformat, style);
            msg(desc[style] + "\t:" + dfDefault.format(date));
        }
    }

    static DateFormat factoryDateFormat(String dformat, int style) {
        DateFormat dfDefault = null;
        if (dformat.equalsIgnoreCase(df[0])) {
            dfDefault = DateFormat.getDateInstance(style);
        }
        else if (dformat.equalsIgnoreCase(df[1])) {
            dfDefault = DateFormat.getTimeInstance(style);
        }
        else if (dformat.equalsIgnoreCase(df[2])) {
            dfDefault = DateFormat.getDateTimeInstance(style, style);
        }
        return dfDefault;
    }

    static DateFormat factoryDateFormat(String dformat, Locale locale, int style) {
        DateFormat dfDefault = null;
        if (dformat.equalsIgnoreCase(df[0])) {
            dfDefault = DateFormat.getDateInstance(style, locale);
        }
        else if (dformat.equalsIgnoreCase(df[1])) {
            dfDefault = DateFormat.getTimeInstance(style, locale);
        }
        else if (dformat.equalsIgnoreCase(df[2])) {
            dfDefault = DateFormat.getDateTimeInstance(style, style, locale);
        }
        return dfDefault;
    }

    static void specificLocale(Locale locale, Date date, String dformat) {
        msg("\n" + locale.getDisplayCountry());
        for (int style : styles) {
            DateFormat dfSpec = factoryDateFormat(dformat, locale, style);
            msg(desc[style] + "\t:" + dfSpec.format(date));
        }
    }

    static void msg(String text) {
        System.out.println(text);
    }

}
