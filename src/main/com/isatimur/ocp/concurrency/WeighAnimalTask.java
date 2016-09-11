package com.isatimur.ocp.concurrency;

import java.util.Random;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Isa Timur on 8/29/16.
 */
public class WeighAnimalTask extends RecursiveTask<Double> {
    private int start;
    private int end;
    private Double[] weights;

    public WeighAnimalTask(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    @Override protected Double compute() {
        if (end - start <= 3) {
            double sum = 0;
            System.out.println(Thread.currentThread().getName());
            for (int i = start; i < end; i++) {
                weights[i] = (double)new Random().nextInt(100);
                System.out.println("Animal Weighed: " + i);
                sum += weights[i];
            }
            return sum;
        }
        else {
            int middle = start + ((end - start) / 2);
            System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");
            RecursiveTask<Double> otherTask = new WeighAnimalTask(weights, start, middle);
            System.out.println(Thread.currentThread().getName());
            otherTask.fork();
            return new WeighAnimalTask(weights, middle, end).compute() + otherTask.join();
        }

    }
}
