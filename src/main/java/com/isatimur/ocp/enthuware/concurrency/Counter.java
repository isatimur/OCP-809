package com.isatimur.ocp.enthuware.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    static AtomicInteger ai = new AtomicInteger(0);

    public static void increment() { //1

//        StringReader
//        FileReader fileReader = new FileReader();
//        PrintWriter
//        BufferedReader
        ai.incrementAndGet();
    } //other valid code
}
