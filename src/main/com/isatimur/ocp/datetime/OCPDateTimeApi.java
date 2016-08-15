package com.isatimur.ocp.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by developer on 8/13/16.
 */
public class OCPDateTimeApi {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
        LocalDate date2 = LocalDate.of(2015, 0_1, 20);
        System.out.println(date1 + " : " + date2);

        LocalTime time1 = LocalTime.of(6, 15);
        LocalTime time2 = LocalTime.of(6, 15, 20);
        LocalTime time3 = LocalTime.of(6, 15, 20, 92393);

        System.out.println(time1 + " : " + time2 + " : " + time3);

        LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 20);
        LocalDateTime dateTime2 = LocalDateTime.of(date1, time2);

        System.out.println(dateTime1 + " : " + dateTime2);
        System.out.println("equals? " + (dateTime1.equals(dateTime2)));

        System.out.println("Zone");
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(2015, Month.JANUARY.getValue(), 20, 6, 15, 20, 0, zone);
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(date1, time2, zone);
        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(dateTime1, zone);

        System.out.println(zonedDateTime1 + " : " + zonedDateTime2 + " : " + zonedDateTime3);

        System.out.println();

        LocalDate start = LocalDate.of(2016, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2016, Month.MARCH, 30);

        performAnimalsEnrichment(start, end);

        System.out.println();

        LocalDate startP = LocalDate.of(2016, Month.JANUARY, 1);
        LocalDate endP = LocalDate.of(2016, Month.MARCH, 30);

        Period period = Period.ofMonths(1);
        performAnimalsEnrichmentPeriod(startP, endP, period);

        Period annually = Period.ofYears(1);
        Period quarterly = Period.ofMonths(3);
        Period everyThreeWeeks = Period.ofWeeks(3);
        Period everyOtherDay = Period.ofDays(2);
        Period everyYearAndWeek = Period.of(1, 0, 7);
        Period wrongEveryYearAndWeek = Period.ofYears(1).ofWeeks(1); //this is wrong it should be just everyWeek not every year and week
        System.out.println(annually + " " + quarterly + " " + everyThreeWeeks + " " + everyOtherDay + " " + everyYearAndWeek + " (wrong assumption)" + wrongEveryYearAndWeek);

        System.out.println();
        LocalDate localDate = LocalDate.of(2016, 1, 20);
        LocalTime localTime = LocalTime.of(6, 15);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        Period periodNew = Period.ofMonths(1);
        System.out.println(localDate.plus(periodNew));
        System.out.println(localDateTime.plus(periodNew));
//        System.out.println(localTime.plus(periodNew)); Unsupported time unit

        System.out.println("Duration");

        Duration daily = Duration.ofDays(1);
        Duration hourly = Duration.ofHours(1);
        Duration everyMinute = Duration.ofMinutes(10);
        Duration everyTenSeconds = Duration.ofSeconds(10);
        Duration everyMilli = Duration.ofMillis(1);
        Duration everyNano = Duration.ofNanos(1);
        Duration anHour = Duration.ofSeconds(3600);

        System.out.println(daily);
        System.out.println(hourly);
        System.out.println(everyMinute);
        System.out.println(everyTenSeconds);
        System.out.println(everyMilli);
        System.out.println(everyNano);
        System.out.println(anHour);

        System.out.println("==============Use chrono unit=================");
        letsJustUseChronoUnit();

        System.out.println("==============================================");

        LocalTime one = LocalTime.of(5, 15);
        LocalTime two = LocalTime.of(6, 30);
        LocalDate date = LocalDate.of(2016, 1, 20);
        System.out.println(ChronoUnit.HOURS.between(one, two)); //TRUNCATE MINUTES
        System.out.println(ChronoUnit.MINUTES.between(one, two)); //75 IN MINUTES WORKING NICE
        //System.out.println(ChronoUnit.MINUTES.between(one,date));//DateTimeException

        System.out.println("===============================================");

    }

    private static void letsJustUseChronoUnit() {
        Duration daily = Duration.of(1, ChronoUnit.DAYS);
        Duration hourly = Duration.of(1, ChronoUnit.HOURS);
        Duration everyMinute = Duration.of(10, ChronoUnit.MINUTES);
        Duration everyTenSeconds = Duration.of(10, ChronoUnit.SECONDS);
        Duration everyMilli = Duration.of(1, ChronoUnit.MILLIS);
        Duration everyNano = Duration.of(1, ChronoUnit.NANOS);
        Duration halfOfDay = Duration.of(1, ChronoUnit.HALF_DAYS);

        System.out.println(daily);
        System.out.println(hourly);
        System.out.println(everyMinute);
        System.out.println(everyTenSeconds);
        System.out.println(everyMilli);
        System.out.println(everyNano);
        System.out.println(halfOfDay);

    }

    public static void performAnimalsEnrichment(LocalDate start, LocalDate end) {
        LocalDate upTo = start;
        while (upTo.isBefore(end)) {
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plusMonths(1);
        }
    }

    public static void performAnimalsEnrichmentPeriod(LocalDate start, LocalDate end, Period period) {
        LocalDate upTo = start;
        while (upTo.isBefore(end)) {
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plus(period);
        }
    }
}
