package com.isatimur.ocp.datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Created by Isa Timur on 8/13/16.
 */
public class OCPDateTimeApi {
    public static void main(String[] args) throws InterruptedException {
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

        System.out.println("==================================== PERIODS ============================================");
        Period period = Period.ofMonths(1);
        performAnimalsEnrichmentPeriod(startP, endP, period);

        Period annually = Period.ofYears(1);
        Period quarterly = Period.ofMonths(3);
        Period everyThreeWeeks = Period.ofWeeks(3);
        Period everyOtherDay = Period.ofDays(2);
        Period everyYearAndWeek = Period.of(1, 0, 7);
        Period wrongEveryYearAndWeek = Period.ofYears(1).ofWeeks(1); //this is wrong it should be just everyWeek not every year and week
        System.out.println(annually + " " + quarterly + " " + everyThreeWeeks + " " + everyOtherDay + " " + everyYearAndWeek + " (wrong assumption)" + wrongEveryYearAndWeek);

        Period wrong = Period.ofYears(1);
        wrong = Period.ofWeeks(1);

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

        System.out.println("=================Instant==================");

        Instant now = Instant.now();
        Instant instant2 = Instant.now();
        System.out.println(now);
        Thread.sleep(2000);

        //Instant nextWeek = instant2.plus(1, ChronoUnit.WEEKS); // exception
//        switch ((ChronoUnit) unit) {
//        case NANOS: return plusNanos(amountToAdd);
//        case MICROS: return plus(amountToAdd / 1000_000, (amountToAdd % 1000_000) * 1000);
//        case MILLIS: return plusMillis(amountToAdd);
//        case SECONDS: return plusSeconds(amountToAdd);
//        case MINUTES: return plusSeconds(Math.multiplyExact(amountToAdd, SECONDS_PER_MINUTE));
//        case HOURS: return plusSeconds(Math.multiplyExact(amountToAdd, SECONDS_PER_HOUR));
//        case HALF_DAYS: return plusSeconds(Math.multiplyExact(amountToAdd, SECONDS_PER_DAY / 2));
//        case DAYS: return plusSeconds(Math.multiplyExact(amountToAdd, SECONDS_PER_DAY));

        String superString = "superString";

        Instant later = Instant.now();
        System.out.println(later);

        Duration duration = Duration.between(now, later);
        System.out.println(duration.toMillis());
        System.out.println(duration.toString());

        System.out.println();

        LocalDate localDate1 = LocalDate.of(2016, 5, 25);
        LocalTime localTime1 = LocalTime.of(11, 55, 00);
        ZoneId zoneId = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate1, localTime1, zoneId);
        Instant instant = zonedDateTime.toInstant();
        System.out.println(zonedDateTime);
        System.out.println(instant);
        System.out.println("===============================================");
        Instant instant1 = Instant.ofEpochSecond(1451606400);
        System.out.println(instant1);
        System.out.println("===============================================");
        Instant nextDay = instant1.plus(1, ChronoUnit.DAYS);
        System.out.println(nextDay);
        Instant nextHour = instant1.plus(1, ChronoUnit.HOURS);
        System.out.println(nextHour);
//        Instant nextWeek = instant1.plus(1,ChronoUnit.WEEKS); only smaller than day
        System.out.println("===============================================");
        System.out.println("================Let's save daylight===============");

        System.out.println("========March - 13 - 1:30 jump to 3:30");
        LocalDate localDate2 = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime localTime2 = LocalTime.of(1, 30);
        ZoneId zoneId1 = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime22 = ZonedDateTime.of(localDate2, localTime2, zoneId1);
        System.out.println(zonedDateTime22);

        zonedDateTime22 = zonedDateTime22.plusHours(1);
        System.out.println(zonedDateTime22);

        System.out.println();
//
//        LocalDate localDate3 = LocalDate.of(2016, Month.APRIL, 24);
//        LocalTime localTime3 = LocalTime.of(1, 00);
//        ZoneId zoneId2 = ZoneId.of("Asia/Magadan");
//        ZonedDateTime zonedDateTime21 = ZonedDateTime.of(localDate3, localTime3, zoneId2);
//        System.out.println(zonedDateTime21);
//
//        zonedDateTime21 = zonedDateTime21.plusHours(1);
//        System.out.println(zonedDateTime21);

        System.out.println("========November - 6 - 1:30 twice");
        LocalDate localDate3 = LocalDate.of(2016, Month.NOVEMBER, 6);
        LocalTime localTime3 = LocalTime.of(1, 30);
        ZoneId zoneId2 = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime21 = ZonedDateTime.of(localDate3, localTime3, zoneId2);
        System.out.println(zonedDateTime21);
        zonedDateTime21 = zonedDateTime21.plusHours(1);
        System.out.println(zonedDateTime21);
        zonedDateTime21 = zonedDateTime21.plusHours(1);
        System.out.println(zonedDateTime21);
        System.out.println();
        System.out.println("========March - 13 - 2:30 replaced with 3:30");
        LocalDate localDate4 = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime localTime4 = LocalTime.of(2, 30);
        ZoneId zoneId3 = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime20 = ZonedDateTime.of(localDate4, localTime4, zoneId3);
        System.out.println(zonedDateTime20);

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
