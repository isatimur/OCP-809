package main.com.isatimur.ocp.localization;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Isa Timur on 6/29/16.
 */
public class FormatNumbers {
    public static void main(String[] args) {
        double num = 12345.1111;
        defaultLocale(num);
        specificLocale(Locale.GERMANY, num);
        specificLocale(Locale.FRANCE, num);
        specificLocale(Locale.US, num);
    }

    static void defaultLocale(double num) {
        NumberFormat numberFormat = NumberFormat.getInstance();

        msg("\nDefault Locale");
        msg("formatting:  " + numberFormat.format(num));

        try {
            msg("parsing: " + numberFormat.parse("12345.111"));
        }
        catch (java.text.ParseException e) {
            msg(e.toString());
        }

    }

    static void specificLocale(Locale locale, double num) {
        NumberFormat nfSpecific = NumberFormat.getInstance(locale);
        msg("\n" + locale.getDisplayCountry());
        msg("formatting: " + nfSpecific.format(num));
        try {
            msg("parsing:" + nfSpecific.parse("12345.1111"));
        }
        catch (java.text.ParseException e) {
            msg(e.toString());
        }
    }

    static void msg(String msg) {
        System.out.println(msg);
    }
}
