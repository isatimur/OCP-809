package main.com.isatimur.ocp.concurrency;

import java.util.concurrent.Executors;

/**
 * Created by Isa Timur on 8/30/16.
 */
public class CheckingDeadLock {
    public static void main(String[] args) {
        Fox foxy = new Fox();
        Fox tails = new Fox();

        Food food = new Food();
        Water water = new Water();

        //Process data
        try (ExecutorServiceCloseable service = new ExecutorServiceCloseable(Executors.newScheduledThreadPool(10))) {
            service.submit(() -> foxy.eastAndDrink(food, water));
            service.submit(() -> tails.drinkAndEat(food, water));
        }
        catch (InterruptedException e) {

        }
    }
}

class Food {
}

class Water {
}

class Fox {
    private static void out(String text) {
        System.out.println(Thread.currentThread().getName() + "  " + text);
    }

    public void eastAndDrink(Food food, Water water) {
        synchronized (food) {
            out("Got Food!");
            move();
            synchronized (water) {
                out("Got Water!");
            }
        }
    }

    private void move() {
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {

        }
    }

    public void drinkAndEat(Food food, Water water) {
        synchronized (food) {
            out("Got water!");
            move();
            synchronized (water) {
                out("Got Food!");
            }
        }
    }

}