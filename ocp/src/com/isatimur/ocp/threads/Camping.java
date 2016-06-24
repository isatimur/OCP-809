package com.isatimur.ocp.threads;

/**
 * Created by tisachenko on 25.05.16.
 */
public class Camping {
    public static void main(String[] args) {
        Friend timur = new Friend();
        GoRafting rafting = new GoRafting(timur);
        rafting.start();
        timur.start();
    }
}

class GoRafting extends Thread {
    private Friend friend;

    public GoRafting(Friend friend) {
        this.friend = friend;
    }

    @Override
    public void run() {
        synchronized (friend) {
            try {
                friend.wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("Reached:" + friend.reached + ", going rafting");
        }
    }
}

class Friend extends Thread {
    boolean reached = false;

    @Override
    public void run() {
        while (!reached) {
            try {
                Thread.sleep(20000);

            } catch (InterruptedException e) {
                System.out.println(e);
            }
            confirmReached();
        }
    }

    private synchronized void confirmReached() {
        reached = true;
        notify();
    }
}
