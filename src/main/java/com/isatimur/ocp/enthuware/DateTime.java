package com.isatimur.ocp.enthuware;

import java.time.*;

/**
 * Created by abyakimenko on 06.12.2016.
 */
public class DateTime {

    public static void main(String[] args) {

        // Assume that the local time on the system at the time this code is run is 2nd Sep 2015 1:00 AM.

        // public static Period between(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        Period p = Period.between(LocalDate.of(2015, Month.SEPTEMBER, 2), LocalDate.of(2015, Month.SEPTEMBER, 1));
        System.out.println(p);
        // P-1D - период -1 день 1 - 2 = -1


        Duration d = Duration.between(LocalDateTime.of(2015, Month.SEPTEMBER, 2, 1, 5, 40),
                LocalDateTime.of(2015, Month.SEPTEMBER, 4, 10, 10));
        // PT9H10M
        // разница 9 часов 10 минут

        System.out.println(d);
    }
}
