package com.isatimur.ocp.design_patterns_principals.singleton;

/**
 * Created by Isa Timur on 7/25/16.
 */
public class VisitorTicketTrackerSync {
    private static volatile VisitorTicketTrackerSync instance;

    private VisitorTicketTrackerSync() {
    }

    public static VisitorTicketTrackerSync getInstance() {
        if (instance == null) {
            synchronized (VisitorTicketTrackerSync.class) {
                if (instance == null) {
                    instance = new VisitorTicketTrackerSync();
                }
            }
        }
        return instance;
    }
}
