package com.isatimur.ocp.concurrency;

import java.util.concurrent.Callable;

/**
 * Created by Isa Timur on 6/11/16.
 */
public class Order implements Callable<Void> {
    private String name;

    public Order(String name) {
        this.name = name;
    }

    @Override
    public Void call() throws Exception {
        System.out.println(name);
        if (name.equalsIgnoreCase("berry")) {
            throw new Exception("Berry unavailable!");

        }
        return null;
    }
}

