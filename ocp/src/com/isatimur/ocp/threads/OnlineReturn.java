package com.isatimur.ocp.threads;

/**
 * Created by tisachenko on 22.05.16.
 */
public class OnlineReturn extends Thread {
    private Book book;

    public OnlineReturn(Book book) {
        this.book = book;
    }

    @Override
    public void run() {
        book.returnBook();
        System.out.println(book.counterSold);
    }
}
