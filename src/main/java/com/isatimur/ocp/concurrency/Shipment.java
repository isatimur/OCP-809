package com.isatimur.ocp.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tisachenko on 06.06.16.
 */
public class Shipment extends Thread {
    Inventory loc1, loc2;
    int qty;


    public Shipment(Inventory loc1, Inventory loc2, int qty) {
        this.loc1 = loc1;
        this.loc2 = loc2;
        this.qty = qty;
    }

    @Override
    public void run() {
        if (loc1.lock.tryLock()) {
            if (loc2.lock.tryLock()) {

                loc2.stockOut(qty);
                loc1.stockIn(qty);
                System.out.println(loc1.inStock + ":" + loc2.inStock);
                loc2.lock.unlock();
                loc1.lock.unlock();

            } else {
                System.out.println("Locking 2 false: " + loc2.name);
            }
        } else {
            System.out.println("Locking 1 false: " + loc1.name);
        }
    }

    public static void main(String[] args) {
        Inventory loc1 = new Inventory("Seattle");
        loc1.inStock = 100;
        Inventory loc2 = new Inventory("LA");
        loc2.inStock = 200;

        Shipment s1 = new Shipment(loc1,loc2,1);
        Shipment s2 = new Shipment(loc2,loc1,10);

        s1.start();
        s2.start();

    }
}

class Inventory {
    int inStock;
    String name;
    Lock lock = new ReentrantLock();

    public Inventory(String name) {
        this.name = name;
    }

    public void stockIn(long qty) {
        inStock += qty;
    }

    public void stockOut(long qty) {
        inStock -= qty;
    }
}