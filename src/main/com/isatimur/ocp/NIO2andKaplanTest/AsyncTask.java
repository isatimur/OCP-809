package com.isatimur.ocp.NIO2andKaplanTest;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Isachenko Timur on 15.09.2016.
 */
public class AsyncTask extends RecursiveTask<Data> {
    private final Data someData;

    public AsyncTask(Data someData) {
        this.someData = someData;
    }

    @Override
    protected Data compute() {
        if (someData.getSize() < 10) {
            return someData.calc();
        }
        AsyncTask t1 = new AsyncTask(someData.reduceIn(2).getSegment(1));
        t1.fork();
        AsyncTask t2 = new AsyncTask(someData.reduceIn(2).getSegment(2));
        return Data.combine(t2.compute(), t1.join());

    }
}

class Data {
    private int amount;
    private int size;

    public Data(int amount) {
        this.amount = amount;
    }

    public int getSize() {
        return size;
    }

    public static Data combine(Data data1, Data data2) {
        return new Data(data1.amount + data2.amount);
    }

    public Data calc() {
        return new Data(amount * 10);
    }

    public Data reduceIn(int i) {
        return null;
    }


    public Data getSegment(int i) {
        return null;
    }
}