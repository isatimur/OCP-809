package main.main.com.isatimur.ocp.advanced_java_class_designer;

/**
 * Created by Isa Timur on 7/25/16.
 */

//simple implementation of Singleton pattern
public class HayStorage {
    private static final HayStorage instance = new HayStorage();
    private int quantity = 0;

    private HayStorage() {
    }

    public static HayStorage getInstance() {
        return instance;
    }

    public synchronized void addHay(int amount) {
        quantity += amount;
    }

    public synchronized boolean removeHay(int amount) {
        if (quantity < amount)
            return false;
        quantity -= amount;
        return true;
    }

    public synchronized int getQuantityOfHay() {
        return quantity;
    }
}
