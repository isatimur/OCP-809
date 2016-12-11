package com.isatimur.ocp.localization;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by abyakimenko on 22.11.2016.
 */
public class TestRes {

    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, zoneId);
        long epochSeconds = 0;
        Instant instant = zonedDateTime.toInstant();

        ZoneId zone = ZoneId.of("US/Eastern");
        LocalDate date22 =  LocalDate.of(2016, 5, 10);
        LocalTime time1 = LocalTime.of(2, 15);
        ZonedDateTime a = ZonedDateTime.of(date22, time1, zone);

        String durationChronoUnitMinutes = Duration.of(1, ChronoUnit.MINUTES).toString();
        String durationOfMinutes = Duration.ofMinutes(1).toString();
        String durationOfSeconds = Duration.of(60, ChronoUnit.SECONDS).toString();

        String durationOfDays = Duration.ofDays(1).toString();
        String periodOfDays = Period.ofDays(1).toString();

        System.out.println(durationChronoUnitMinutes);// PT1M
        System.out.println(durationOfMinutes);// PT1M
        System.out.println(durationOfSeconds); // PT1M
        System.out.println(durationOfDays);// PT24H
        System.out.println(periodOfDays);// P1D

        /**********************/

        Locale.setDefault(new Locale("fr", "CA"));
        //Set default to French Canada
        Locale l = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("appmessages", l);
        String msg = rb.getString("greetings"); System.out.println(msg);

        /**********************/



        Locale fr = new Locale("fr","FR");
        Locale.setDefault(new Locale("en"));

        System.out.println("CURRENT LOCALE:" + Locale.getDefault());

        ResourceBundle bundle = ResourceBundle.getBundle("Dolphins", fr);
//        ResourceBundle bundle = ResourceBundle.getBundle("Dolphins");
//       родитель fr - базовый бандл Dolphins!!!! Если

        System.out.println(bundle.getString("name"));
        System.out.println(bundle.getString("age"));
        System.out.println(bundle.getString("sample"));
    }
}
