package com.isatimur.ocp.enthuware.interfaces_jav8;

import java.nio.file.Path;
import java.nio.file.Paths;

class MyRunnable implements Runnable {




    MyRunnable(String name) {
        new Thread(this, name).start();
    }

    public void run() {

        Path p1 = Paths.get("\\personal\\readme.txt");
        Path p2 = Paths.get("\\index.html");
        Path p3 = p1.relativize(p2);

        System.out.println(p3);

        System.out.println(Thread.currentThread().getName());
    }
}

public class TestClass {
    public static void main(String[] args) {
        Thread.currentThread().setName("MainThread");
        MyRunnable mr = new MyRunnable("MyRunnable");
        mr.run();
    }
}