package com.isatimur.ocp.threads;

/**
 * Created by tisachenko on 22.05.16.
 */
public class MyBook {
    double rank = 0;
    int copiesSold = 0;

    Object objSale = new Object();
    Object objPos = new Object();

    public void newSale() {
        synchronized (objSale) {
            ++copiesSold;
        }

    }

    public void rankImprove() {
        synchronized (objPos) {
            --rank;
        }
    }
}
