package com.isatimur.ocp.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Isa Timur on 8/28/16.
 */
public class WhaleDataCalculator {

    public static void main(String[] args) {
        WhaleDataCalculator calculator = new WhaleDataCalculator();

        //define the data
        List<Integer> data = new ArrayList<>();
//        for (int i = 0; i < 4000; i++) {
//            data.add(i);
//        }

        //Process th data
        long start = System.currentTimeMillis();
//        calculator.processAllData(data);
        calculator.processAllDataInParallel(data);
        double time = (System.currentTimeMillis() - start) / 1000;

        //Report results
        System.out.println("\n Tasks completed in: " + time + " seconds");


        List<Integer> data1 = Collections.synchronizedList(new ArrayList<>());
        Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream()
                .map(i -> {
                    data1.add(i);
                    return i;
                })// AVOID STATEFUL LAMBDA EXPRESSIONS!
                .forEachOrdered(i -> System.out.print(i + " "));
        System.out.println();

        for (Integer e : data1) {
            System.out.print(e + " ");
        }
    }

    public int processRecord(int input) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {

        }
        return input + 1;
    }

    public void processAllData(List<Integer> data) {
        data.stream().map(a -> processRecord(a)).count();
    }

    public void processAllDataInParallel(List<Integer> data) {
        data.parallelStream().map(a -> processRecord(a)).count();
    }
}


