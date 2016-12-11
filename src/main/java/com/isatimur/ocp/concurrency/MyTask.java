package com.isatimur.ocp.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class MyTask implements Callable{
    Future result;

    @Override
    public Object call() throws Exception {
        return null;
    }
//    public void call(){
//        result = new Future<String>("Data from callable");
//    }
}