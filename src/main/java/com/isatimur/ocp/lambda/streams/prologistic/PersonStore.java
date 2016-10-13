package com.isatimur.ocp.lambda.streams.prologistic;

import java.util.Arrays;
import java.util.List;

/**
 * Created by abyakimenko on 13.10.2016.
 */
public class PersonStore {


    public static List<Person> persons = Arrays.asList(new Person("Andrew", 20),
                                                new Person("Igor", 23),
                                                new Person("Ira", 23),
                                                new Person("Vitia", 12));
}
