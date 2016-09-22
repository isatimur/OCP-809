package main.com.isatimur.ocp.concurrency;

import java.util.Arrays;

/**
 * Created by Isa Timur on 8/23/16.
 */
public class CalculateAverages implements Runnable {
    private double[] scores;

    public CalculateAverages(double[] scores) {
        this.scores = scores;
    }

    public static void main(String[] args) {
        CalculateAverages averages = new CalculateAverages(new double[] {1.0, 2.3, 7.4});
        new Thread(averages).start();
    }

    @Override public void run() {
        Arrays.stream(scores).forEach(System.out::print);
    }
}
