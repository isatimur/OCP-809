package com.isatimur.ocp.threads;

import java.util.Set;

/**
 * Created by tisachenko on 15.05.16.
 */
public class LifecycleExample {
    public static void main(String[] args) {
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        for(Thread thread: threadSet){
            System.out.println(thread+"----------------------"+ thread.getState());
        }

    }

}
