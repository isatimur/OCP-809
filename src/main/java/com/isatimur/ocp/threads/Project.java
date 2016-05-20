package com.isatimur.ocp.threads;

/**
 * Created by tisachenko on 20.05.16.
 */
public class Project {
    public static void main(String[] args) {
        ScreenDesign design = new ScreenDesign();
        design.start();
        Developer dev = new Developer(design);
        dev.code();
    }
}

class ScreenDesign extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);

        }
    }


}

class Developer {
    ScreenDesign design;

    public Developer(ScreenDesign design) {
        this.design = design;
    }

    public void code() {
        try {
            System.out.println("Waiting for design to complete");
            design.join();
            System.out.println("Coding phase start");

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}