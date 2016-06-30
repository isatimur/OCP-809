package com.isatimur.ocp.localization;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by developer on 6/29/16.
 */
public class FormatSimpleDate {
    public static void main(String[] args) {
        Date date = new Date();

        SimpleDateFormat dateFormatter = new SimpleDateFormat("G + YY ++ YYYY  +++ w ++++ W + D + d + E + a + H + h + m + s + S + z + Z", Locale.forLanguageTag("ru_RU"));
        System.out.println(dateFormatter.format(date));
    }

}
