package com.isatimur.ocp.design_patterns_principals.singleton;

public class HayStorage {

    private int quantity = 0;

    private HayStorage() {}

    private static final HayStorage instance = new HayStorage();

    public static HayStorage getInstance() {
        return instance;
    }

    public synchronized void addHay(int amount) {
        quantity += amount;
    }

    public synchronized boolean removeHay(int amount) {
        if (quantity < amount) return false;
        quantity -= amount;
        return true;
    }

    public synchronized int getHayQuantity() {
        return quantity;
    }
}