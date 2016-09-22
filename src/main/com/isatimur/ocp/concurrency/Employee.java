package main.com.isatimur.ocp.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tisachenko on 07.06.16.
 */
public class Employee extends Thread {
    Bus bus;
    String name;

    public Employee(Bus bus, String name) {
        this.bus = bus;
        this.name = name;
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        Employee employee = new Employee(bus, "Paulinio");
        employee.start();
        employee.interrupt();

        Employee employeeM = new Employee(bus, "Maurizio");
        employeeM.start();
//        employeeM.interrupt();

    }

    @Override
    public void run() {
        try {
            bus.lock.lockInterruptibly();
            try {
                bus.boardBus(name);
            }
            finally {
                bus.lock.unlock();
            }
        }
        catch (InterruptedException e) {
            System.out.println(name + " : Interrupted!");
            Thread.currentThread().interrupt();
        }
    }
}

class Bus {
    Lock lock = new ReentrantLock();

    public void boardBus(String name) {
        System.out.println(name + ": boared");
    }

}


