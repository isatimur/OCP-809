package main.com.isatimur.ocp.concurrency;

/**
 * Created by Isa Timur on 6/12/16.
 */
public class Reminder implements Runnable {
    @Override
    public void run() {
        System.out.println("All mails sent!");
    }
}
