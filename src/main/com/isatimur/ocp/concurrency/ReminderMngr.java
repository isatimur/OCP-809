package main.com.isatimur.ocp.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Isa Timur on 6/12/16.
 */
public class ReminderMngr {

    ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
    Reminder reminder = new Reminder();

    public static void main(String[] args) {
        ReminderMngr mngr = new ReminderMngr();
        mngr.sendReninders();
    }

    public void sendReninders() {
        service.scheduleAtFixedRate(reminder, 0, 24, TimeUnit.SECONDS);
    }
}
