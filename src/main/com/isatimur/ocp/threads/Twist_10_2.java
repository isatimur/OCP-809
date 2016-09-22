package main.com.isatimur.ocp.threads;

/**
 * Created by tisachenko on 20.05.16.
 */
public class Twist_10_2 {
    public static void main(String[] args) {
        Thread sing = new Sing();
        sing.start();
        throw new RuntimeException("main");
    }

}

class Sing extends Thread {
    @Override
    public void run() {
        System.out.println("Singing...");
        throw new RuntimeException("run");
    }
}