package main.com.isatimur.ocp.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by tisachenko on 30.05.16.
 */
public class LoadTesting {

    public static void main(String[] args) {
        BlockingQueue<Request> queue = new ArrayBlockingQueue<>(3);

        Client client = new Client(queue);
        Server server = new Server(queue);

        new Thread(client).start();
        new Thread(server).start();

    }

}

class Request {
    @Override
    public String toString() {
        return Thread.currentThread().getName();
    }
}

class Client implements Runnable {
    private BlockingQueue<Request> queue;

    public Client(BlockingQueue<Request> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Request request = null;
            while (true) {
                request = new Request();
                queue.put(request);
                System.out.println("added request: " + request);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
}

class Server implements Runnable {

    private BlockingQueue<Request> queue;

    public Server(BlockingQueue<Request> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("processing .. " + queue.take());
            }
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}