package com.isatimur.ocp.datetime;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.MINUTES;

/**
 * Created by developer on 7/14/16.
 */
public class DateTimeAPI {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate todayAgain = LocalDate.now();
        System.out.println(todayAgain);

        System.out.println(today.compareTo(todayAgain) == 0);

        LocalTime now = LocalTime.now();
        System.out.println(now);

        ZoneId id = ZoneId.of("Asia/Tokyo");
        System.out.println(id);

        LocalDateTime todayAndNow = LocalDateTime.now();
        System.out.println(todayAndNow);

        ZonedDateTime todayAndNowInTokyo = ZonedDateTime.now(id);
        System.out.println(todayAndNowInTokyo);

        LocalDate newYear2016 = LocalDate.of(2016, 1, 1);
        System.out.println(newYear2016);

        //DateTimeException - Invalid value for MonthOfYear (valid values 1 - 12): 14
//        LocalDate valentinesDay = LocalDate.of(2016, 14, 02);
//        System.out.println("Valentine's day is on: " + valentinesDay);

        long visaValidityDays = 180L;
        LocalDate currDate = LocalDate.now();
        System.out.println("My Visa expires on: " + currDate.plusDays(visaValidityDays));

        System.out.println("=====================LocalDate=============================");

        System.out.println(LocalDate.now(Clock.systemDefaultZone()));

        System.out.println(LocalDate.now(ZoneId.of("Asia/Kolkata")));

        System.out.println(LocalDate.now(ZoneId.of("Asia/Tokyo")));

        System.out.println(LocalDate.ofYearDay(2016, 100));

        System.out.println(LocalDate.parse("2015-10-16"));

        System.out.println(LocalDate.ofEpochDay(10));

        System.out.println("=====================LocalTime=============================");

        LocalTime currTime = LocalTime.now();
        System.out.println("Current time is: " + currTime);

        System.out.println(LocalTime.of(18, 30));

        long hours = 6;
        long minutes = 30;

        System.out.println("My meeting is at: " + currTime.plusHours(hours).plusMinutes(minutes));

        System.out.println(LocalTime.now(Clock.systemDefaultZone()));

        System.out.println(LocalTime.now(ZoneId.of("Asia/Tokyo")));

        System.out.println(LocalTime.ofSecondOfDay(66620));

        System.out.println(LocalTime.parse("18:30:05"));

        System.out.println("=====================LocalDateTime=========================");

        LocalDateTime cristmas = LocalDateTime.of(2015, 12, 25, 0, 0);
        LocalDateTime newYear = LocalDateTime.of(2016, 1, 1, 0, 0);
        System.out.println("New Year 2016 comes after Christmas 2015 " + newYear.isAfter(cristmas));

        LocalDateTime currDateTime = LocalDateTime.now();
        System.out.println("Today's date and current time is: " + currDateTime);
        System.out.println("The date component is: " + currDateTime.toLocalDate());
        System.out.println("The time component is: " + currDateTime.toLocalTime());

        System.out.println("========================Instant============================");

        Instant currTimeStamp = Instant.now();
        System.out.println("Instant timestamp is: " + currTimeStamp);
        System.out.println("Number of seconds elapsed: " + currTimeStamp.getEpochSecond());
        System.out.println("Number of miliseconds elapsed: " + currTimeStamp.toEpochMilli());

        System.out.println("========================Period============================");

        LocalDate manufacturingDate = LocalDate.of(2016, Month.JANUARY, 1);
        LocalDate expiryDate = LocalDate.of(2018, Month.JULY, 15);
        Period expiry = Period.between(manufacturingDate, expiryDate);
        System.out.printf("Medicine will expire in: %d year, %d months and %d days (%s) \n", expiry.getYears(), expiry.getMonths(), expiry.getDays(), expiry);

        System.out.println(Period.ofWeeks(2));
        System.out.println(Period.ofDays(15));
        System.out.println(Period.ofMonths(6));
        System.out.println(Period.ofYears(4));
        System.out.println(Period.parse("P4Y6M15D"));

        System.out.println("========================Duration============================");

        LocalDateTime comingMidnight = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.MIDNIGHT);
        LocalDateTime nowTime = LocalDateTime.now();

        Duration between = Duration.between(nowTime, comingMidnight);
        System.out.println(between);

        System.out.println(Duration.of(3600, MINUTES));
        System.out.println(Duration.ofDays(4));
        System.out.println(Duration.ofHours(2));
        System.out.println(Duration.ofMinutes(15));
        System.out.println(Duration.ofSeconds(15));
        System.out.println(Duration.ofMillis(4));
        System.out.println(Duration.ofHours(4));
        System.out.println(Duration.parse("P2DT10H30m"));

        System.out.println("========================TemporalUnit============================");

        System.out.printf("%20s \t %s \t\t %s \t\t %s %n", "ChronoUnit", "DateBased", "TimeBased", "Duration");

        System.out.println("---------------");

        for (ChronoUnit unit : ChronoUnit.values()) {
            System.out.printf("%20s \t %b  \t\t %b  \t\t %s %n", unit, unit.isDateBased(), unit.isTimeBased(), unit.getDuration());
        }

        System.out.println("========================ZoneId============================");

        System.out.println("My Zone id is: " + ZoneId.systemDefault());

        LocalDate currentDate = LocalDate.now();
        LocalTime currentTimeNow = LocalTime.now();
        ZoneId myZone = ZoneId.systemDefault();

        ZonedDateTime zonedDateTime = ZonedDateTime.of(currDate, currentTimeNow, myZone);
        System.out.println(zonedDateTime);

        ZoneOffset zoneOffset = zonedDateTime.getOffset();
        System.out.println(zoneOffset);

        ZoneId singapooreZone = ZoneId.of("Asia/Singapore");
        ZonedDateTime dateTimeInSingapore = ZonedDateTime.of(LocalDateTime.of(2016, Month.JANUARY, 1, 6, 0), singapooreZone);

        ZoneId aucklandZone = ZoneId.of("Pacific/Auckland");
        ZonedDateTime sameDateTimeInSingapore = dateTimeInSingapore.withZoneSameInstant(aucklandZone);

        Duration timeDifference = Duration.between(dateTimeInSingapore.toLocalTime(), sameDateTimeInSingapore.toLocalTime());

        System.out.printf(
            "Time difference between %s and %s zones is %d hours %n", singapooreZone, aucklandZone, timeDifference.toHours());

        System.out.println("======================DateTimeFormatter=====================");

        LocalTime wakeupTime = LocalTime.of(6, 20, 59);
        System.out.println("Wake up time: " + DateTimeFormatter.ISO_TIME.format(wakeupTime));

        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        System.out.println(customFormatter.format(LocalDate.of(2016, Month.JANUARY, 01)));

        String[] dateTimeFormatters = {
            "dd-MM-yyyy",/*d is day in month, M is month, y is year */
            "d '('E')' MMM, YYYY", /*E is name of the day(in week), Y is year*/
            "w'th week of' YYYY",/*w is the week of year*/
            "EEEE, dd'th' MMMM,YYYY" /*E is day name in the week*/
        };

        LocalDateTime noww = LocalDateTime.now();
        for (String dateTimeFormat : dateTimeFormatters) {
            System.out.printf("Pattern \"%s\" is %s %n", dateTimeFormat, DateTimeFormatter.ofPattern(dateTimeFormat).format(noww));
        }
        System.out.println("-------------------------------------------------------------");

        String[] timeFormatters = {
            "h:mm",
            "hh 'o''clock'",
            "H:mm a",
            "hh:mm:ss:SS",
            "K:mm:ss a"
        };

        LocalTime timeNoww = LocalTime.now();
        for (String timeFormats : timeFormatters) {
            System.out.printf("Pattern \"%s\" is %s %n", timeFormats, DateTimeFormatter.ofPattern(timeFormats).format(timeNoww));
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy hh.mm a");

        ZonedDateTime depature = ZonedDateTime.of(LocalDateTime.of(2016, Month.JANUARY, 1, 6, 0), ZoneId.of("Asia/Singapore"));
        System.out.println("Departure: " + dateTimeFormatter.format(depature));

        ZonedDateTime arrival = depature.withZoneSameInstant(ZoneId.of("Pacific/Auckland")).plusHours(10);
        System.out.println("Arrival: " + dateTimeFormatter.format(arrival));

    }
}
