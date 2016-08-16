package com.isatimur.ocp.localization;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * Created by developer on 8/16/16.
 */
public class ZooOpen {

    public static void main(String[] args) {
        Locale us = new Locale("en", "US");
        Locale france = new Locale("fr", "FR");
        printProperties(us);
        System.out.println();
        printProperties(france);

        System.out.println();

    }

    public static void printProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("com.isatimur.ocp.localization.Zoo", locale);
//        System.out.println(resourceBundle.getString("hello"));
//        System.out.println(resourceBundle.getString("open"));
//        System.out.println(resourceBundle.getString("testKey"));
//        System.out.println(resourceBundle.getString("testSyntax"));
//        System.out.println(resourceBundle.getString("key"));
//        System.out.println(resourceBundle.getString("long"));
        //it is easy just to use set
        Set<String> keys = rb.keySet();
        keys.stream().map(k -> k + " " + rb.getString(k)).forEach(System.out::println);
        System.out.println();

        Properties props = new Properties();
        rb.keySet().stream().forEach(k -> props.put(k, rb.getString(k)));
        System.out.println();

        System.out.println(props.getProperty("notReallyAProperty"));
        System.out.println(props.getProperty("notReallyAProperty", "123"));

    }
}

