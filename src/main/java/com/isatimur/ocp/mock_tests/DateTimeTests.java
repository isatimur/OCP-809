package com.isatimur.ocp.mock_tests;

import java.time.Period;
import java.time.ZonedDateTime;

/**
 * Created by developer on 9/18/16.
 */
public class DateTimeTests {
    public static void main(String[] args) {
        int thisYear = ZonedDateTime.now().getYear();
        int thisMonth = ZonedDateTime.now().getMonth().getValue();

        ZonedDateTime zonedDateTime = ZonedDateTime.now().plusDays(7);
        System.out.println(zonedDateTime);

        zonedDateTime = ZonedDateTime.now().plus(Period.ofDays(7));
        System.out.println(zonedDateTime);
    }
}
