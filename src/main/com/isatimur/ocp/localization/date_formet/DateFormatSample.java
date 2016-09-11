package com.isatimur.ocp.localization.date_formet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Created by Isa Timur on 8/18/16.
 */
public class DateFormatSample {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getMonth());
        System.out.println(date.getYear());
        System.out.println(date.getDayOfYear());

        System.out.println("============================");

        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(date.format(DateTimeFormatter.ISO_DATE));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(time.format(DateTimeFormatter.ISO_TIME));

        System.out.println();

        DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(shortDateTime.format(date));
        System.out.println(shortDateTime.format(dateTime));
//        System.out.println(shortDateTime.format(time)); //UnsupportedTemporalException
        System.out.println();
        System.out.println(date.format(shortDateTime));
        System.out.println(dateTime.format(shortDateTime));
//        System.out.println(time.format(shortDateTime)); //UnsupportedTemporalException
        System.out.println();
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
//        System.out.println(date.format(f)); //UnsupportedTemporalTypeException
        System.out.println(dateTime.format(f));
//        System.out.println(time.format(f)); //UnsupportedTemporalException

        System.out.println();

        f = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(date.format(f)); //UnsupportedTemporalTypeException
        System.out.println(dateTime.format(f));
//        System.out.println(time.format(f)); //UnsupportedTemporalException

        System.out.println();

        f = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
//        System.out.println(date.format(f)); //UnsupportedTemporalTypeException
        System.out.println(dateTime.format(f));
        System.out.println(time.format(f)); //UnsupportedTemporalException

        System.out.println();
        System.out.println("======================================");
        System.out.println();

        DateTimeFormatter shortF = DateTimeFormatter
            .ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter mediumF = DateTimeFormatter
            .ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(shortF.format(dateTime));
        System.out.println(mediumF.format(dateTime));

        System.out.println("=======custom formatter=======");

        DateTimeFormatter customF = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
        System.out.println(dateTime.format(customF));

        System.out.println("=======custom formatter=======");

        customF = DateTimeFormatter.ofPattern("MMMM D YYYY   HH hh:mm");
        System.out.println(dateTime.format(customF));

        System.out.println();

        f = DateTimeFormatter.ofPattern("MM dd yyyy");
        LocalDate localDate = LocalDate.parse("01 02 2015", f);
        LocalTime localTime = LocalTime.parse("11:22");
        System.out.println(localDate);
        System.out.println(localTime);
    }
}
