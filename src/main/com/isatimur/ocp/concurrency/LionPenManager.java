package main.com.isatimur.ocp.concurrency;

import java.util.concurrent.Executors;

/**
 * Created by Isa Timur on 8/29/16.
 */
public class LionPenManager {
    public static void main(String[] args) throws InterruptedException {
        try (ExecutorServiceCloseable service = new ExecutorServiceCloseable(Executors.newFixedThreadPool(4))) {
            LionPenManager manager = new LionPenManager();
            for (int i = 0; i < 4; i++) {
                service.submit(() -> manager.performTask());
            }
        }
    }

    private void removeAnimals() {
        System.out.println("Removing animals");
    }

    private void cleanPen() {
        System.out.println("Cleaning the pen");
    }

    private void addAnimals() {
        System.out.println("Addign animals");
    }

    public void performTask() {
        removeAnimals();
        cleanPen();
        addAnimals();
    }
}
