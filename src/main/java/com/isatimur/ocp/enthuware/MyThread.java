package com.isatimur.ocp.enthuware;

public class MyThread extends Thread {

    // Although, logically MyClass should implement Runnable but remember that class Thread also implements Runnable. So if MyClass extends Thread, it indirectly implements Runnable.
    Thread t = new Thread(new MyThread(""));

    String msg = "default";

    public MyThread(String s) {
        msg = s;
    }

    public void run() {
        System.out.println(msg);
    }

    public static void main(String args[]) {
        new MyThread("String1").run();// start - не сможем определить порядок вывода
        new MyThread("String2").run();// run - вызовет метод!!!
        System.out.println("end");
    }
}