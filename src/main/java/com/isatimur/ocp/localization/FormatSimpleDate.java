package com.isatimur.ocp.localization;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Isa Timur on 6/29/16.
 */
public class FormatSimpleDate {
    public static void main(String[] args) {

        Date date = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("G + YY ++ YYYY  +++ w ++++ W + D + d + MMMM + EEEE + a + H + h + m + s + S + z + Z", Locale.forLanguageTag("ru"));
        System.out.println(dateFormatter.format(date));

    }

}