package com.isatimur.ocp.concurrency;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Isa Timur on 8/29/16.
 */
public class ForkJoinPoolTestWeights {
    public static void main(String[] args) {
        Double[] weights = new Double[10000];
        ForkJoinTask task = new WeighAnimalAction(weights, 0, weights.length);
        ForkJoinPool pool = new ForkJoinPool();
//
        pool.invoke(task);
//
//        //Print results
        System.out.println();
        System.out.println("Weights: ");
        Arrays.asList(weights).stream().forEach(d -> System.out.print(d.intValue() + " "));


        System.out.println();
        System.out.println("==================================RecursiveJoinTask===============");
        System.out.println();
        RecursiveTask<Double> taskd = new WeighAnimalTask(weights, 0, weights.length);
        pool = new ForkJoinPool();

        Double sum = pool.invoke(taskd);
        System.out.println("Sum: " + sum);
        System.out.println();
    }
}
