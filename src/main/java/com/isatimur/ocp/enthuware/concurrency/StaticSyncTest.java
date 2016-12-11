package com.isatimur.ocp.enthuware.concurrency;

public class StaticSyncTest {
    int sum = 0;

    public synchronized void add(int x) {
        sum = sum + x;
    }

    public static synchronized void add(StaticSyncTest sst, int x) {
        sst.sum = sst.sum + x;
    }

    public static final StaticSyncTest sst = new StaticSyncTest();

    public static void main(String[] args) throws Exception {
        Thread t = new Thread() {
            public void run() {
                StaticSyncTest.add(sst, 10);
            }
        };
        t.start();
        sst.add(10);
        t.join();
        System.out.println(sst.sum);
    }
}