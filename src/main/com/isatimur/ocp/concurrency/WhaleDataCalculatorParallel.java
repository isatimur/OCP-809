package main.com.isatimur.ocp.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isa Timur on 8/28/16.
 */
public class WhaleDataCalculatorParallel {

    public static void main(String[] args) {
        WhaleDataCalculatorParallel calculator = new WhaleDataCalculatorParallel();

        //define the data
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 4000; i++) {
            data.add(i);
        }

        //Process th data
        long start = System.currentTimeMillis();
        calculator.processAllData(data);
        double time = (System.currentTimeMillis() - start) / 1000;

        //Report results
        System.out.println("\n Tasks completed in: " + time + " seconds");
    }

    public int processRecord(int input) {
        try {
            Thread.sleep(10);
        }
        catch (InterruptedException ex) {

        }
        return input + 1;
    }

    public void processAllData(List<Integer> data) {
        data.parallelStream().map(a -> processRecord(a)).count();
    }
}


