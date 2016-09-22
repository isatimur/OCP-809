package main.com.isatimur.ocp.concurrency;

import java.util.Random;
import java.util.concurrent.RecursiveAction;

/**
 * Created by Isa Timur on 8/29/16.
 */
public class WeighAnimalAction extends RecursiveAction {
    private int start;
    private int end;
    private Double[] weights;

    public WeighAnimalAction(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    @Override protected void compute() {
        if (end - start <= 3) {
            for (int i = start; i < end; i++) {
                weights[i] = (double)new Random().nextInt(100);
                System.out.println("Animal Weighed: " + i);
            }
        }
        else {
            int middle = start + ((end - start) / 2);
            System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");
            invokeAll(new WeighAnimalAction(weights, start, middle), new WeighAnimalAction(weights, middle, end));
        }
    }

}
