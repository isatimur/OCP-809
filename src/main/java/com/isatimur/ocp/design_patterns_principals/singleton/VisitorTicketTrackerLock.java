package com.isatimur.ocp.design_patterns_principals.singleton;

// use double‐checked locking
public class VisitorTicketTrackerLock {

    private static volatile VisitorTicketTrackerLock instance;

    private VisitorTicketTrackerLock() {}

    public static VisitorTicketTrackerLock getInstance() {
        if (instance == null) {
            synchronized (VisitorTicketTrackerLock.class) {
                if (instance == null) {
                    instance = new VisitorTicketTrackerLock();
                }
            }
        }
        return instance;
    }
}