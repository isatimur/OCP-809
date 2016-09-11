package com.isatimur.ocp.localization;

import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * Created by Isa Timur on 6/29/16.
 */
public class FormatCurrencyVer2 {
    static JTextArea textArea = new JTextArea();

    public static void main(String[] args) {
        JFrame f = new JFrame("Currency");
        f.getContentPane().add(textArea);
        f.setSize(300, 400);
        double amt = 12345.1111;
        defaultLocale(amt);
        specificLocale(Locale.UK, amt);
        specificLocale(Locale.GERMANY, amt);
        specificLocale(Locale.FRANCE, amt);
        specificLocale(Locale.US, amt);
        specificLocale(Locale.JAPAN, amt);
        f.setVisible(true);
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

    static void msg(String str) {
        textArea.append("\n" + str);
    }
}
