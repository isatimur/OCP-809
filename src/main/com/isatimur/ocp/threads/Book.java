package main.com.isatimur.ocp.threads;

/**
 * Created by tisachenko on 22.05.16.
 */
public class Book {
    String title;
    int counterSold = 0;

    public Book(String title) {
        this.title = title;
    }

    synchronized public void returnBook() {
        --counterSold;
    }

    public synchronized void newSale() {
        ++counterSold;
    }
}
